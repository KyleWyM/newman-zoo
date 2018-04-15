package com.newman.animals;

import com.newman.game.AskUser_old;
import com.newman.game.Autocorrect;
import com.newman.game.GameLoop;
import com.newman.multiplayer.Multiplayer_Manager;
import com.newman.multiplayer.Client;
import com.newman.player.Player;
import ibio.IBIO;

public class ManageAnimals {
    public static void buyCommand(Client client) {
        String msg = "** Choose an animal you would like to purchase\n ";
        client.println(msg);
        species_list(client);
        String animal = client.readLine();

        msg = "** Choose a name for your animal\n ";
        client.println(msg);
        String chosen_name = client.readLine();

        addSelectedAnimal(client, animal.toLowerCase(), chosen_name, GameLoop.globalTime);
    }

    public static void addSelectedAnimal(Client client, String animal_selected, String animal_name, int currentTime) {
        boolean searchForAnimal = true;

        while (searchForAnimal) {
            switch (animal_selected) {
                case "flamingo":
                    Species.addFlamingo(client, animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "zebra":
                    Species.addZebra(client, animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                case "kangaroo":
                    Species.addKangaroo(client, animal_name, currentTime);
                    searchForAnimal = false;
                    break;
                default:
                    //If the animal selected by the user is not found, this runs
                    //This tries to guess what the user meant using the Autocorrect class
                    //It then asks the user whether or not it is right.

                    client.println("Animal choice not recognized.");

                    String bestMatch = Autocorrect.findMatch(animal_selected,
                            Species_SinglePlayer.species_list);

                    client.println("Did you mean " + bestMatch + "?");

                    if (AskUser_old.yesOrNo()) {
                        animal_selected = bestMatch;
                    } else searchForAnimal = false;
            }
        }
    }

    public static void my_animals(Client client) {
        client.println("Your animals: ");
        for (int i = 0; i < client.player.myAnimals.size(); i = i + 1) {

            String msg = String.format("%2d. %-20s %s",
                    i + 1, client.player.myAnimals.get(i).species, client.player.myAnimals.get(i).name);

            client.println(msg);
        }
    }

    public static void species_list(Client client) {
        for (int i = 0; i < Species.species_list.length; i = i + 1) {

            String msg = String.format("%2d. %-20s",
                    i + 1, Species.species_list[i]);
            client.println(msg);
        }
    }

}
