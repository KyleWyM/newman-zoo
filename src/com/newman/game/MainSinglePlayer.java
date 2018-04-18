package com.newman.game;

import com.newman.saves.ManageSaves;
import com.newman.player.PlayerStats;

import java.util.concurrent.ThreadLocalRandom;

import ibio.*;

import static com.newman.player.PlayerStats.*;

public class MainSinglePlayer {
    public static boolean runGame = true;
    public static boolean turnInProcess = true;
    public static boolean newGame = false; //New game unless save is loaded
    public static String input;
    //It's not necessary to put the input string here,
    //but it's better not to redefine a variable every time the loop is run.

    public static boolean inRealTime;

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
    static int total_maintenance = 0;
    static int total_income = 0;
    public static void update() {
        IBIO.output("Turn ended");
        int size;
        size = myAnimals.size();
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
        dayNum++;
        PlayerStats.money += 5;
        total_income = 0;
        total_maintenance = 0;
        int randomNum = ThreadLocalRandom.current().nextInt(reputation*4, (reputation*8)+1);
        for (int i = 0; i < size; i++) {
            total_income = total_income + randomNum;
        }
        money = money + total_income;
        if (total_income != 0) {
            IBIO.output(String.format("You have earned %d dollars in ticket sales!", total_income));
        }
        for (int i = 0; i < size; i++) {
            total_maintenance = total_maintenance + myAnimals.get(i).maintenance;
        }
        money = money - total_maintenance;
        if (total_maintenance != 0) {
            IBIO.output(String.format("You have paid %d dollars to feed your animals", total_maintenance));
        }
    }

    public static void main(String[] args) {

        ManageSaves.loadSave(save_path);
        if (newGame) {
            IBIO.output("Would you like to run a real time game or a turn based game?\n" +
                    "y = real time, n = turn based");
            if (AskUser_old.yesOrNo()) {
                RealTime_GameLoop.startTimeCycle();
                inRealTime = true;
            } else {
                TurnBased_GameLoop.startTurnCycle();
                inRealTime = false;
            }

            //If loadSave() does not load a previous game, it will set newGame to true.
            intro();
        } else {
            if (inRealTime) {
                RealTime_GameLoop.startTimeCycle();
            } else TurnBased_GameLoop.startTurnCycle();
        }

        end();
    }
}
