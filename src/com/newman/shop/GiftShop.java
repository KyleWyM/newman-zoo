package com.newman.shop;

import com.newman.multiplayer.AskUser;
import ibio.*;
import com.newman.player.PlayerStats;

public class GiftShop {
    String username = "Jim"; //TODO, include from PlayerStats
    // at the moment is just an arbitrary number
    //it will correspond to the total number of customers declared in the Main
    int totalCustomers = 200;
    //it will correspond to the total money declared in the Main
    double totalMoney = 20000;
    // Array List is the list of employees for the gift shops
    // made by the employee group
    int employee = 40;
    //the employees for the Food and Beverage shop (50% total)
    int eFandB = employee / 2;
    //the employees for the Zoovenir shop (15% total)
    int eZ = employee * 15 / 100;
    //the employees for the Stuffed With Joy shop (15% total)
    int eSWJ = employee * 15 / 100;
    //the employees for the Coffee shop (20% total)
    int eCS = employee / 5;
    //TODO

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

//                if (input.equals("1")) {
//
//                    if (FoodBeverageLevel == 2) {
//                        message = String.format("The price required to upgrade Food and beverage " +
//                                "from level 2 to level 3 this shop is %f", priceFandB_3);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//                        if (totalMoney >= priceFandB_3) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                FoodBeverageLevel = 3;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else {
//                        message = "You have reached the max level for this shop";
//                        IBIO.output(message);
//                    }
//
//                } else if (input.equals("Z")) {
//                    message = String.format("The current level of Zoovenir is %d", ZoovenirLevel);
//                    IBIO.output(message);
//                    if (ZoovenirLevel == 1) {
//                        message = String.format("The price required to upgrade Zoovenir " +
//                                "from level 1 to level 2 is %f", ZoovenirPrice);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//                        if (totalMoney >= ZoovenirPrice) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                ZoovenirLevel = 2;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else if (ZoovenirLevel == 2) {
//                        message = String.format("The price required to upgrade Zoovenir " +
//                                "from level 2 to level 3 this shop is %f", priceZ_3);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//
//                        if (totalMoney >= priceZ_3) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                ZoovenirLevel = 3;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else {
//                        message = "You have reached the max level for this shop";
//                        IBIO.output(message);
//                    }
//
//                } else if (input.equals("S")) {
//                    message = String.format("The current level of Stuffed with joy is %d", StuffedWithJoyLevel);
//                    IBIO.output(message);
//                    if (StuffedWithJoyLevel == 1) {
//                        message = String.format("The price required to upgrade Stuffed with joy " +
//                                "from level 1 to level 2 is %f", StuffedWithJoyPrice);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//                        if (totalMoney >= StuffedWithJoyPrice) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                StuffedWithJoyLevel = 2;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else if (StuffedWithJoyLevel == 2) {
//                        message = String.format("The price required to upgrade Stuffed with joy " +
//                                "from level 2 to level 3 this shop is %f", priceSWJ_3);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//
//                        if (totalMoney >= priceSWJ_3) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                StuffedWithJoyLevel = 3;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else {
//                        message = "You have reached the max level for this shop";
//                        IBIO.output(message);
//                    }
//
//                } else if (input.equals("C")) {
//                    message = String.format("The current level of Coffe shop is %d", CoffeeShopLevel);
//                    IBIO.output(message);
//                    if (CoffeeShopLevel == 1) {
//                        message = String.format("The price required to upgrade Coffe shop " +
//                                "from level 1 to level 2 is %f", CoffeeShopPrice);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//                        if (totalMoney >= CoffeeShopPrice) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                CoffeeShopLevel = 2;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else if (CoffeeShopLevel == 2) {
//                        message = String.format("The price required to upgrade Coffe shop " +
//                                "from level 2 to level 3 this shop is %f", priceCS_3);
//                        IBIO.output(message);
//                        message = String.format("At the moment tou have %f money", totalMoney);
//                        IBIO.output(message);
//
//                        if (totalMoney >= priceCS_3) {
//                            message = "Do you want to proceed with this upgrade?";
//                            IBIO.output(message);
//                            String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                                    "any other key if you don’t");
//                            if (answerFandB.equals("Y")) {
//                                CoffeeShopLevel = 3;
//                                message = "You have successfully upgraded your shop";
//                                IBIO.output(message);
//                            } else {
//                                message = "Upgrade not completed";
//                                IBIO.output(message);
//                            }
//
//                        } else {
//                            message = "You are too poor to upgrade this shop to a higher level";
//                            IBIO.output(message);
//                        }
//                    } else {
//                        message = "You have reached the max level for this shop";
//                        IBIO.output(message);
//                    }
//
//                }
//        }
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
        message = "Every shop will help you to earn more money from your customers.";
        IBIO.output(message);
        message = "The more customers you have, the more money you will earn.";
        IBIO.output(message);
        message = "You can also invest some money in your shops and increase their level.";
        IBIO.output(message);
        message = "In this way your shops will be more attractive and expansive for the customers.";
        IBIO.output(message);
        message = "Hence you will earn more money.";
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

    public static void giftshop_update() {
        //Changes money each turn
    }

    public void foodAndBeverage() {
        // the customers for the food and beverage shop will be 50%
        // of the total customers in the zoo
        double customers = totalCustomers * 0.5; //TODO: add in global variable for total customers
        //TODO: see alex for tickets
        // the amount of money that each customer will spend in this shop
        // corresponds to a random generated number
        // which goes from a minimum fixed number (in this case 1)
        // plus the number of employyes for the shop,
        // to a maximum fixed number (in this case 20)
        // plus the number of emplyees for the shop,
        // in this way increasing the amount of emplyees in a shop
        // there will be an increase in profit,
        // the same thing is valid also for the other shops below
        int min = (1 + eFandB)* FoodBeverageLevel;
        int max = (20 + eFandB)* FoodBeverageLevel;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void zoovenir() {
        // the customers for the food and beverage shop will be 70% of total
        double customers = totalCustomers * 0.7;
        int min = (5 + eZ)* ZoovenirLevel;
        int max = (15 + eZ)* ZoovenirLevel;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void stuffedWithJoy() {
        // the customers for the food and beverage shop will be 30% of total
        double customers = totalCustomers * 0.3;
        int min = (20 + eSWJ)* StuffedWithJoyLevel;
        int max = (50 + eSWJ)* StuffedWithJoyLevel;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void coffeeShop() {
        // the customers for the food and beverage shop will be 90% of total
        double customers = totalCustomers * 0.9;
        int min = (5 + eCS)* CoffeeShopLevel;
        int max = (15 + eCS)* CoffeeShopLevel;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void runShops() {
        intro();
        String message = String.format("\n" +username + ", you know have %f money",totalMoney);
        IBIO.output(message);
        message = "Do you want to open your shops and start earning some more?";
        IBIO.output(message);
        String answerOpenShops = IBIO.input("Answer (Y) if you do, answer with any other key if you don’t");
        if (answerOpenShops.equals("Y")) {
            foodAndBeverage();
            zoovenir();
            stuffedWithJoy();
            coffeeShop();
            message = String.format("\nThe shops are now open! " +
                    "\nYour money are already increased to %f", totalMoney);
            IBIO.output(message);
        }

        message = "\nHey " + username + ", do you want to increase the level of any of your shops?";
        IBIO.output(message);
        String answerIncreaseLvl = IBIO.input("Answer (Y) if you do, answer with any other key if you don’t");
        if (answerIncreaseLvl.equals("Y")) {
            increaseLevel();
        }
    }

    public static void main(String args[]) {
        GiftShop myShops = new GiftShop();
        myShops.runShops();
    }
}



