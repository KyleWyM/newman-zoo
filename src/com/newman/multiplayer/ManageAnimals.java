package com.newman.multiplayer;

import com.newman.animals.Animals;
import com.newman.multiplayer.AskUser;
import com.newman.game.Autocorrect;
import com.newman.multiplayer.GameLoop;
import com.newman.multiplayer.Client;
import com.newman.multiplayer.Species;

public class ManageAnimals {
    public static void buyCommand(Client client) {
        String msg = "** Choose an animal you would like to purchase\n ";
        client.println(msg);
        species_list(client);
        String animal = client.readLine();

        msg = "** Choose a name for your animal\n ";
        client.println(msg);
        String chosen_name = client.readLine();
        try {
            addSelectedAnimal(client, animal.toLowerCase(), chosen_name, GameLoop.globalTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addSelectedAnimal(Client client, String animal_selected, String animal_name, int currentTime) {
        boolean searchForAnimal = true;
        int money = client.player.getMoney();

        while (searchForAnimal) {
            switch (animal_selected) {
                case "flamingo":
                    Animals flamingo = Species.addFlamingo(client, animal_name, currentTime);
                    if (money >= flamingo.price) {

                        money -= flamingo.price;
                        client.player.setMoney(money);

                        client.println("Flamingo added.");
                        client.player.myAnimals.add(flamingo);
                    } else client.println("Not enough money.");
                    searchForAnimal = false;
                    break;
                case "zebra":
                    Animals zebra = Species.addZebra(client, animal_name, currentTime);
                    if (money >= zebra.price) {

                        money -= zebra.price;
                        client.player.setMoney(money);

                        client.println("Zebra added.");
                        client.player.myAnimals.add(zebra);
                    } else client.println("Not enough money.");
                    searchForAnimal = false;
                    break;
                case "kangaroo":
                    Animals kangaroo = Species.addKangaroo(client, animal_name, currentTime);
                    if (money >= kangaroo.price) {

                        money -= kangaroo.price;
                        client.player.setMoney(money);

                        client.println("Kangaroo added.");
                        client.player.myAnimals.add(kangaroo);
                    } else client.println("Not enough money.");
                    searchForAnimal = false;
                    break;
                default:
                    //If the animal selected by the user is not found, this runs
                    //This tries to guess what the user meant using the Autocorrect class
                    //It then asks the user whether or not it is right.

                    client.println("Animal choice not recognized.");

                    String bestMatch = Autocorrect.findMatch(animal_selected,
                            Species.species_list);

                    client.println("Did you mean " + bestMatch + "?");

                    if (AskUser.yesOrNo(client)) {
                        animal_selected = bestMatch;
                    } else searchForAnimal = false;
            }
        }
    }

    public static void my_animals(Client client) {
        client.println("Your animals: ");
        for (int i = 0; i < client.player.myAnimals.size(); i++) {

            String species_name = client.player.myAnimals.get(i).species;
            String animal_name = client.player.myAnimals.get(i).name;

            String msg = String.format("%2d. %-20s %s",
                    i + 1, species_name, animal_name);

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
