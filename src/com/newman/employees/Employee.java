package com.newman.employees;

import ibio.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {

    public String name;
    int experience;
    public int salary; //weekly salary
    public int level;
    public boolean proper_name;

    public Employee(String name, int experience, int salary, int level, boolean proper_name) {
        this.name = name;
        this.experience = experience;
        this.salary = salary;
        this.level = level;
        this.proper_name = proper_name;
    }
    public static Employee reluctant_teenager = new Employee("Reluctant Teenager", 1, 50, 1, false);
    static Employee average_teenager = new Employee("Average Teenager", 2, 70, 2, false);
    static Employee nerdy_teenager = new Employee("Nerdy Teenager", 3, 100, 2, false);
    static Employee undergrad_student = new Employee("Undergraduate Student", 4, 125, 3, false);
    static Employee biology_major = new Employee("Biology Major", 5, 200, 4, false);
    static Employee zoologist = new Employee("Zoologist", 7, 300, 3, false);
    static Employee martin = new Employee("Martin Lentz", 0, 400, 6, true);
    static Employee steve_irwin = new Employee("Steve Irwin", 20, 1000, 10, true);
    static Employee father_luca = new Employee("Father Luca", 10000, 1000000000, 11, true);

    public static Employee[] employee_list = new Employee[] {
      reluctant_teenager, average_teenager, nerdy_teenager, undergrad_student, biology_major, zoologist, martin,
            steve_irwin, father_luca
    };

    public static ArrayList<Employee> available_employees = new ArrayList<Employee>();
}



