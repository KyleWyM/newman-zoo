package com.newman.employees;

import ibio.*;

import java.io.Serializable;
import java.util.ArrayList;

public class Employee implements Serializable {

    public String name;
    int experience;
    public int salary; //weekly salary
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
    static Employee undergrad_student = new Employee("Undergraduate Student", 4, 12, 3);
    static Employee biology_major = new Employee("Biology Major", 5, 15, 4);
    static Employee zoologist = new Employee("Zoologist", 7, 20, 5);
    static Employee martin = new Employee("Martin Lentz", 0, 1, 6);
    static Employee steve_irwin = new Employee("Steve Irwin", 100, 1000, 10);
    static Employee father_luca = new Employee("Father Luca", 10000, 1000000000, 11);
    public static Employee[] employee_list = new Employee[] {
      reluctant_teenager, average_teenager, nerdy_teenager, undergrad_student, biology_major, zoologist, martin,
            steve_irwin, father_luca
    };
    public static ArrayList<Employee> available_employees = new ArrayList<Employee>();
}



