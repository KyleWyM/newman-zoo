package com.newman.animals;

import com.newman.multiplayer.Client;
public class Animals {
    public String species;
    public String name;
    public int price;
    public int maintenance; //including the price to feed and the price to clean
    public int reputation;  //on a scale of one to ten how popular the animal is
    public int growthTime;
    public int level;
    public int birthTime;

    public Animals(String species, String name, int price, int maintenance, int reputation,
                   int growthTime, int birthTime, int level) {
        this.species = species;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.name = name;
        this.birthTime = birthTime;
        this.level = level;
        this.growthTime = growthTime;
    }

    public void update(Client client, int globalTime) {
        //TODO
        if (globalTime - birthTime < growthTime * (level+1)) { //TODO: come up with a better algorithm to decide growth
            level++;
            client.println("Your " + species + " " + name + " has grown to level " + level + ".");
        }
    }

}

