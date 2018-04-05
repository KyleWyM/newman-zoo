package com.newman.animals;

import ibio.*;
import com.newman.game.Autocorrect;
import com.newman.game.AskUser;

public class BuyAnimal {
    public static void buyCommand() {
        String message = "** Choose a name for your animal -> ";
        String chosen_name = IBIO.input(message);
        message = "** Choose an animal you would like to purchase -> ";

        addSelectedAnimal(IBIO.input(message).toLowerCase(), chosen_name);

    }

    public static void addSelectedAnimal(String animal_selected, String animal_name) {
        boolean searchForAnimal = true;

        while (searchForAnimal) {
            switch (animal_selected) {
                case "flamingo":
                    Species.addFlamingo(animal_name);
                    searchForAnimal = false;
                    break;
                case "zebra":
                    Species.addZebra(animal_name);
                    searchForAnimal = false;
                    break;
                case "kangaroo":
                    Species.addKangaroo(animal_name);
                    searchForAnimal = false;
                    break;
                default:
                    //If the animal selected by the user is not found, this runs
                    //This tries to guess what the user meant using the Autocorrect class
                    //It then asks the user whether or not it is right.

                    IBIO.output("Animal choice not recognized.");

                    int bestMatchIndex = Autocorrect.findMatch(animal_selected,
                            Autocorrect.createListVectors(Species.animal_list));

                    IBIO.output("Did you mean " + Species.animal_list[bestMatchIndex] + "?");

                    if (AskUser.yesOrNo()) {
                        animal_selected = Species.animal_list[bestMatchIndex];
                    } else searchForAnimal = false;
            }
        }
    }
}
