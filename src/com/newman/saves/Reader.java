package com.newman.saves;

import com.newman.game.Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Reader {
    public static void load_data() {
        SaveObject game_data;
        boolean gameSelected = false;
        //Indicates whether a save or new game has been successfully selected and loaded

        System.out.println("\n\tWELCOME TO NEWMAN ZOO");
        System.out.println("\n\t1. New Game\n\t2. Save 1\n\t3. Save 2\n\t4. Save 3");
        System.out.println("\nPlease enter the number of the save you would like to load");
        String save_path;
        Scanner sc = new Scanner(System.in);

        while (!gameSelected) {
            String string_input = sc.nextLine();
            int input;

            try {
                input = Integer.parseInt(string_input);
            } catch (Exception e) {
                input = -1;
            }

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
                    gameSelected = try_loading(game_data);
                    break;
                case 3:
                    save_path = "Saves/Save2.ser";
                    game_data = read_file(save_path);
                    gameSelected = try_loading(game_data);
                    break;
                case 4:
                    save_path = "Saves/Save3.ser";
                    game_data = read_file(save_path);
                    gameSelected = try_loading(game_data);
                    break;
                case -1:
                    System.out.println("Please enter a number!");
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
            System.out.println("Save is empty or corrupt.");
        }

        return game_data;
    }

    public static boolean try_loading(SaveObject game_data) {
        boolean data_loaded = false;
        try {
            game_data.loadDataToGame();
            System.out.println("Game loaded!");
            data_loaded = true;
        } catch (NullPointerException e) {
            System.out.println("Game not loaded. Try a different save or create a new game.\n");
        }
        return data_loaded;
    }
}
