package com.newman.saves;

import com.newman.game.Main;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Reader {
    public static void load_data() {
        SaveObject game_data;
        boolean gameSelected = false;
        //Indicates whether a save or new game has been successfully selected and loaded

        System.out.println("\n\tWELCOME TO NEWMAN ZOO");
        System.out.println("\n\t1. New Game\n\t2. Save1.ser\n\t3. Save2.ser\n\t4. Save3.ser");
        System.out.println("\nPlease enter the number of the save you would like to load");
        String save_path;
        Scanner sc = new Scanner(System.in);

        while (!gameSelected) {
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    Main.save_path = "new game";
                    System.out.println("New game created.");
                    Main.newGame = true;
                    gameSelected = true;
                    break;
                case 2:
                    save_path = "Saves/Save1.ser";
                    game_data = read_file(save_path);
                    game_data.loadDataToGame();
                    System.out.println("Game loaded!");
                    gameSelected = true;
                    break;
                case 3:
                    save_path = "Saves/Save2.ser";
                    game_data = read_file(save_path);
                    game_data.loadDataToGame();
                    System.out.println("Game loaded!");
                    gameSelected = true;
                    break;
                case 4:
                    save_path = "Saves/Save3.ser";
                    game_data = read_file(save_path);
                    game_data.loadDataToGame();
                    System.out.println("Game loaded!");
                    gameSelected = true;
                    break;
                default:
                    System.out.println("Please enter a valid int.");
            }
        }
    }

    public static SaveObject read_file(String save_path) {
        SaveObject game_data = null;

        try {
            FileInputStream fs = new FileInputStream(save_path);
            ObjectInputStream is = new ObjectInputStream(fs);
            game_data = (SaveObject) is.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Save is empty or corrupt.");
        }

        return game_data;
    }
}
