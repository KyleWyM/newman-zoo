package com.newman.saves;

import com.newman.animals.species.Animal;
import com.newman.employees.Employee;
import com.newman.game.Main;
import com.newman.game.TicketAlgorithm;
import com.newman.player.PlayerStats;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveObject implements Serializable {
    //Game Data
    private String save_path;
    public boolean newGame;
    public int dayNum;

    //Player Data
    public String name;
    public int money;
    public int reputation;
    public int level;
    public ArrayList<Animal> myAnimals = new ArrayList<>();
    public ArrayList<Employee> myEmployees = new ArrayList<>();
    public int ticket_price;

    public SaveObject() {
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
    }

    public void loadDataToGame() {
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
    }

    public String getSave_path() {
        return save_path;
    }

    public void setSave_path(String save_path) {
        this.save_path = save_path;
    }
}
