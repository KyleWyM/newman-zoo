package com.newman.game;

import com.newman.animals.ManageAnimals;
import com.newman.complaints.ComplaintChecker;
import com.newman.employees.ManageEmployees_SinglePlayer;
//import com.newman.giftshop.GiftShop;
import com.newman.giftshop.GiftShop;
import com.newman.player.PlayerStats;

import ibio.IBIO;

import static com.newman.game.TicketAlgorithm.setTicket_price;
import static com.newman.giftshop.GiftShop.manage_shops;

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
            {"manage animals", "examine and buy new animals"},
            {"manage employees", "examine and hire new employees"},
            {"manage shops", "examine and upgrade shops"},
            {"set ticket price", "set ticket price to optimize your profits"},
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
            case "manage animals":
            case "2":
                ManageAnimals.manage_animals();
                break;
            case "manage employees":
            case "3":
                ManageEmployees_SinglePlayer.manage_employees();
                break;
            case "manage shops":
            case "4":
                manage_shops();
                break;
            case "set ticket price":
            case "5":
                setTicket_price();
                break;
            case "report":
            case "6":
                IBIO.output("Bank Account: $" + PlayerStats.money);
                IBIO.output("Reputation: " + PlayerStats.reputation);
                ComplaintChecker.listComplaints();
                break;
            case "next":
            case "7":
                //Ends the current turn by ending the turn loop in the Main
                //Only works for turn based version
                if (!Main.inRealTime) {
                    Main.turnInProcess = false;
                } else IBIO.output("Must be in turn based mode for 'next' to work");
                break;
            case "quit":
            case "8":
                //This is for ending the game.
                IBIO.output("Are you sure you would like to end the game?");
                if (AskUser.yesOrNo()) {
                    //yesOrNo() ask the user to respond 'yes' or 'no', and returns true for yes.
                    //So if true, runGame is set false, ending the game
                    Main.turnInProcess = false;
                    Main.runGame = false;
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
