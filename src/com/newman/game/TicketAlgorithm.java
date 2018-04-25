package com.newman.game;

import ibio.*;

public class TicketAlgorithm {
    public static int ticket_price;
    public static void setTicket_price() {
        ticket_price = IBIO.inputInt("What would you like to set the price at? \n** ");
    }
}
