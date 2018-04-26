package com.newman.animals;

import com.newman.animals.species.Animal;
import com.newman.animals.species.*;
import ibio.*;
import com.newman.player.PlayerStats;

import static com.newman.game.DataCalculations.total_labor;
import static com.newman.game.DataCalculations.total_maintenance;

import java.util.ArrayList;

import static com.newman.game.CommandListener.help;

public class ManageAnimals {
    static String name = "pippo";

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
    public static ArrayList<Animal> available_animals = new ArrayList<>();

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
        //This is a list that tells the user what animals they have unlocked and are able to buy
        IBIO.output("Available animals:");
        String message;
        message = String.format("\t%-20s %-20s %-20s %-20s", "Animal", "Price", "Maintenance", "Reputation");
        IBIO.output(message);

        for (int i = 0; i < available_animals.size(); i = i + 1) {
            Animal current_animal = available_animals.get(i);
            message = String.format("%2d. %-20s %-20d %-20d %-20d",
                    i + 1, current_animal.getClass().getSimpleName(), current_animal.price,
                    current_animal.maintenance, current_animal.reputation);
            IBIO.output(message);
        }
    }

    public static void buy_animal() {
        int animal_index;
        Animal animal;

        species_list(); //Outputs a list of animals so that the user can see their choices
        IBIO.output(" " + (available_animals.size() + 1)+ ". Cancel");
        //The above output method adds a cancel option at the end of the list of species
        //It will always be one more than the number of available species so that it comes right after in the list

        String message = "** Choose the number of the animal you would like to purchase: ";
        String input = IBIO.input(message);

        try {
            animal_index = Integer.parseInt(input) - 1; //Subtracting 1 so that 1 is index 0, 2 is 1, etc...

            if (0 <= animal_index && animal_index < available_animals.size()) {
                animal = available_animals.get(animal_index);

                if (PlayerStats.money >= animal.price) {
                    //Here, the transaction is verified and the animal named

                    //The naming of the animal
                    String name = IBIO.input(String.format("Please, name your %s: ",
                            animal.getClass().getSimpleName().toLowerCase()));
                    animal.name = name;
                    IBIO.output(animal.getClass().getSimpleName() + " named " + name + " has been added.");

                    //Updating player stats
                    PlayerStats.reputation += animal.reputation;
                    total_labor += animal.labor;
                    PlayerStats.money -= animal.price;

                    //Animal is added and it plays its sound
                    PlayerStats.myAnimals.add(animal);
                    animal.PlaySound();
                    manage_animals();
                } else {
                    IBIO.output("You can't afford that animal.");
                    manage_animals();
                }
            } else if (animal_index == available_animals.size()) {
                manage_animals();
            }
        } catch (Exception e) {
            IBIO.output("That doesn't seem like it's in the store, how about you try again!");
            buy_animal();
        }
    }
    public static void sell_animal() {
        my_animals();
        IBIO.output(String.format("%2d. keep your animals", PlayerStats.myAnimals.size()+1));
        String message = "Which animal would you like to sell? (You receive half of the cost of the animal)\n** ";
        int chosen_animal_index = IBIO.inputInt(message);
        if (0 < chosen_animal_index && chosen_animal_index <= PlayerStats.myAnimals.size()) {
            total_maintenance = total_maintenance - PlayerStats.myAnimals.get(chosen_animal_index-1).maintenance;
            total_labor = total_labor - PlayerStats.myAnimals.get(chosen_animal_index-1).labor;
            IBIO.output(String.format("You have sold your %s for $%d!",
                    PlayerStats.myAnimals.get(chosen_animal_index-1).name,
                    PlayerStats.myAnimals.get(chosen_animal_index-1).price/2));
            PlayerStats.money += PlayerStats.myAnimals.get(chosen_animal_index-1).price/2;
            PlayerStats.myAnimals.remove(PlayerStats.myAnimals.get(chosen_animal_index-1));
            manage_animals();
        } else if (chosen_animal_index == PlayerStats.myAnimals.size()+1) {
            manage_animals();
        } else {
            IBIO.output("Hmm... that doesn't seem like one of your animals, try again!");
            sell_animal();
        }
    }
    public static void manage_animals() {
        String[] command_list = new String[]{
                "buy animal", "sell animal", "my animals", "available animals", "leave animal management"
        };
        for (int i = 0; i < command_list.length; i++) {
            String message = String.format("%2d. %s", i + 1, command_list[i]);
            IBIO.output(message);
        }
        String command = IBIO.input("** ");
        switch (command) {
            case "1":
            case "buy animal":
            case "buy":
                buy_animal();
                break;
            case "2":
            case "sell":
            case "sell animal":
                sell_animal();
                break;
            case "3":
            case "my animals":
                my_animals();
                break;
            case "4":
            case "available animals":
                species_list();
                break;
            case "5":
            case "leave":
            case "leave animal management":
                help();
                break;
            default:
                IBIO.output("Hmm that doesn't seem like a command, how about we try again!");
                manage_animals();
                break;
        }
    }

    public static void main(String[] args) {
        ArrayList<Animal> available_animals = new ArrayList<Animal>()
        {{add(armadillo); add(camel); add(dragon); add(elephant); add(flamingo); add(giraffe);
            add(hippo); add(kangaroo); add(koala); add(lion); add(okapi); add(orangutan);
            add(ostrich); add(penguin); add(snake); add(tiger); add(zebra);}};

        for (int i = 0; i < available_animals.size(); i++) {
            System.out.println(available_animals.get(i).getClass().getSimpleName() + " now making its sound.");
            available_animals.get(i).PlaySound();
        }
    }
}
