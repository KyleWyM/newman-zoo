package com.newman.animals;

import com.newman.player.PlayerStats;
import ibio.*;
import com.newman.game.*;

public class ManageAnimals {
    public static void buyCommand() {
        String message = "** Choose a name for your animal\n ";
        String chosen_name = IBIO.input(message);
        message = "** Choose an animal you would like to purchase\n ";

        addSelectedAnimal(IBIO.input(message).toLowerCase(), chosen_name, RealTime_GameLoop.globalTime);

    }

    public static void addSelectedAnimal(String animal_selected, String animal_name, int currentTime) {
        boolean searchForAnimal = true;

        while (searchForAnimal) {
            switch (animal_selected) {
                case "flamingo":
                    Species.addFlamingo(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "zebra":
                    Species.addZebra(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "kangaroo":
                    Species.addKangaroo(animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                default:
                    //If the animal selected by the user is not found, this runs
                    //This tries to guess what the user meant using the Autocorrect class
                    //It then asks the user whether or not it is right.

                    IBIO.output("Animal choice not recognized.");

                    String bestMatch = Autocorrect.findMatch(animal_selected,
                            Species.species_list);

                    IBIO.output("Did you mean " + bestMatch + "?");

                    if (AskUser.yesOrNo()) {
                        animal_selected = bestMatch;
                    } else searchForAnimal = false;
            }
        }
    }

    public static void my_animals() {
        for (int i = 0; i < PlayerStats.myAnimals.size(); i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, PlayerStats.myAnimals.get(i).species, PlayerStats.myAnimals.get(i).name);

            IBIO.output(message);
        }
    }

    public static void species_list() {
        for (int i = 0; i < Species.species_list.length; i = i + 1) {

            String message = String.format( "%2d. %-20s",
                    i + 1, Species.species_list[i]);
            IBIO.output(message);
        }
    }

}
