package com.newman.game;

import com.newman.player.PlayerStats;
import ibio.*;
import com.newman.game.*;


import java.util.Scanner;


public class TicketAlgorithm {
    public static int ticketprice;
    public static void TicketMath() {
        String operation;

        Scanner scannerObject = new Scanner(System.in);
        System.out.println("** What would you like to set your ticket price to be? (Remember this affects your sales!");
        ticketprice = scannerObject. nextInt();
        System.out.println("The price of your ticket is now " + ticketprice + " dollars.");
    }

    //update
    public static void TicketUpdate(){
        // PlayerStats.money = PlayerStats.money + n1/PlayerStats.visitors;
    }
    //PlayerStats.money += ;
    //PlayerStats.visitors
}
