package com.newman.saves;

import com.newman.animals.Animals;
import com.newman.game.MainSinglePlayer;
import com.newman.game.RealTime_GameLoop;
import com.newman.player.PlayerStats;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;

public class Writer {

    public static void eraseSave(String file_path) throws IOException {
        FileWriter file_writer = new FileWriter(file_path,false);
        PrintWriter print_writer = new PrintWriter(file_writer);
        print_writer.print("");
        print_writer.close();
    }

    public static void saveGame(String name, int turnNum, int money,
                                int reputation, List<Animals> animals, String file_path) throws IOException {

        FileWriter file_writer = new FileWriter(file_path,true);
        PrintWriter print_writer = new PrintWriter(file_writer);
        print_writer.println("Name: [" + name + "] &&&");
        print_writer.println("Turn Number: " + turnNum);
        print_writer.println("Money: " + money);
        print_writer.println("Reputation: " + reputation);

        int inRealTime = 0; //0 indicates false
        if (MainSinglePlayer.inRealTime) {
            inRealTime = 1;
            print_writer.println("GameMode: " + "[" + inRealTime
                    + "," + RealTime_GameLoop.globalTime + "] &&&");
        } else {
            print_writer.println("GameMode: " + "[" + inRealTime
                    + "," + PlayerStats.dayNum + "] &&&");
        }

        print_writer.print("Animals: ");
        for (int i = 0; i < animals.size(); i++) {
            print_writer.print("[" + animals.get(i).species + "," + animals.get(i).name
                    + "," + animals.get(i).maintenance + "," + animals.get(i).reputation
                    + "," + animals.get(i).birthTime + "," + animals.get(i).level + "] ");
        }

        print_writer.print("&&&");
        print_writer.close();
    }
}
