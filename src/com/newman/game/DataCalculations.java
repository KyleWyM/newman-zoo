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
    static int total_income, rent;
    public static int total_salaries, visitors, total_maintenance, work_force, total_labor;

    public static void calculate_visitors() {
        int number = (int) (Math.random() * (PlayerStats.reputation * 5));
        visitors = (-(ticket_price) * (ticket_price) + number);
        if (visitors < 0) {
            visitors = 0;
        }
        if (visitors == 0) {
            IBIO.output("Hmm... you don't have any visitors! Either the " +
                    "ticket prices are too high or you should buy more animals!");
        } else {
            IBIO.output(String.format("You had %d visitors today!", visitors));
        }
    }

    public static void ticket_income() {
        //upside-down parabola, determines how many visitors
        // come in with random number based on reputation as y intercept

        total_income = visitors * ticket_price;
        if (ticket_price == 0) {
            IBIO.output("Your tickets are free, your not making any profits!");
        } else {
            IBIO.output(String.format("You have earned %d dollars in ticket sales!", total_income));
        }
        PlayerStats.money += total_income;
    }

    public static void rent() {
        rent = level * 100;
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

    public static void inspection() {
        int difference = work_force - total_labor;
        if (difference > 100) {
            IBIO.output("Your workers are keeping your zoo in perfect shape! Your reputation has gone up 100!");
            reputation += 100;
        } else if (difference > 50) {
            IBIO.output("Your workers are keeping your zoo in fantastic shape! Your reputation has gone up 20!");
            reputation += 20;
        } else if (difference > 20) {
            IBIO.output("Your workers are keeping your zoo in great shape! Your reputation has gone up 10!");
            reputation += 10;
        } else if (difference > 10) {
            IBIO.output("Your workers are keeping your zoo in good shape! Your reputation has gone up 5!");
            reputation += 10;
        } else if (difference >= 0) {
            IBIO.output("Your workers are keeping your zoo in fine shape");
        } else if (difference > -5) {
            IBIO.output("Uh oh, your workers are falling behind a little bit, you lost 3 reputation");
        } else if (difference > -10) {
            IBIO.output("Uh oh, your workers are struggling, the zoo is starting to look a little dirty, your reputation has gone down 5");
            reputation -= 5;
        } else if (difference > -20) {
            IBIO.output("Your workers are really struggling, the zoo is looking bad, your reputation has gone down 10");
            reputation -= 10;
        } else if (difference > -30) {
            IBIO.output("Your workers just can't keep up, the health inspector gave you a bad rating, your reputation has gone down 20");
            reputation -= 20;
        } else if (difference > -40) {
            IBIO.output("Your workers cannot handle this, PETA has given your zoo some looks for cruelty");
            reputation -= 30;
        } else if (difference > -50) {
            IBIO.output("Your workers could not take care of enough of your animals, one of your animals has died");
            reputation -= 50;
            IBIO.output(String.format("%s has died", PlayerStats.myAnimals.get(0).name));
            PlayerStats.myAnimals.remove(PlayerStats.myAnimals.get(0));
        } else {
            IBIO.output("Your workers are so behind, your zoo is gaining a terrible reputation and your animals are dying");
            reputation -= 100;
            IBIO.output(String.format("%s has died", PlayerStats.myAnimals.get(0).name));
            PlayerStats.myAnimals.remove(PlayerStats.myAnimals.get(0));
        }
    }

    static int[] level_thresholds = {0, 50, 100, 200, 300, 500, 1000, 2000, 3000, 5000, 10000};

    public static void level_up(int reputation) {
        for (int i = 0; i < level_thresholds.length; i++) {
            if (reputation >= level_thresholds[i] && PlayerStats.level < i + 1) {
                String message = String.format("Congrats! You have leveled up to level %d!", i + 1);
                IBIO.output(message);
                PlayerStats.level = i + 1;
                for (int g = 0; g < employee_list.length; g++) {
                    if (employee_list[g].level == PlayerStats.level) {
                        available_employees.add(employee_list[g]);
                        IBIO.output(String.format("You have unlocked the %s!", employee_list[g].name.toLowerCase()));
                    }
                }
                for (int g = 0; g < animal_list.length; g++) {
                    if (animal_list[g].level == PlayerStats.level) {
                        available_animals.add(animal_list[g]);
                        IBIO.output(String.format("You have unlocked the %s!", animal_list[g].getClass().getSimpleName().toLowerCase()));
                    }
                }
            }
        }
    }
}