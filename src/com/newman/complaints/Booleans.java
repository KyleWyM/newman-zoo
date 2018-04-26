package com.newman.complaints;

import com.newman.animals.ManageAnimals;
import com.newman.animals.species.Animal;
import com.newman.game.DataCalculations;
import com.newman.game.TicketAlgorithm;
import com.newman.player.PlayerStats;
import ibio.IBIO;

import java.util.ArrayList;

public class Booleans {

    public static boolean complaints_initialized = false;

    //Animal related booleans
    static boolean too_many_mammals;
    static boolean too_few_reptiles;
    static boolean too_few_birds;
    static boolean too_many_animals_too_fast;
    static boolean avian_bonus;
    static boolean reptile_bonus;
    static boolean mammal_bonus;
    static boolean too_many_of_one_animal;
    static boolean too_many_carnivores;


    static boolean owner_is_rich;
    static boolean ticket_prices_fluctuating;
    static boolean reputation_dropping;
    static boolean too_crowded;
    static boolean too_sparse;
    static boolean increasing_popularity;

    public static int initial_money;
    private static int change_in_money;

    public static int initial_reputation;
    private static int change_in_reputation;

    public static int initial_ticket_prices;
    private static int change_in_ticket_prices;

    public static int initial_visitors;
    private static int change_in_visitors;

    //Animal data
    public static int initial_num_animals;
    private static int change_in_num_animals;

    static int num_reptiles;
    private static int num_mammals;
    static int num_birds;
    private static int num_carnivores;

    private static String[] reptiles = {"Dragon", "Snake"};
    private static String[] birds = {"Flamingo", "Ostrich"};
    private static String[] carnivores = {"Dragon", "Lion", "Snake", "Tiger"};


    static void update_variables() {
        resetBooleans();
        if (!complaints_initialized) {
            initialize_variables();
            complaints_initialized = true;
        }


        calculate_changes();
        analyze_arrays();
        configure_booleans();
    }

    private static void initialize_variables() {
        initial_money = PlayerStats.money;
        initial_ticket_prices = TicketAlgorithm.ticket_price;
        initial_reputation = PlayerStats.reputation;
        initial_num_animals = PlayerStats.myAnimals.size();
        initial_visitors = DataCalculations.visitors;
    }

    private static void calculate_changes() {
        if (PlayerStats.dayNum % 3 == 0) {
            //Every three days, the changes in variables are counted.
            change_in_money = PlayerStats.money - initial_money;
            change_in_ticket_prices = TicketAlgorithm.ticket_price - initial_ticket_prices;
            change_in_reputation = PlayerStats.reputation - initial_reputation;
            change_in_num_animals = PlayerStats.myAnimals.size() - initial_num_animals;
            change_in_visitors = DataCalculations.visitors - initial_visitors;
            initialize_variables();
        }
    }

    private static void analyze_arrays() {
        num_reptiles = count_animal_matches(PlayerStats.myAnimals, reptiles);
        num_birds = count_animal_matches(PlayerStats.myAnimals, birds);
        num_mammals = PlayerStats.myAnimals.size() - num_reptiles - num_birds;
        num_carnivores = count_animal_matches(PlayerStats.myAnimals, carnivores);
    }

    private static int count_animal_matches(ArrayList<Animal> myAnimals, String[] animal_array) {
        String myAnimal;
        int num_matches = 0;

        for (int i = 0; i < myAnimals.size(); i++) {
            myAnimal = myAnimals.get(i).getClass().getSimpleName();

            for (String test_animal : animal_array) {
                if (myAnimal.equals(test_animal))
                    num_matches++;
            }
        }

        return num_matches;
    }

    private static void too_many_of_an_animal() {
        int max_species_index = 0;
        int max_num_species = 0;
        String mySpeciesName, testSpeciesName;

        int num_species;
        for (int i = 0; i < ManageAnimals.available_animals.size(); i++) {
            num_species = 0;
            testSpeciesName = ManageAnimals.available_animals.get(i).getClass().getSimpleName();
            for (int k = 0; k < PlayerStats.myAnimals.size(); k++) {
               mySpeciesName = PlayerStats.myAnimals.get(k).name;
               if (mySpeciesName.equals(testSpeciesName))
                   num_species++;
            }

            if (num_species > max_num_species) {
                max_num_species = num_species;
                max_species_index = i;
            }
        }

        if (PlayerStats.myAnimals.size() != 0) {
            double species_abundance_ratio = (double) max_num_species / (double) PlayerStats.myAnimals.size();
            if (PlayerStats.myAnimals.size() > 5 && species_abundance_ratio > 0.5) {
                mySpeciesName = ManageAnimals.available_animals.get(max_species_index).getClass().getName();
                IBIO.output("More than half your animals are " + mySpeciesName + "s!" +
                        "\nCheck your report to see the consequences!");
                too_many_of_one_animal = true;
            }
        }
    }

    private static void resetBooleans() {
        too_many_mammals = false;
        too_few_reptiles = false;
        too_few_birds = false;
        too_many_animals_too_fast = false;
        avian_bonus = false;
        reptile_bonus = false;
        mammal_bonus = false;
        too_many_of_one_animal = false;
        too_many_carnivores = false;
        owner_is_rich = false;
        ticket_prices_fluctuating = false;
        reputation_dropping = false;
        too_crowded = false;
        too_sparse = false;
        increasing_popularity = false;
    }

    private static void configure_booleans() {
        //Animal related booleans:
        too_many_of_an_animal();
        double numAnimals = (double) PlayerStats.myAnimals.size();

        boolean sufficient_animals = PlayerStats.myAnimals.size() >= 4;
        if (numAnimals != 0) {
            //Special bonuses that come from different percentages of animals
            double percentage_reptiles = ((double) num_reptiles / numAnimals);
            double percentage_mammals = ((double) num_mammals / numAnimals);
            double percentage_birds = ((double) num_birds / numAnimals);
            double percentage_carnivores = ((double) num_carnivores / numAnimals);

            if (sufficient_animals) {
                if (percentage_reptiles > 0.10) {
                    //If more than 10% of a players animals are reptiles, they get the reptile bonus
                    reptile_bonus = true;
                } else if (percentage_reptiles < 0.05) {
                    too_few_reptiles = true;
                }
                if (percentage_mammals > 0.80) {
                    //If more than 80% of a players animals are reptiles, they get the reptile bonus
                    mammal_bonus = true;
                } else if (percentage_mammals > 0.90) {
                    too_many_mammals = true;
                }
                if (percentage_birds > 0.10) {
                    //If more than 10% of a players animals are birds, they get the avian bonus
                    avian_bonus = true;
                } else if (percentage_birds < 0.05) {
                    too_few_birds = true;
                }
                if (percentage_carnivores > 0.50) {
                    too_many_carnivores = true;
                }
            }
        }

        if ((double) change_in_num_animals > 0.25 * numAnimals) {
            too_many_animals_too_fast = true;
        }

        //Other booleans:
        if (((double) change_in_money > 0.15 * (double) PlayerStats.money) && change_in_money > 0) {
            owner_is_rich = true;
        }
        if ((double) DataCalculations.visitors > numAnimals * 50) {
            too_crowded = true;
        } else if ((double) DataCalculations.visitors < numAnimals) {
            too_sparse = true;
        }
        if (initial_ticket_prices != 0) {
            if ((double) change_in_ticket_prices / (double) initial_ticket_prices > 1.00) {
                ticket_prices_fluctuating = true;
            }
        }
        if ((double) change_in_reputation < 0) {
            reputation_dropping = true;
        }
        if (initial_visitors != 0) {
            if ((double) change_in_visitors / (double) initial_visitors > 0.20) {
                increasing_popularity = true;
            }
        }
    }
}
