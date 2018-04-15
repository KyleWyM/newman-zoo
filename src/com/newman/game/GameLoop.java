package com.newman.game;

import com.newman.multiplayer.Multiplayer_Manager;
import com.newman.player.Player;


class timedCycle extends Thread {
    public void run() {
        GameLoop.gameTimeLoop(); //Runs the timed game cycle in this thread
    }
    //This thread allows the game time cycle to run in parallel to the command listener.
}

public class GameLoop {
    private static double startTime = System.nanoTime() * 1e-9;
    private static double currentTime;
    private static double changeInTime;

    public static double dayLength = 60;
    private static double timeIntoDay; //E.g. 1 day and 40 ticks.

    private static int targetTime = 1; //How many seconds long is a game cycle or game tick?
    public static int globalTime = 0; //The global time for the entire game in seconds
    public static int dayNum;


    public static void gameTimeLoop() {

        while (Multiplayer_Main.GameHasBegan) {
            currentTime = System.nanoTime() * 1e-9;
            changeInTime = currentTime - startTime;

            if (changeInTime > targetTime) {
                startTime = System.nanoTime() * 1e-9;
                update();
            }
        }
    }

    private static void update() {
        globalTime++; //Adds one second to globalTime
        timeIntoDay = globalTime % dayLength;

        if (timeIntoDay == dayLength - 1) {
            dayNum++;
            Multiplayer_Manager.broadcast("Day: " + dayNum);
        }

        for (int i = 0; i < Multiplayer_Manager.clients.size(); i++) {
            Player player = Multiplayer_Manager.clients.get(i).player;
            player.update(Multiplayer_Manager.clients.get(i));
        }
    }

    public static void startTimeCycle() {
        timedCycle thread_1 = new timedCycle();
        thread_1.start();
    }
}
