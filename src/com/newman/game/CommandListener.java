package com.newman.game;

import com.newman.animals.ManageAnimals_SinglePlayer;
import com.newman.player.PlayerStats;
import com.newman.saves.ManageSaves;

import ibio.IBIO;

public class CommandListener {

    //This is a list of all commands for use in the help command
    //Each command contains a name, and then a description.
    //The first number is the number of the command
    //Second number is either 0 or 1. 0 indicates name,
    //While 1 indicates description.
    //
    //Commands listed here:

    public static void getInput() {
        MainSinglePlayer.input = IBIO.input();
        CommandListener.takeCommand(MainSinglePlayer.input.toLowerCase());
    }

    public static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy animal", "buys an animal of a specific type."},
            {"owned animals", "lists all owned animals."},
            {"species", "lists all species available."},
            {"hire employee", "hires employee"},
            {"train employee", "trains employee"},
            {"list employees", "list all employees"},
            {"report", "displays daily report_command."},
            {"next", "ends the turn."},
            {"quit", "quits the game."}
    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public static void takeCommand(String command) {
        switch (command) {
            case "help":
            case "h":
            case "1":
                for (int i = 0; i < command_list.length; i++) {

                    String message = String.format( "%2d. %-20s %s",
                            i + 1, command_list[i][0], command_list[i][1]);
                    IBIO.output(message);
                }
                break;
            case "buy animal":
            case "2":
                ManageAnimals_SinglePlayer.buyCommand();
                break;
            case "animals":
            case "3":
                ManageAnimals_SinglePlayer.my_animals();
                break;
            case "species":
            case "4":
                ManageAnimals_SinglePlayer.species_list();
                break;
            case "report":
            case "8":
                IBIO.output("Bank Account (Zooman Dollars): " + PlayerStats.money);
                IBIO.output("Reputation: " + PlayerStats.reputation);
                break;
            case "next":
            case "9":
                //Ends the current turn by ending the turn loop in the Main
                //Only works for turn based version
                if (!MainSinglePlayer.inRealTime) {
                    MainSinglePlayer.turnInProcess = false;
                } else IBIO.output("Must be in turn based mode for 'next' to work");
                break;
            case "quit":
            case "10":
                //This is for ending the game.
                IBIO.output("Are you sure you would like to end the game?");
                if (AskUser_old.yesOrNo()) {
                    //yesOrNo() ask the user to respond 'yes' or 'no', and returns true for yes.
                    //So if true, runGame is set false, ending the game
                    MainSinglePlayer.turnInProcess = false;
                    MainSinglePlayer.runGame = false;

                    ManageSaves.writeSave(MainSinglePlayer.save_path);
                }
                break;
            default:
                String bestMatch = Autocorrect.findMatch(command, command_list);
                IBIO.output("Did you mean " + bestMatch + "?");
                if (AskUser_old.yesOrNo()) {
                    takeCommand(bestMatch);
                }
        }
    }

}
