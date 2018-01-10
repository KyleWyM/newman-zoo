

// Cows cost 200, brings in 5 to 10 people per day,
// Pigs cost 100, brings in 2 to 5 people per day,
// Chickens cost 50, brings in 1 to 4 people per day,

import java.util.Random;
import ibio.*;
import java.util.Scanner;
public class Main {

    public static void main(String args[]) {
        boolean gameRunning = false;
        /*
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number: ");
        gameRunning = scanner.NextBoolean();
        if (gameRunning == True) {
            System.out.print("Game is running");
        }
        else{
            System.out.print("Game isn't running you dumbass");

        */

            Scanner user_input = new Scanner(System.in);
            String message;
            String first_name;
            int cows = 0;
            int pigs = 0;
            int chickens = 0;
            boolean buyingAnimals;
            System.out.print("Hey There fella why dontcha input your name => ");
            first_name = user_input.next();
            System.out.println("Well " + first_name + " that's a pretty cool name");
            message = "Well pal today is a pretty special day. Today is the day you get to start your new zoo! " +
                    "This zoo is being invested in by Newman Inc, who has payed for you zoo and given you 1000 Dollars to start your adventure." +
                    " We’re going to start of by buying any animals that you want.";
            int cashMoney = 1000;
            System.out.println(message);
            System.out.println("You have " + cashMoney + " dollars");
            System.out.println("Okay do you wanna buy any animals for your zoo? true or false => ");
            buyingAnimals = user_input.nextBoolean();
            if (buyingAnimals == true) {

                System.out.println("You can buy Cows for 200 dollars, Pigs for 100 dollars and Chickens for 50 dollars");
                System.out.println("How many Cows would you like to buy");
                int tempcows = IBIO.inputInt();
                int priceofcows = tempcows * 200;
                if (priceofcows > cashMoney) {
                    System.out.println("You don't have that kind of money");
                } else {
                    cows = tempcows + cows;
                    cashMoney = cashMoney - priceofcows;
                    System.out.println("You now own " + cows + " cows");
                    System.out.println("Money = " + cashMoney);

                }
                System.out.println("How many Pigs would you like to buy");
                int temppigs = IBIO.inputInt();
                int priceofpigs = temppigs * 100;
                if (priceofpigs > cashMoney) {
                    System.out.println("You don't have that kind of money");
                } else {
                    pigs = temppigs + pigs;
                    cashMoney = cashMoney - priceofpigs;
                    System.out.println("You now own " + pigs + " Pigs");
                    System.out.println("Money = " + cashMoney);

                }
                System.out.println("How many Chickens would you like to buy");
                int tempchickens = IBIO.inputInt();
                int priceofchickens = tempchickens * 50;
                if (priceofchickens > cashMoney) {
                    System.out.println("You don't have that kind of money");
                } else {
                    chickens = tempchickens + chickens;
                    cashMoney = cashMoney - priceofchickens;
                    System.out.println("You now own " + chickens + " chickens");
                    System.out.println("Money = " + cashMoney);
                }


            }
            System.out.println("Would you like to start the game now (true or false)  =>  ");
            gameRunning = user_input.nextBoolean();

            int dateCounter = 1;
            int visitors = 0;

            while (gameRunning == true) {

                Random rn = new Random();
                System.out.println("Day " + dateCounter);
                for (int i = 0; i == cows; i++) {
                    int answer = rn.nextInt(6) + 5; // random int 5 to 10
                    visitors = visitors + answer;
                }
                for (int i = 0; i == pigs; i++) {
                    int answer = rn.nextInt(6) + 2; // random int 5 to 10
                    visitors = visitors + answer;
                }

                dateCounter = dateCounter + 1;


            }
        }

    }

