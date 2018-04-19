package com.newman.employees;

import com.newman.employees.ListEmployees;

public class TrainEmployee {
    public static void trainEmployee(){
        String boop;
        String chosenOne;

        chosenOne = " *employee number* ";

        System.out.print("which employee would you like to choose");
        ListEmployees.myList();

        boop = String.format("the %s been trained, his XP i now %s",chosenOne, 0); //
        System.out.print(boop)
        ;

    }
}
