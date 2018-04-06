package com.newman.game;

import com.newman.saves.ManageSaves;
import com.newman.player.PlayerStats;

import ibio.*;

import java.util.ArrayList;

public class Main {
    public static boolean runGame = true;
    public static boolean turnInProcess = true;
    public static boolean newGame = false; //New game unless save is loaded
    public static String input;
    //It's not necessary to put the input string here,
    //but it's better not to redefine a variable every time the loop is run.

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
        IBIO.output("Turn ended");
            /*
             * In here we include all things that should be updated daily
             * For example:
             *
             * - Random events
             * - Money, revenue, and expenses
             * - Experience points
             * - Reputation
             *
             * In addition, if we decide to make the game real time, we can include an actual game loop in this class.
             */

        //e.g. import com.newman.random_events
        // Random_total.method();

        PlayerStats.turnNum++;
        PlayerStats.money += 5;
    }

    public static void main(String[] args) {

        ManageSaves.loadSave(save_path);
        if (newGame) {
            //If loadSave() does not load a previous game, it will set newGame to true.
            intro();
        }

        while(runGame) {
            while(turnInProcess) {
                //During the process of a turn, this loops through and gathers user input.
                input = IBIO.input();
                CommandListener.takeCommand(input.toLowerCase());
            }

            update(); //This calls updates the game after every turn with changes, such as adding to turnNum
            turnInProcess = true; //This allows for the next turn
        }

        end();

    }
}
