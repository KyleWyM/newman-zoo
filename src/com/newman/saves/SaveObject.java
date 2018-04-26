package com.newman.saves;

import com.newman.animals.ManageAnimals;
import com.newman.animals.species.Animal;
import com.newman.employees.Employee;
import com.newman.game.Main;
import com.newman.game.TicketAlgorithm;
import com.newman.player.PlayerStats;

import java.io.Serializable;
import java.util.ArrayList;

class SaveObject implements Serializable {


    private static final long serialVersionUID = -668677731915942571L;

    //Game Data
    private String save_path;
    private boolean newGame;
    private int dayNum;

    //Player Data
    private String name;
    private int money;
    private int reputation;
    private int level;
    private ArrayList<Animal> myAnimals = new ArrayList<>();
    private ArrayList<Employee> myEmployees = new ArrayList<>();
    private int ticket_price;
    private ArrayList<Animal> available_animals = new ArrayList<>();

    SaveObject() {
        //Game Data
        this.dayNum = PlayerStats.dayNum;
        this.save_path = Main.save_path;
        this.newGame = Main.newGame;

        //Player data
        this.name = PlayerStats.name;
        this.money = PlayerStats.money;
        this.reputation = PlayerStats.reputation;
        this.level = PlayerStats.level;
        this.myAnimals = PlayerStats.myAnimals;
        this.myEmployees = PlayerStats.myEmployees;

        //Other
        this.ticket_price = TicketAlgorithm.ticket_price;
        this.available_animals = ManageAnimals.available_animals;
    }

    void loadDataToGame() {
        //Game Data
        PlayerStats.dayNum = this.dayNum;
        Main.save_path = this.save_path;
        Main.newGame = this.newGame;

        //Player data
        PlayerStats.name = this.name;
        PlayerStats.money = this.money;
        PlayerStats.reputation = this.reputation;
        PlayerStats.level = this.level;
        PlayerStats.myAnimals = this.myAnimals;
        PlayerStats.myEmployees = this.myEmployees;

        //Other
        TicketAlgorithm.ticket_price = this.ticket_price;
        ManageAnimals.available_animals = this.available_animals;
    }

    String getSave_path() {
        return save_path;
    }

    void setSave_path(String save_path) {
        this.save_path = save_path;
    }
}
