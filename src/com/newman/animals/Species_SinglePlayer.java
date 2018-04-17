package com.newman.animals;

import com.newman.player.PlayerStats;

public class Species_SinglePlayer {
    private static int flamingo_price = 10;
    private static int flamingo_maintenances = 5;
    private static int flamingo_reputation = 1;

    //TODO: convert prices, maintenances, and reputations in terms of some base numbers (i.e. for flamingo)
    //This way the prices are relative to some set price so we need to only change the price of one animal
    //to affect all other animals
    static String name;
    static int birthTime;
    static Animals flamingo = new Animals("Flamingo", name, flamingo_price, flamingo_maintenances,
            flamingo_reputation,10, birthTime, 1, 0);
    static Animals zebra = new Animals("Zebra", name,75,1,
            4, 400, birthTime, 1, 0);
    static Animals kangaroo = new Animals("Kangaroo", name,100,35,
            4, 10, birthTime, 1, 0);
    public static Animals[] species_list = new Animals[] {
            flamingo, zebra, kangaroo,
    };

    public static void addFlamingo(String name, int birthTime) {
        Animals flamingo = new Animals("Flamingo", name, flamingo_price, flamingo_maintenances,
                flamingo_reputation,10, birthTime, 1, 0);
        PlayerStats.myAnimals.add(flamingo);
    }

    public static void addZebra(String name, int birthTime) {
        Animals zebra = new Animals("Zebra", name,75,35,
                4, 10, birthTime, 1, 0);
        PlayerStats.myAnimals.add(zebra);
    }

    public static void addKangaroo(String name, int birthTime) {
        Animals kangaroo = new Animals("Kangaroo", name,100,35,
                4, 10, birthTime, 1, 0);
        PlayerStats.myAnimals.add(kangaroo);
    }

    //TODO: Add the rest of the animals using the methods above as a model

//    Animals ostrich = new Animals("Ostrich", 500, 25,6);
//    Animals snake = new Animals("Snake", 150, 15,5);
//    Animals lion = new Animals("Lion", 1500,60, 9);
//    Animals monkey = new Animals("Monkey", 350, 33, 7);
//    Animals elephant = new Animals("Elelphant", 1000, 70, 8);
//    Animals tiger = new Animals("Tiger", 1500, 60, 8);
//    Animals hippo = new Animals("Hippo", 1500, 60, 7);
//    Animals panda = new Animals("Panda", 450, 65, 8);
//    Animals giraffe = new Animals("Giraffe", 300, 35, 8);

}
