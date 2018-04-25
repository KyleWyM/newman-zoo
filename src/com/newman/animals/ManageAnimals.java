package com.newman.animals;

import com.newman.animals.species.Animal;
import com.newman.animals.species.*;
import com.newman.game.RealTime_GameLoop;
import ibio.*;
import com.newman.player.PlayerStats;

import java.util.ArrayList;
import java.util.Arrays;

import static com.newman.game.CommandListener.help;

public class ManageAnimals {
    static String name = "Benjamin";

    public static Armadillo armadillo = new Armadillo(name);
    static Camel camel = new Camel(name);
    static Dragon dragon = new Dragon(name);
    static Elephant elephant = new Elephant(name);
    public static Flamingo flamingo = new Flamingo(name);
    static Giraffe giraffe = new Giraffe(name);
    static Hippo hippo = new Hippo(name);
    static Kangaroo kangaroo = new Kangaroo(name);
    static Koala koala = new Koala(name);
    static Lion lion = new Lion(name);
    static Okapi okapi = new Okapi(name);
    static Orangutan orangutan = new Orangutan(name);
    static Ostrich ostrich = new Ostrich(name);
    static Penguin penguin = new Penguin(name);
    public static Snake snake = new Snake(name);
    static Tiger tiger = new Tiger(name);
    static Zebra zebra = new Zebra(name);


    public static Animal[] animal_list = new Animal[] {
            armadillo, camel, dragon, elephant, flamingo, giraffe, hippo, kangaroo, koala, lion, okapi, orangutan,
            ostrich, penguin, snake, tiger, zebra
    };
    public static ArrayList<Animal> available_animals = new ArrayList<Animal>();

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
        for (i = 0; i < available_animals.size(); i = i + 1) {
            Animal current_animal = available_animals.get(i);
            message = String.format("%2d. %-20s %-20d %-20d %-20d",
                    i + 1, current_animal.getClass().getSimpleName(), current_animal.price,
                    current_animal.maintenance, current_animal.reputation);
            IBIO.output(message);
        }
        IBIO.output(" "+ (i + 1) + ". Cancel");
    }

    public static void buy_animal() {
        species_list();
        String message = "** Choose the number of the animal you would like to purchase: ";
        int animal_index;
        String input = IBIO.input(message);
        Animal animal;
        try {
            animal_index = Integer.parseInt(input) - 1; //Subtracting 1 so that 1 is index 0, 2 is 1, etc...
            if (0 <= animal_index && animal_index < available_animals.size()) {
                animal = available_animals.get(animal_index);
                if (PlayerStats.money >= animal.price) {
                    String name = IBIO.input(String.format("Please, name your %s: ",
                            animal.getClass().getSimpleName().toLowerCase()));
                    PlayerStats.money -= animal.price;
                    animal.name = name;
                    IBIO.output(animal.getClass().getSimpleName() + " named " + name + " has been added.");
                    PlayerStats.myAnimals.add(animal);
                    PlayerStats.reputation += animal.reputation;
                    IBIO.output(PlayerStats.reputation);
                } else {
                    IBIO.output("You can't afford this animal.");
                }
            } else if (animal_index == available_animals.size()){
                manage_animals();
            }
        } catch (Exception e) {
            IBIO.output("That doesn't seem like it's in the store, how about you try again!");
            buy_animal();
        }
    }
    public static void manage_animals() {
        String[] command_list = new String[]{
                "buy animal", "my animals", "available animals", "leave animal management"
        };
        for (int i = 0; i < command_list.length; i++) {
            String message = String.format("%2d. %s", i + 1, command_list[i]);
            IBIO.output(message);
        }
        String command = IBIO.input("** ");
        switch (command) {
            case "1":
            case "buy animal":
            case "hire":
                buy_animal();
                break;
            case "2":
            case "my animals":
                my_animals();
                break;
            case "3":
            case "available animals":
                species_list();
                break;
            case "4":
            case "leave":
            case "leave animal management":
                help();
                break;
            default:
                IBIO.output("Hmm that doesn't seem like a command, how about we try again!");
                manage_animals();
        }
    }
}
