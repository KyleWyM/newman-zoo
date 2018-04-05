package com.newman.game;

import com.newman.animals.BuyAnimal;
import com.newman.player.PlayerStats;
import ibio.IBIO;

public class CommandListener {

    //This is a list of all commands for use in the help command
    //Each command contains a name, and then a description.
    //The first number is the number of the command
    //Second number is either 0 or 1. 0 indicates name,
    //While 1 indicates description.
    //
    //Commands listed here:

    public static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy animal", "buys an animal of a specific type."},
            {"report", "displays daily report_command."},
            {"animals", "lists all owned animals."},
            {"list", "lists all species available."},
            {"next", "ends the turn."},
            {"hire employee", "hires employee"},
            {"train employee", "trains employee"},
            {"list employees", "list all employees"},
            {"quit", "quits the game."}
    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public void takeCommand(String command) {
        switch (command) {
            case "help":
                break;
            case "report":
                IBIO.output("Bank Account (Zewman Dollars): " + PlayerStats.money);
                IBIO.output("Reputation: " + PlayerStats.reputation);
                break;
            case "buy animal":
                BuyAnimal.buyCommand();
                break;
            case "animals":
                break;
            case "list":
                break;
            case "next":
                break;
            case "hire employee":
                break;
            case "train employee":
                break;
            case "list employees":
                break;
            case "quit":
                break;
            default:
        }
    }

}
