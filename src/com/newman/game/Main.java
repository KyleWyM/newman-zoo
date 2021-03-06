package com.newman.game;

import com.newman.complaints.ComplaintChecker;
import com.newman.player.PlayerStats;
import com.newman.saves.Reader;
import com.newman.saves.Writer;
import ibio.*;

import static com.newman.animals.ManageAnimals.*;
import static com.newman.employees.Employee.available_employees;
import static com.newman.employees.Employee.reluctant_teenager;
import static com.newman.game.DataCalculations.*;
import static com.newman.game.Random_Events.check_random_events;
import static com.newman.giftshop.GiftShop.runShops;
import static com.newman.player.PlayerStats.*;

public class Main {
    public static boolean runGame = true;
    public static boolean turnInProcess = true;
    public static boolean newGame; //New game unless save is loaded
    public static String input;
    //It's not necessary to put the input string here,
    //but it's better not to redefine a variable every time the loop is run.

    public static boolean inRealTime = false;

    public static String save_path;

    public static void intro() {
        available_employees.add(reluctant_teenager);
        available_animals.add(snake);
        available_animals.add(flamingo);
        available_animals.add(armadillo);

        //This runs at the start of the game
        //i.e. it sets things up and does things that are only executed once
        PlayerStats.name = IBIO.input("** Hello, what is your name?\n");
        String message = "** Welcome to the zoo " + PlayerStats.name +
                ". You are now its owner...\nType 'help' for a list of commands.";
        IBIO.output(message);
    }

    public static void update() {
        dayNum++;
        IBIO.output("Turn ended");
        rent();
        maintenance();
        salaries();
        calculate_visitors();
        ticket_income();
        runShops();
        inspection();
        level_up(reputation);
        check_random_events();
        ComplaintChecker.update();
        lose();
    }

    public static void main(String[] args) {

        Reader.load_data();

        if (newGame) {
            //If loadSave() does not load a previous game, it will set newGame to true.
            intro();
            newGame = false;
        }

        while (Main.runGame) {
            while (Main.turnInProcess) {
                //During the process of a turn, this loops through and gathers user input.
                CommandListener.getInput();
            }
            Main.update(); //This calls updates the game after every turn with changes, such as adding to dayNum

            Main.turnInProcess = true; //This allows for the next turn
        }

        Writer.save_game();
    }
}
