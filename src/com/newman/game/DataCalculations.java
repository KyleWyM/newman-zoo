package com.newman.game;

import com.newman.player.PlayerStats;
import ibio.IBIO;

import static com.newman.animals.ManageAnimals.animal_list;
import static com.newman.animals.ManageAnimals.available_animals;
import static com.newman.employees.Employee.available_employees;
import static com.newman.employees.Employee.employee_list;
import static com.newman.game.TicketAlgorithm.ticket_price;
import static com.newman.player.PlayerStats.*;

public class DataCalculations {
    static int total_maintenance, total_income, rent;
    public static int total_salaries, visitors;
    public static void calculate_visitors() {
        int number = (int )(Math.random() * (PlayerStats.reputation*5));
        visitors = (-(ticket_price)*(ticket_price)+number);
    }
    public static void ticket_income() {
         //upside-down parabola, determines how many visitors
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
        PlayerStats.money -= total_maintenance;
        if (total_maintenance != 0) {
            IBIO.output(String.format("You have paid %d dollars to feed your animals", total_maintenance));
        }
    }
    public static void salaries() {
        if (total_salaries != 0)
            if (dayNum % 7 == 0) {
                PlayerStats.money -= total_salaries;
                IBIO.output(String.format("You have paid %d dollars to your workers", total_maintenance));
            }
    }
    static int[] level_thresholds = {0, 5, 10, 20, 50, 100, 200, 300, 500, 1000};
    public static void level_up(int reputation) {
        for (int i = 0; i < level_thresholds.length; i++) {
            if (reputation >= level_thresholds[i] && PlayerStats.level < i+1) {
                String message = String.format("Congrats! You have leveled up to level %d!", i+1);
                IBIO.output(message);
                PlayerStats.level = i+1;
                for (int g = 0; g < employee_list.length; g++) {
                    if (employee_list[g].level == PlayerStats.level) {
                        available_employees.add(employee_list[g]);
                        IBIO.output(String.format("You have unlocked the %s!", employee_list[g].name.toLowerCase()));
                    }
                }
                for (int g = 0; g < animal_list.length; g++) {
                    if (animal_list[g].level == PlayerStats.level) {
                        available_animals.add(animal_list[g]);
                        IBIO.output(String.format("You have unlocked the %s!", animal_list[g].name.toLowerCase()));
                    }
                }
            }
        }
    }
}
