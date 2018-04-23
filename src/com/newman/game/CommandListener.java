package com.newman.game;

import com.newman.animals.ManageAnimals;
import com.newman.employees.ManageEmployees_SinglePlayer;
//import com.newman.giftshop.GiftShop;
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
        Main.input = IBIO.input();
        CommandListener.takeCommand(Main.input.toLowerCase());
    }

    public static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy animal", "buys an animal of a specific type."},
            {"owned animals", "lists all of your owned animals."},
            {"species", "lists all species available."},
            {"manage employees", "examine and hire new employees"},
            {"about giftshop", "gives information about how the giftshop works"},
            {"upgrade giftshop", "allows the user to enhance their giftshop"},
            {"list employees", "list all employees"},
            {"report", "shows your game statistics."},
            {"next", "ends the turn."},
            {"quit", "quits the game."}
    };
    public static void help() {
        for (int i = 0; i < command_list.length; i++) {
            String message = String.format( "%2d. %-20s %s",
                    i + 1, command_list[i][0], command_list[i][1]);
            IBIO.output(message);
        }
    }


    //When a user enters a string, user_interface checks for
    //existing commands
    public static void takeCommand(String command) {
        switch (command) {
            case "help":
            case "h":
            case "1":
                help();
                break;
            case "buy animal":
            case "2":
                ManageAnimals.buy_animal();
                break;
            case "owned animals":
            case "3":
                ManageAnimals.my_animals();
                break;
            case "species":
            case "4":
                ManageAnimals.species_list();
                break;
            case "manage employees":
            case "5":
                ManageEmployees_SinglePlayer.manage_employees();
                break;
            case "about giftshop":
                //GiftShop.intro();
                break;
            case "upgrade giftshop":
                //GiftShop.increaseLevel();
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
                if (!Main.inRealTime) {
                    Main.turnInProcess = false;
                } else IBIO.output("Must be in turn based mode for 'next' to work");
                break;
            case "quit":
            case "10":
                //This is for ending the game.
                IBIO.output("Are you sure you would like to end the game?");
                if (AskUser.yesOrNo()) {
                    //yesOrNo() ask the user to respond 'yes' or 'no', and returns true for yes.
                    //So if true, runGame is set false, ending the game
                    Main.turnInProcess = false;
                    Main.runGame = false;

                    ManageSaves.writeSave(Main.save_path);
                }
                break;
            default:
                String bestMatch = Autocorrect.findMatch(command, command_list);
                IBIO.output("Did you mean " + bestMatch + "?");
                if (AskUser.yesOrNo()) {
                    takeCommand(bestMatch);
                }
        }
    }

}
