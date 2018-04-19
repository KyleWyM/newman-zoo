package com.newman.multiplayer;

import com.newman.player.Player;
import com.newman.animals.Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client extends Thread {
    private int ID;
    public int client_index;
    public boolean isConnected;
//  public boolean listeningOn;
    private Socket conn;

    private PrintWriter out;
    private BufferedReader in;

    private String username;

    public Player player;

    public boolean queuedForFight;
    public boolean acceptFight;

    public Client(Socket conn, int client_index) {
        //Get new user ID and check to see if it already exists
        int newID = 1;
        boolean ID_confirmed = false;
        boolean ID_taken;
        while (!ID_confirmed) {
            ID_taken = false;
            newID = (int) (Math.random() * 1000000 + 100000);
            for (int i = 0; i < Multiplayer_Manager.clients.size(); i++) {
                if (Multiplayer_Manager.clients.get(i).getID() == newID) {
                    ID_taken = true;
                }
            }

            if (ID_taken) {
                ID_confirmed = false;
            } else ID_confirmed = true;
        }

        try {
            this.out = new PrintWriter(conn.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } catch (Exception e) {
            System.out.println("Unable to establish I/O for user index " + client_index);
            e.printStackTrace();
        }

        this.ID = newID;
        this.conn = conn;
        this.isConnected = true;
        this.client_index = client_index;
        this.username = "User" + ID;
//        this.listeningOn = true;
        createNewPlayer();

        this.queuedForFight = false;
        this.acceptFight = false;
    }

    public void run() {
        try {
            this.username = login();
            Multiplayer_Manager.broadcast(client_index, username + " has joined the game.");
        } catch (Exception e) {
            System.out.println("Unable to add " + ID);
            e.printStackTrace();
        }

        //First animal
        println("Give the name of your first animal: ");
        String name = readLine();
        Animals firstAnimal = Species.addFlamingo(this, name, GameLoop.globalTime);
        player.myAnimals.add(firstAnimal);

        String input;
        try {
            while ((input = readLine()) != null) {
                Action_Listener.getInput(this, input);
//                while (!listeningOn) ; //The player's input is not received until listening is turned back on
//                //This is useful for fights
            }
        } catch (Exception e) {
            System.out.println("Connection interrupted with " + username);
        }

        handle_disconnect();
    }

    private String login() {
        println("Please choose username: ");

        String newUsername = "";
        boolean username_confirmed = false;
        boolean username_taken;
//        int existingPlayerIndex = 0; //Null
        while (!username_confirmed) {
            username_taken = false;
            newUsername = readLine();

            for (int i = 0; i < Multiplayer_Manager.clients.size(); i++) {
                if (Multiplayer_Manager.clients.get(i).getUsername().equals(newUsername)) {
                    username_taken = true;
//                    existingPlayerIndex = i;
                }
            }

            if (username_taken) {
                username_confirmed = false;
                println("Username already exists.");
            } else username_confirmed = true;
        }

        return newUsername;
    }

    public void createNewPlayer() {
        Player player = new Player(username, 100, 10, 0);
        this.player = player;
    }

    private void handle_disconnect() {
        isConnected = false;
        Multiplayer_Manager.broadcast(client_index, username + " has disconnected.");

        try {
            conn.close();
        } catch (IOException e) {
            System.out.println("Unable to correctly handle disconnection of " + username);
        }
    }

    public void println(String msg) {
        out.println(msg);
    }

    public String readLine() {
        String input = null;
        try {
            input = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public String getUsername() {
        return username;
    }

    public int getID() {
        return ID;
    }
}
