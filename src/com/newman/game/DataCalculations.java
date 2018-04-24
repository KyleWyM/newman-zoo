package com.newman.game;

import com.newman.player.Player;
import com.newman.player.PlayerStats;
import ibio.IBIO;
import java.util.ArrayList;

import static com.newman.game.TicketAlgorithm.ticket_price;
import static com.newman.player.PlayerStats.level;
import static com.newman.player.PlayerStats.myAnimals;

public class DataCalculations {
    static int total_maintenance, total_income, rent;
    public static void ticket_income() {
        int number = (int )(Math.random() * (PlayerStats.reputation*5));
        int visitors = (-(ticket_price)*(ticket_price)+number); //upside-down parabola, determines how many visitors
        // come in with random number based on reputation as y intercept
        if (visitors < 0) {
            visitors = 0;
        }
        total_income = visitors * ticket_price;
        if (ticket_price == 0) {
            IBIO.output("Your tickets are free, your not making any profits!");
        } else if (visitors == 0) {
            IBIO.output("Hmm... you don't have any visitors! Either the " +
                    "ticket prices are too high or you should buy more animals!");
        } else {
            IBIO.output(String.format("You have earned %d dollars in ticket sales!", total_income));
        }
        PlayerStats.money += total_income;
    }

    public static void rent() {
        rent = level * 10;
        PlayerStats.money -= rent;
        IBIO.output(String.format("You have paid %d dollars in rent", rent));
    }

    public static void maintenance() {
        total_maintenance = 0;
        for (int i = 0; i < myAnimals.size(); i++) {
            total_maintenance = total_maintenance + myAnimals.get(i).maintenance;
        }
        PlayerStats.money -= total_maintenance;
        if (total_maintenance != 0) {
            IBIO.output(String.format("You have paid %d dollars to feed your animals", total_maintenance));
        }
    }
}
