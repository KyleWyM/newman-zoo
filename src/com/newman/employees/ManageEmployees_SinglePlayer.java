package com.newman.employees;
import com.newman.player.PlayerStats;
import ibio.*;

import static com.newman.employees.Employee.employee_list;
import static com.newman.game.CommandListener.help;


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
        for (int i = 0; i < employee_list.length; i++) {
            Employee current_employee = employee_list[i];
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
            if (0 < chosen_employee_index && chosen_employee_index <= employee_list.length) {
                chosen_employee = employee_list[chosen_employee_index-1].name;
            }
        }
        boolean successful_hire = false;
        int i = 0;
        while (i < employee_list.length && !successful_hire) {
            if (employee_list[i].name.equals(chosen_employee) && employee_list[i].level <= PlayerStats.level) {
                PlayerStats.myEmployees.add(employee_list[i]);
                message = String.format("You have hired a new %s!", employee_list[i].name.toLowerCase());
                IBIO.output(message);
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
    public static void manage_employees() {
        String[] command_list = new String[] {
                "hire employee", "my employees", "available employees", "leave employee management"
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
            case "my employees":
                list_owned_employees();
                break;
            case "3":
            case "available employees":
                list_employees();
                break;
            case "4":
            case "leave":
                help();
                break;
            default:
                IBIO.output("Hmm that doesn't seem like a command, how about we try again!");
                manage_employees();
        }
    }
}
