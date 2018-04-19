package com.newman.animals;

import com.newman.multiplayer.Attack;
import com.newman.multiplayer.Client;

import java.util.ArrayList;

public class Animals {
    public String species;
    public String name;
    public int price;
    public int maintenance; //including the price to feed and the price to clean
    public int reputation;  //on a scale of one to ten how popular the animal is
    public int growthTime;
    public int level;
    public int birthTime;
    public int health;
    public int labor;
    public ArrayList<Attack> attacks;

    public Animals(String species, String name, int price, int maintenance, int reputation,
                   int growthTime, int birthTime, int labor, int level) {
        this.species = species;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.name = name;
        this.birthTime = birthTime;
        this.level = level;
        this.growthTime = growthTime;
        this.labor = labor;
        this.health = 100;
        attacks = new ArrayList<>();
    }

    public void update(Client client, int globalTime) {
        //TODO
        if (globalTime - birthTime > growthTime * (level+1)) { //TODO: come up with a better algorithm to decide growth
            level++;
            client.println("Your " + species + " " + name + " has grown to level " + level + ".");
            reputation += 10;
            maintenance--;
        }
    }
}