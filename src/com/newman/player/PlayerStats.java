package com.newman.player;

import java.util.ArrayList;
import com.newman.animals.species.Animal;
import com.newman.employees.Employee;

public class PlayerStats {
    public static String name;
    public static int money = 500;
    public static int reputation;
    public static int level = 1;
    public static int dayNum;
//    public static int visitors; //TODO, how does this work?
//    public static int employees;
//    public static ArrayList<Animals> myAnimals = new ArrayList<>();
    public static ArrayList<Animal> myAnimals = new ArrayList<>();
    public static ArrayList<Employee> myEmployees = new ArrayList<>();
}
