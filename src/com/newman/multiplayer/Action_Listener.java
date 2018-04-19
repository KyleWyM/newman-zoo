package com.newman.multiplayer;


import com.newman.game.Autocorrect;
import com.newman.game.MainSinglePlayer;

public class Action_Listener {

    //This is a list of all commands for use in the help command
    //Each command contains a name, and then a description.
    //The first number is the number of the command
    //Second number is either 0 or 1. 0 indicates name,
    //While 1 indicates description.
    //
    //Commands listed here:

    public static void getInput(Client client, String line) {
        int client_index = client.client_index;
        if (line.substring(0, 1).equals("/")) {
            command(client, line.substring(1));
        } else {
            try {
                String username = Multiplayer_Manager.clients.get(client_index).getUsername() + ": ";
                Multiplayer_Manager.broadcast(client_index, username + line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy animal", "buys an animal of a specific type."},
            {"report", "displays daily report_command."},
            {"animals", "lists all owned animals."},
            {"species", "lists all species available."},
            {"next", "ends the turn."},
            {"attack", "attack another player"},
            {"quit", "quits the game."},
            {"accept", "accepts fight invitation"}
    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public static void command(Client client, String command) {
//        int index = line.indexOf(" ") + 1;
//        String command = line.substring(0, index);
//        line = line.substring(index);

        int client_index = client.client_index;

        String msg; //A string used for general output purposes in the following

        switch (command.toLowerCase()) {
            case "help":
                for (int i = 0; i < command_list.length; i++) {

                    msg = String.format("%2d. %-20s %s",
                            i + 1, command_list[i][0], command_list[i][1]);
                    Multiplayer_Manager.println(client_index, msg);
                }
                break;
            case "report":
                msg = "Bank Account (Zooman Dollars): " + client.player.getMoney();
                Multiplayer_Manager.println(client_index, msg);
                msg = "Level: " + client.player.getLevel();
                Multiplayer_Manager.println(client_index, msg);
                msg = "Reputation: " + client.player.getReputation();
                Multiplayer_Manager.println(client_index, msg);
                break;
            case "buy animal":
                ManageAnimals.buyCommand(client);
                break;
            case "animals":
                ManageAnimals.my_animals(client);
                break;
            case "species":
                ManageAnimals.species_list(client);
                break;
            case "attack":
                Fight_Handler.startBattle(client_index);
                break;
            case "accept":
                client.acceptFight = true;
                while (client.acceptFight) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                }
//                client.listeningOn = false;
                client.println("You have accepted the fight.");
                break;
            case "next":
                if (client.player.hasAdminRights()) {
                    GameLoop.dayNum++;
                    GameLoop.globalTime += GameLoop.dayLength;
                    Multiplayer_Manager.broadcast("Day: " + GameLoop.dayNum);
                } else client.println("Access denied.");
                break;
            case "quit":
                //This is for ending the game.
                if (client.player.hasAdminRights()) {
                    client.println("Are you sure you would like to end the game?");
                    if (AskUser.yesOrNo(client_index)) {
                        //yesOrNo() ask the user to respond 'yes' or 'no', and returns true for yes.
                        //So if true, runGame is set false, ending the game
                        MainSinglePlayer.runGame = false;
                        //TODO add saves
//                    ManageSaves.writeSave(Main.save_path);
                    } else client.println("Access denied.");
                }
                break;
            default:
                String bestMatch = Autocorrect.findMatch(command, command_list);
                msg = "Did you mean " + bestMatch + "?";
                Multiplayer_Manager.println(client_index, msg);
                if (AskUser.yesOrNo(client_index)) {
                    command(client, bestMatch);
                }
        }
    }
}
