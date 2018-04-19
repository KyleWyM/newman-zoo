package com.newman.employees;

public class ListEmployees {
    public static void myList(){
        System.out.print("*list of employees*");
    }
    public static void listEmpoyees(){

        String numEmployeeMsg;
        int numEmployees;

        numEmployees = 0; // todo this will be the length of the array list
        myList();
        numEmployeeMsg = String.format("you have %s employees",numEmployees);

        System.out.print(numEmployeeMsg);
    }
}
