package com.newman.employees;

import ibio.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {

    public String name;
    int experience;
    int salary; //weekly salary
    public int level;

    public Employee(String name, int experience, int salary, int level) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
        this.level = level;
    }
    public static Employee reluctant_teenager = new Employee("Reluctant Teenager", 1, 5, 1);
    static Employee average_teenager = new Employee("Average Teenager", 2, 7, 2);
    static Employee nerdy_teenager = new Employee("Nerdy Teenager", 3, 9, 2);
    static Employee steve_irwin = new Employee("Steve Irwin", 100, 1000, 10);
    public static Employee[] employee_list = new Employee[] {
      reluctant_teenager, average_teenager, nerdy_teenager, steve_irwin,
    };
    public static ArrayList<Employee> available_employees = new ArrayList<Employee>();
}



