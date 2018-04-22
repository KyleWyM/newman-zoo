package com.newman.animals;

import com.newman.animals.species.Animal;
import com.newman.animals.species.*;
import com.newman.game.RealTime_GameLoop;
import ibio.*;
import com.newman.player.PlayerStats;

import java.util.ArrayList;
import java.util.Arrays;

public class ManageAnimals {
    static String name = "Benjamin";

    static Armadillo armadillo = new Armadillo(name);
    static Camel camel = new Camel(name);
    static Dragon dragon = new Dragon(name);
    static Elephant elephant = new Elephant(name);
    static Flamingo flamingo = new Flamingo(name);
    static Giraffe giraffe = new Giraffe(name);
    static Hippo hippo = new Hippo(name);
    static Kangaroo kangaroo = new Kangaroo(name);
    static Koala koala = new Koala(name);
    static Lion lion = new Lion(name);
    static Okapi okapi = new Okapi(name);
    static Orangutan orangutan = new Orangutan(name);
    static Ostrich ostrich = new Ostrich(name);
    static Penguin penguin = new Penguin(name);
    static Snake snake = new Snake(name);
    static Tiger tiger = new Tiger(name);
    static Zebra zebra = new Zebra(name);


    public static ArrayList<Animal> species_list = new ArrayList<Animal>()
    {{add(armadillo); add(camel); add(dragon); add(elephant); add(flamingo); add(giraffe);
      add(hippo); add(kangaroo); add(koala); add(lion); add(okapi); add(orangutan);
      add(ostrich); add(penguin); add(snake); add(tiger); add(zebra);}};

    public static void my_animals() {
        IBIO.output("Your animals:");

        String message = String.format("    %-20s %-20s %-20s %-20s %-20s", "Animal", "Name", "Price",
                "Maintenance", "Reputation");
        IBIO.output(message);

        for (int i = 0; i < PlayerStats.myAnimals.size(); i = i + 1) {
            Animal current_animal = PlayerStats.myAnimals.get(i);
            message = String.format("%2d. %-20s %-20s %-20d %-20d %-20d",
                    i + 1, current_animal.getClass().getSimpleName(), current_animal.name, current_animal.price,
                    current_animal.maintenance, current_animal.reputation);
            IBIO.output(message);
        }
    }

    public static void species_list() {
        IBIO.output("Available animals:");
        String message;
        message = String.format("    %-20s %-20s %-20s %-20s", "Animal", "Price", "Maintenance", "Reputation");
        IBIO.output(message);
        int i;
        for (i = 0; i < species_list.size(); i = i + 1) {
            Animal current_animal = species_list.get(i);
            message = String.format("%2d. %-20s %-20d %-20d %-20d",
                    i + 1, current_animal.getClass().getSimpleName(), current_animal.price,
                    current_animal.maintenance, current_animal.reputation);
            IBIO.output(message);
        }
        IBIO.output(i + 1 + ". Cancel");
    }

    public static void buy_animal() {
        species_list(); String message = "** Choose the number of the animal you would like to purchase: ";
        int animal_index;
        String input = IBIO.input(message);
        try {
            animal_index = Integer.parseInt(input) - 1; //Subtracting 1 so that 1 is index 0, 2 is 1, etc...
            Animal animal = species_list.get(animal_index);
            if (PlayerStats.money >= animal.price) {
                String name = IBIO.input("Please, name your animal:");
                PlayerStats.money -= animal.price;
                animal.name = name;
                IBIO.output(animal.getClass().getSimpleName() + " named " + name + " has been added.");
                PlayerStats.myAnimals.add(animal);
            } else {
                IBIO.output("You can't afford this animal.");
            }

        } catch (Exception e) {
            IBIO.output("That doesn't seem like it's in the store, how about you try again!");
            buy_animal();
        }


    }

    public static void main(String[] args) {
        species_list();
    }
}
