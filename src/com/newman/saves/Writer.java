package com.newman.saves;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Writer {
    public static void save_game() {
        SaveObject game_data = new SaveObject();
        if (game_data.getSave_path().equals("new game")) {
            //If the game is new, then it does not have a save path assigned,
            //so one must be selected and written on.
            if (overwrite_save(game_data)) {
                write_data(game_data);
            } else {
                System.out.println("Game not saved.");
            }
        } else {
            write_data(game_data);
        }
    }

    public static void write_data(SaveObject game_data) {
        try {
            String save_path = game_data.getSave_path();
            FileOutputStream fs = new FileOutputStream(save_path);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(game_data);
            os.close();
            System.out.println("The game has been saved.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to save game...");
        }
    }

    public static boolean overwrite_save(SaveObject game_data) {
        boolean savepathSelected = false; //This signifies whether the user has cancelled or not
        boolean userResponded = false;
        //The game will keep prompting user for save path until one is correctly specified

        System.out.println("Please choose the save path you want to " +
                "write the new game in:");
        System.out.println("\n\t0. Do not save \n\t1. Save 1\n\t2. Save 2\n\t3. Save 3");
        Scanner sc = new Scanner(System.in);

        String save_path;
        while (!userResponded) {
            int input = sc.nextInt();

            switch (input) {
                case 0:
                    System.out.println("Game not saved.");
                    userResponded = true;
                    break;
                case 1:
                    save_path = "Saves/Save1.ser";
                    game_data.setSave_path(save_path);
                    savepathSelected = true;
                    userResponded = true;
                    break;
                case 2:
                    save_path = "Saves/Save2.ser";
                    game_data.setSave_path(save_path);
                    savepathSelected = true;
                    userResponded = true;
                    break;
                case 3:
                    save_path = "Saves/Save3.ser";
                    game_data.setSave_path(save_path);
                    savepathSelected = true;
                    userResponded = true;
                    break;
                default:
                    System.out.println("Please enter a valid int.");
            }
        }
        return savepathSelected;
    }
}
