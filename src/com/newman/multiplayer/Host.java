package com.newman.multiplayer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class Host {
    private static int minPort = 5000;
    private static int maxPort = 5010;

    public static ServerSocket server = null;

    public static void create_localServer() throws IOException {
        //Find available port within allotted range
        for (int i = minPort; i < maxPort; i++) {
            try {
                server = new ServerSocket(i, 20);
                int localPort = server.getLocalPort();

                if (!(localPort >= minPort && localPort <= maxPort)) {
                    //If the port is not in the selected range, then the port number is given
                    //The client must manually enter the port number because it is not in the searched range
                    //
                    System.out.println("Unable to connect to a port within the given range:");
                    System.out.println(minPort + " : " + maxPort);
                    System.out.println("Instead, the port used is " + server.getLocalPort());
                    System.out.println("Clients will need to manually enter this port number to connect");

                } else {
                    System.out.println("Succesfully connected at port " + localPort);
                }
                break;
            } catch (UnknownHostException e) {
                System.out.println("Unable to create server socket.");
            }
        }
    }

    public static void wait_for_start() {
        Wait_Room wait_room = new Wait_Room();
        wait_room.start();

        System.out.println("Now waiting for players to join...");
        System.out.println("Press 'y' when you are ready to stop waiting and to begin the game.");

        while(!AskUser.yesOrNo());
        wait_room.allowNewConnections = false;
        try {
            wait_room.interrupt();
        } catch (Exception e) {
            System.out.println("Unable to close wait room");
            e.printStackTrace();
        }

        Multiplayer_Main.GameHasBegan = true;
        Multiplayer_Manager.broadcast("The game will now begin.");
        for (int i = 0; i < Multiplayer_Manager.clients.size(); i++) {
            try {
                Multiplayer_Manager.clients.get(i).start();
            } catch (Exception e) {
                System.out.println("Unable to start thread for client index " + i);
            }
        }
    }
}
