package com.newman.game;

import com.newman.multiplayer.Host;

import java.io.IOException;

public class Multiplayer_Main {
    public static boolean GameHasBegan = false;

    public static void main(String[] args) throws IOException {
        Host.create_localServer();

        //Instructions to get on the server
        String msg = "\nTo log onto server, type 'nc -v 127.0.0.1 [port num]' into " +
                "\nterminal while the server is running.";
        System.out.println(msg);
        msg = "\n\tFor example, 'nc -v 127.0.0.1 5000'.\n";
        System.out.println(msg);

        Host.wait_for_start();
        GameLoop.startTimeCycle();
    }
}
