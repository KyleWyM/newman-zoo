package com.newman.game;

import ibio.*;

import java.util.Scanner;

public class TicketAlgorithm {
    public static int ticket_price;
    public static void setTicket_price() {
        String input = IBIO.input("What would you like to set the price at? \n** ");
        try {
            ticket_price = Integer.parseInt(input);
        } catch (Exception e) {
            ticket_price = 1;
        }
    }
}
