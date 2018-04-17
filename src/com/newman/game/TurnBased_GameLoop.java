package com.newman.game;

import com.newman.animals.Animals;
import com.newman.animals.Species;
import com.newman.animals.Species_SinglePlayer;
import com.newman.player.Player;
import com.newman.player.PlayerStats;
import ibio.IBIO;

import java.util.ArrayList;

import static com.newman.player.PlayerStats.money;
import static com.newman.player.PlayerStats.myAnimals;

class TurnBased extends Thread {
    public void run() {
        TurnBased_GameLoop.turnCycle(); //Runs the game loop cycle in this thread
    }
    //This thread allows the game time cycle to run in parallel to the command listener.
}

public class TurnBased_GameLoop {


    public static void turnCycle() {
        while (MainSinglePlayer.runGame) {
            while (MainSinglePlayer.turnInProcess) {
                //During the process of a turn, this loops through and gathers user input.
                CommandListener.getInput();
            }
            MainSinglePlayer.update(); //This calls updates the game after every turn with changes, such as adding to dayNum

            MainSinglePlayer.turnInProcess = true; //This allows for the next turn
        }
    }

    public static void startTurnCycle() {
        TurnBased thread_1 = new TurnBased();
        thread_1.start();
    }
}
