package com.newman.animals;

import com.newman.player.PlayerStats;
import ibio.*;
import com.newman.game.*;

public class ManageAnimals_SinglePlayer {

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void buyCommand() {
        species_list();
        String message = "** Choose an animal you would like to purchase\n ";
        String chosen_animal = IBIO.input(message);
        if (isInteger(chosen_animal)) {
            int chosen_animal_index = Integer.parseInt(chosen_animal);
            chosen_animal = Species_SinglePlayer.species_list[chosen_animal_index-1].species;
        }
        message = String.format("** What would you like to name your %s?\n ", chosen_animal.toLowerCase());
        addSelectedAnimal(chosen_animal.toLowerCase(), IBIO.input(message), RealTime_GameLoop.globalTime);

    }

    public static void addSelectedAnimal(String animal_selected, String animal_name, int currentTime) {
        boolean searchForAnimal = true;

        while (searchForAnimal) {
            switch (animal_selected) {
                case "flamingo":
                case "1":
                    Species_SinglePlayer.addFlamingo(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "zebra":
                case "2":
                    Species_SinglePlayer.addZebra(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "kangaroo":
                case "3":
                    Species_SinglePlayer.addKangaroo(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                default:
                    //If the animal selected by the user is not found, this runs
                    //This tries to guess what the user meant using the Autocorrect class
                    //It then asks the user whether or not it is right.

                    IBIO.output("Animal choice not recognized.");
                    searchForAnimal = false;
                    break;
            }
        }
    }

    public static void my_animals() {
        IBIO.output("Your animals:");
        for (int i = 0; i < PlayerStats.myAnimals.size(); i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, PlayerStats.myAnimals.get(i).species, PlayerStats.myAnimals.get(i).name);

            IBIO.output(message);
        }
    }

    public static void species_list() {
        IBIO.output("Available animals:");
        String message;
        message = String.format("   %-20s %-20s %-20s %-20s", "Animal", "Price", "Maintenance", "Reputation");
        IBIO.output(message);
        for (int i = 0; i < Species_SinglePlayer.species_list.length; i = i + 1) {
            Animals current_animal = Species_SinglePlayer.species_list[i];
            message = String.format( "%2d. %-20s %-20d %-20d %-20d",
                    i + 1, current_animal.species, current_animal.price, current_animal.maintenance, current_animal.reputation);
            IBIO.output(message);
        }
    }

}
