package com.newman.employees;
import com.newman.player.PlayerStats;
import ibio.*;

import static com.newman.employees.Employee.available_employees;
import static com.newman.employees.Employee.employee_list;
import static com.newman.employees.Employee.father_luca;
import static com.newman.game.CommandListener.help;
import static com.newman.game.DataCalculations.total_salaries;


public class ManageEmployees_SinglePlayer {
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    public static void list_employees() {
        IBIO.output("Available employees:");
        String message;
        message = String.format("    %-20s %-20s %-20s", "Employee", "Salary", "Experience");
        IBIO.output(message);
        for (int i = 0; i < available_employees.size(); i++) {
            Employee current_employee = available_employees.get(i);
            if (current_employee.level <= PlayerStats.level) {
                message = String.format("%2d. %-20s %-20d %-20d",
                        i + 1, current_employee.name, current_employee.salary, current_employee.experience);
                IBIO.output(message);
            }
        }
    }
    public static void hire_employees() {
        list_employees();
        String message = "Choose an employee \n** ";
        String chosen_employee = IBIO.input(message);
        int chosen_employee_index;
        if (isInteger(chosen_employee)) {
            chosen_employee_index = Integer.parseInt(chosen_employee);
            if (0 < chosen_employee_index && chosen_employee_index <= available_employees.size()) {
                chosen_employee = available_employees.get(chosen_employee_index-1).name;
            }
        }
        boolean successful_hire = false;
        int i = 0;
        while (i < available_employees.size() && !successful_hire) {
            if (available_employees.get(i).name.equals(chosen_employee) && available_employees.get(i).level <= PlayerStats.level) {
                PlayerStats.myEmployees.add(available_employees.get(i));
                if (available_employees.get(i).proper_name) {
                    message = String.format("You have hired %s!", available_employees.get(i).name);
                } else {
                    message = String.format("You have hired a new %s!", available_employees.get(i).name.toLowerCase());
                }
                IBIO.output(message);
                total_salaries = total_salaries + available_employees.get(i).salary;
                successful_hire = true;
            }
            i = i + 1;
        }
        if (!successful_hire) {
            IBIO.output("Hmm... that employee doesn't seem to be available, how about you try again!");
            hire_employees();
        }
    }
    public static void list_owned_employees() {
        IBIO.output("Your employees:");
        String message;
        message = String.format("    %-20s %-20s %-20s", "Employee", "Salary", "Experience");
        IBIO.output(message);
        for (int i = 0; i < PlayerStats.myEmployees.size(); i++) {
            Employee current_employee = PlayerStats.myEmployees.get(i);
            message = String.format("%2d. %-20s %-20d %-20d",
                    i+1, current_employee.name, current_employee.salary, current_employee.experience);
            IBIO.output(message);
        }

    }
    public static void fire_employees() {
        list_owned_employees();
        IBIO.output(String.format("%2d. let them keep their jobs", PlayerStats.myEmployees.size()+1));
        String message = "Which employee would you like to fire?\n** ";
        int chosen_employee_index = IBIO.inputInt(message);
        if (0 < chosen_employee_index && chosen_employee_index <= PlayerStats.myEmployees.size()) {
            if (available_employees.get(chosen_employee_index-1).equals(father_luca)) {
                message = "You can't fire Father Luca";
                IBIO.output(message);
                fire_employees();
            } else if (available_employees.get(chosen_employee_index-1).proper_name) {
                message = String.format("You have fired %s!", available_employees.get(chosen_employee_index-1).name);
                IBIO.output(message);
                total_salaries -= PlayerStats.myEmployees.get(chosen_employee_index - 1).salary;
                PlayerStats.myEmployees.remove(PlayerStats.myEmployees.get(chosen_employee_index-1));
                manage_employees();
            } else {
                message = String.format("You have hired a new %s!", available_employees.get(chosen_employee_index-1).name.toLowerCase());
                IBIO.output(message);
                total_salaries -= PlayerStats.myEmployees.get(chosen_employee_index - 1).salary;
                PlayerStats.myEmployees.remove(PlayerStats.myEmployees.get(chosen_employee_index-1));
                manage_employees();
            }
        } else if (chosen_employee_index == PlayerStats.myEmployees.size()+1) {
            manage_employees();
        } else {
            IBIO.output("Hmm... that doesn't seem like one of your employees, try again!");
            fire_employees();
        }
    }
    public static void manage_employees() {
        String[] command_list = new String[] {
                "hire employee", "fire employee", "my employees", "available employees", "leave employee management"
        };
        for (int i = 0; i < command_list.length; i++) {
            String message = String.format("%2d. %s", i+1, command_list[i]);
            IBIO.output(message);
        }
        String command = IBIO.input("** ");
        switch (command) {
            case "1":
            case "hire employee":
            case "hire":
                hire_employees();
                break;
            case "2":
            case "fire":
            case "fire employee":
                fire_employees();
            case "3":
            case "my employees":
                list_owned_employees();
                break;
            case "4":
            case "available employees":
                list_employees();
                break;
            case "5":
            case "leave":
                help();
                break;
            default:
                IBIO.output("Hmm that doesn't seem like a command, how about we try again!");
                manage_employees();
        }
    }
}
