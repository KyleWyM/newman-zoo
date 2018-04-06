package com.newman.animals;

public class Animals {
    public String species;
    public String name;
    public int price;
    public int maintenance; //including the price to feed and the price to clean
    public int reputation;  //on a scale of one to ten how popular the animal is

    public Animals(String species, String name, int price, int maintenance, int reputation) {
        this.species = species;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.name = name;
    }

}

