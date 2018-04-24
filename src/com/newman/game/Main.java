package com.newman.game;

import com.newman.saves.ManageSaves;
import com.newman.player.PlayerStats;
import com.newman.game.TicketAlgorithm;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import ibio.*;

import static com.newman.game.DataCalculations.*;
import static com.newman.game.TicketAlgorithm.ticket_price;
import static com.newman.player.PlayerStats.*;

public class Main {
    public static boolean runGame = true;
    public static boolean turnInProcess = true;
    public static boolean newGame = false; //New game unless save is loaded
    public static String input;
    //It's not necessary to put the input string here,
    //but it's better not to redefine a variable every time the loop is run.

    public static boolean inRealTime = false;

    static String save_path = "Saves/Save1.txt";

    public static void intro() {
        //This runs at the start of the game
        //i.e. it sets things up and does things that are only executed once
        PlayerStats.name = IBIO.input("** Hello, what is your name?\n");
        String message = "** Welcome to the zoo " + PlayerStats.name +
                ". You are now its owner...\nType 'help' for a list of commands.";
        IBIO.output(message);
    }


    public static void end() {
        //This runs at the end of the game
        //i.e. it sets things up and does things that are only executed once at the end
    }

    public static void update() {
        dayNum++;
        IBIO.output("Turn ended");
        rent();
        maintenance();
        ticket_income();
    }

    public static void main(String[] args) {

        ManageSaves.loadSave(save_path);
        if (newGame) {
            //If loadSave() does not load a previous game, it will set newGame to true.
            intro();

            while (Main.runGame) {
                while (Main.turnInProcess) {
                    //During the process of a turn, this loops through and gathers user input.
                    CommandListener.getInput();
                }
                Main.update(); //This calls updates the game after every turn with changes, such as adding to dayNum

                Main.turnInProcess = true; //This allows for the next turn
            }
        }

        end();
    }
}
