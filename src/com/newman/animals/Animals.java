package com.newman.animals;

public class Animals {
    private String species;
    private String name;
    private int price;
    private int maintenance; //including the price to feed and the price to clean
    private int reputation;  //on a scale of one to ten how popular the animal is

    public Animals(String species, String name, int price, int maintenance, int reputation) {
        this.species = species;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.name = name;

        /*
        TODO: We have not yet decided whether to give individual animals names. This is temporary.
        TODO: Currently some portions of the code assume animals are individual objects while
        TODO: other parts assume each species is an instance of animal.
        TODO: If we decide not to have individual objects for each animal, then get rid of names
        TODO: This will mean we have to alter a lot of the code to make it compatible.
        */
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }
}

