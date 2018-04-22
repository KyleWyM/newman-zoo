package com.newman.saves;

import java.io.*;

import ibio.*;

import com.newman.game.Main;
import com.newman.game.AskUser;
import com.newman.player.PlayerStats;

public class ManageSaves {
    public static void loadSave(String save_path) {
        boolean userHasResponded = false;
        while(!userHasResponded) {
            IBIO.output("Would you like to load data from a save?");
            if (AskUser.yesOrNo()) {
                try {
                    Reader.save_reader(save_path);
                    userHasResponded = true;
                } catch (IOException e) {
                    IBIO.output("Failed to load data.");
                }
            } else {
                IBIO.output("A new game will begin.");
                Main.newGame = true;
                userHasResponded = true;
            }
        }
    }

    public static void writeSave(String save_path) {
        String message = "Would you like to save the game?";
        IBIO.output(message);
        if (AskUser.yesOrNo()) {
            try {
                Writer.eraseSave(save_path);
                Writer.saveGame(PlayerStats.name, PlayerStats.dayNum, PlayerStats.money,
                        PlayerStats.reputation, PlayerStats.myAnimals, save_path);
            } catch (IOException e) {
                IBIO.output("Failed to save data.");
            }
        }
    }
}
