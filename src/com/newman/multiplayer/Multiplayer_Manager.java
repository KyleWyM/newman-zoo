package com.newman.multiplayer;

import com.newman.game.AskUser;
import com.newman.player.Player;

import java.util.ArrayList;

public class Multiplayer_Manager {
    public static ArrayList<Client> clients = new ArrayList<>();
    public static ArrayList<Player> players = new ArrayList<>();

    public static void println(int client_index, String msg) {
        clients.get(client_index).println(msg);
    }

    public static String input(int client_index) {
        return clients.get(client_index).readLine();
    }

    //Broadcasted globally to clients except the one who sends it
    public static void broadcast(int client_index, String msg) {
        System.out.println(msg);
        try {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).isConnected && i != client_index) {
                    println(i, msg);
                }
            }
        } catch (Exception e) {
            System.out.println("CONSOLE: Error in broadcasting message from Client_handler.java");
            e.printStackTrace();
        }
    }

    //For broadcasts to all players regardless
    public static void broadcast(String msg) {
        System.out.println(msg);
        try {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).isConnected) {
                    println(i, msg);
                }
            }
        } catch (Exception e) {
            System.out.println("CONSOLE: Error in broadcasting message from Client_handler.java");
            e.printStackTrace();
        }
    }

    public static void load_save() {
        System.out.println("Would you like to load from a previous game?");
        if (AskUser.yesOrNo()) {
            //TODO //Does not work yet
            //Try to load from save
            //Check if player list received from loading save is valid
            //If so, continue

            //Go into game loop and set global time and day number correctly

            //Go through all players and list them out by index.
            //Then go through each connected player and ask which pre-existing player they would like to assign them to
            //(or let them be a new player).
            //Then the game is ready to begin
        }
    }



}
