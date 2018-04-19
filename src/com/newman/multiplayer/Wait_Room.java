package com.newman.multiplayer;

import java.io.IOException;
import java.net.Socket;

public class Wait_Room extends Thread {
    private int client_index = Multiplayer_Manager.clients.size(); //The first player who joins will be player 1. Player 0 is the host
    private Socket connection;
    public boolean allowNewConnections = true;

    public void run() {
        do {
            try {
                connection = Host.server.accept();
                if (allowNewConnections) {
                    System.out.println("A new user has joined the game!");
                    Client client = new Client(connection, client_index);
                    Multiplayer_Manager.clients.add(client);
                    client_index = Multiplayer_Manager.clients.size();
                    //This will give the next player to join the next player number
                } else {
                    System.out.println(connection.getInetAddress() + " denied access to join game.");
                    connection.close();
                }

            } catch (IOException e) {
                System.out.println("Error in waiting room.");
            }
        } while(!Multiplayer_Main.GameHasBegan);
    }
}
