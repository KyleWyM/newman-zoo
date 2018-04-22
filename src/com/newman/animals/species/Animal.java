package com.newman.animals.species;

public class Animal {
    public String name;
    public int price;
    public int maintenance; // per day; including food price as well
    public int reputation; //scale of 1-10; aka attention given
    public int level; // 1-10;
    

    public Animal(String name, int price, int maintenance, int reputation) {
        this.name = name;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.level = 0;
    }
}
