package com.newman.player;

import com.newman.animals.Animals;
import com.newman.game.GameLoop;
import com.newman.multiplayer.Client;

import java.util.ArrayList;

public class Player {
    private String name;
    private int money;
    private int reputation;
    private int level;

    public ArrayList<Animals> myAnimals;
    private boolean adminRights;

    public Player(String name, int money, int reputation, int level) {
        this.name = name;
        this.money = money;
        this.reputation = reputation;
        this.level = level;
        ArrayList<Animals> myAnimals = new ArrayList<>();
        this.myAnimals = myAnimals;
        this.adminRights = false;
    }

    public void update(Client client) {
        for (int i = 0; i < myAnimals.size(); i++) {
            myAnimals.get(i).update(client, GameLoop.globalTime);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void giveAdminRights() {
        adminRights = true;
    }

    public void removeAdminRights() {
        adminRights = false;
    }

    public boolean hasAdminRights() {
        return adminRights;
    }
}
