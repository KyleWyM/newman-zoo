package com.newman.giftshop;

import com.newman.game.AskUser;
import ibio.*;
import com.newman.player.PlayerStats;

import static com.newman.game.CommandListener.help;
import static com.newman.game.DataCalculations.visitors;

public class GiftShop {
    //TODO: integrate employees with gift shop and make it so you can assign them roles

    private static int foodBeverage_employees = (int) (PlayerStats.myEmployees.size() * 0.50);
    static int zoovenir_employees = (int) (PlayerStats.myEmployees.size() * 0.15);
    static int stuffedWithJoy_employees = (int) (PlayerStats.myEmployees.size() * 0.15);
    static int coffeeShop_employees = (int) (PlayerStats.myEmployees.size() * 0.20);

    // the starting levels of the shops, the max is 3
    static private int FoodBeverageLevel = 1;
    static private int ZoovenirLevel = 1;
    static private int StuffedWithJoyLevel = 1;
    static private int CoffeeShopLevel = 1; //TODO, redundant, fix.

    //the prices in order to increase the level from 1 to 2
    static private int FoodBeveragePrice = 5000;
    static private int ZoovenirPrice = 5700;
    static private int StuffedWithJoyPrice = 6000;
    static private int CoffeeShopPrice = 6200;

    //the prices in order to increase the level from 2 to 3
//    int priceFandB_3 = 15000;
//    int priceZ_3 = 15700;
//    int priceSWJ_3 = 16000;
//    int priceCS_3 = 16200;
    //I commented out this code because it's easier to just ad $10,000 to the price each time.

    public static void increaseLevel() {
        String message = "\nI am glad that you want to invest money in your shops";
        IBIO.output(message);
        message = "Which shop do you want to upgrade?";
        IBIO.output(message);
        String input = IBIO.input("\n\t1. Food and Beverage\n\t" +
                "2. Zoovenir\n\t3. Stuffed with Joy\n\t" +
                "4. Coffee Shop \n\n\tAny other key to cancel\n\n");

        switch (input) {
            case "1":
                message = String.format("The current level of Food and beverage is %d", FoodBeverageLevel);
                IBIO.output(message);
                FoodBeverageLevel = checkPrice(FoodBeveragePrice, FoodBeverageLevel);
                break;
            case "2":
                message = String.format("The current level of Zoovenir is %d", ZoovenirLevel);
                IBIO.output(message);
                ZoovenirLevel = checkPrice(ZoovenirPrice, ZoovenirLevel);
                break;
            case "3":
                message = String.format("The current level of Stuffed with Joy is %d", StuffedWithJoyLevel);
                IBIO.output(message);
                StuffedWithJoyLevel = checkPrice(StuffedWithJoyPrice, StuffedWithJoyLevel);
                break;
            case "4":
                message = String.format("The current level of the Coffee Shop is %d", CoffeeShopLevel);
                IBIO.output(message);
                CoffeeShopLevel = checkPrice(CoffeeShopPrice, CoffeeShopLevel);
                break;
            default:
                IBIO.output("Action cancelled.");
        }
    }

    public static void intro() {
        String message = "Hello " + PlayerStats.name + ", you are entering the gift shop area of your zoo.";
        IBIO.output(message);
        message = "This is the list of the shops that you have available, followed by their level.";
        IBIO.output(message);
        message = String.format("\nFood and beverage shop —> level %d", FoodBeverageLevel);
        IBIO.output(message);
        message = String.format("Zoovenir shop —> level %d", ZoovenirLevel);
        IBIO.output(message);
        message = String.format("Stuffed with joy shop —> level %d", StuffedWithJoyLevel);
        IBIO.output(message);
        message = String.format("Coffee shop —> level %d\n", CoffeeShopLevel);
        IBIO.output(message);

        message = "\nEvery shop will help you to earn more money from your customers." +
                  "\nThe more customers you have, the more money you will earn." +
                  "\nYou can also invest some money in your shops and increase their level." +
                  "\nIn this way your shops will be more attractive and expansive for the customers." +
                  "\nHence you will earn more money.";
        IBIO.output(message);
    }


    public static int checkPrice(int price, int shop_level) {
        String message;
        message = String.format("The price required to upgrade " +
                " is %d", price);
        IBIO.output(message);
        message = String.format("At the moment you have %d money", PlayerStats.money);
        IBIO.output(message);

        if (PlayerStats.money >= price) {
            message = "Do you want to proceed with this upgrade?";
            IBIO.output(message);

            if (AskUser.yesOrNo()) {
                shop_level++;
                message = "You have successfully upgraded your shop";
                IBIO.output(message);
                return shop_level;
            } else {
                message = "Upgrade not completed";
                IBIO.output(message);
                return shop_level;
            }
        } else {
            message = "You are too poor to upgrade this shop to a higher level";
            IBIO.output(message);
            return shop_level;
        }
    }
    public static void manage_shops() {
        String[] command_list = new String[] {
                "about giftshop", "upgrade giftshop", "leave shop management"
        };
        for (int i = 0; i < command_list.length; i++) {
            String message = String.format("%2d. %s", i+1, command_list[i]);
            IBIO.output(message);
        }
        String command = IBIO.input("** ");
        switch (command) {
            case "1":
            case "about giftshop":
            case "hire":
                intro();
                break;
            case "2":
            case "upgrade":
            case "upgrade shops":
                increaseLevel();
                break;
            case "3":
            case "leave":
            case "leave shop management":
                help();
                break;
            default:
                IBIO.output("Hmm that doesn't seem like a command, how about we try again!");
                manage_shops();
        }
    }

    public static void runShops() {
        int min, max, total_earnings = 0;
        int shop_customers = (int) (0.5 * visitors); //Half of visitors attend the shop

        // The amount of money that each customer will spend in this shop
        // corresponds to a randomly generated number,
        // which goes from a minimum fixed number
        // (plus the number of employees for the shop)
        // to a maximum fixed number (plus the number of employees for the shop).
        // In this way, increasing the amount of employees in a shop
        // will increase profit.

        //Zoovenir
        min = (5 + zoovenir_employees) * ZoovenirLevel;
        max = (15 + zoovenir_employees) * ZoovenirLevel;
        for (int i = 0; i < shop_customers; i++) {
            total_earnings += min + (int) (Math.random() * ((max - min) + 1));
        }

        //Food and Beverage
        min = (1 + foodBeverage_employees) * FoodBeverageLevel;
        max = (20 + foodBeverage_employees) * FoodBeverageLevel;
        for (int i = 0; i < shop_customers; i++) {
            total_earnings += min + (int) (Math.random() * ((max - min) + 1));
        }

        //Stuffed with Joy
        min = (20 + stuffedWithJoy_employees) * StuffedWithJoyLevel;
        max = (50 + stuffedWithJoy_employees) * StuffedWithJoyLevel;
        for (int i = 0; i < shop_customers; i++) {
            total_earnings += min + (int) (Math.random() * ((max - min) + 1));
        }

        //Coffee Shop
        min = (5 + coffeeShop_employees) * CoffeeShopLevel;
        max = (15 + coffeeShop_employees) * CoffeeShopLevel;
        for (int i = 0; i < shop_customers; i++) {
            total_earnings += min + (int) (Math.random() * ((max - min) + 1));
        }

        PlayerStats.money += total_earnings;
        IBIO.output("Your shops have earned you $" + total_earnings + ".");
    }
}



