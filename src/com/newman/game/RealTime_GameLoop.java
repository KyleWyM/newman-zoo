package com.newman.game;

import ibio.*;

import com.newman.player.PlayerStats;

class RealTime_timedCycle extends Thread {
    public void run() {
        RealTime_GameLoop.timeCycle(); //Runs the timed game cycle in this thread
    }
    //This thread allows the game time cycle to run in parallel to the command listener.
}

class RealTime_commandListener extends Thread {
    public void run() {
        while (Main.runGame) {
            CommandListener.getInput();
        }
    }
}

public class RealTime_GameLoop {
    private static double startTime = System.nanoTime() * 1e-9;
    private static double currentTime;
    private static double changeInTime;

    private static double dayLength = 60;
    private static double timeIntoDay; //E.g. 1 day and 40 ticks.

    private static int targetTime = 1; //How many seconds long is a game cycle or game tick?
    public static int globalTime = 0; //The global time for the entire game in seconds


    public static void timeCycle() {

        while (Main.runGame) {
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
            PlayerStats.dayNum++;
            IBIO.output("Day: " + PlayerStats.dayNum);
        }
    }

    public static void startTimeCycle() {
        RealTime_timedCycle thread_1 = new RealTime_timedCycle();
        thread_1.start();

        RealTime_commandListener thread_2 = new RealTime_commandListener();
        thread_2.start();
    }
}
