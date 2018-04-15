//import ibio.*;
//
//public class GiftShop {
//    String username = "Jim";
//    // at the moment is just an arbitrary number
//    //it will correspond to the total number of customers declared in the Main
//    int totalCustomers = 200;
//    //it will correspond to the total money declared in the Main
//    double totalMoney = 20000;
//    // Array List is the list of employees for the gift shops
//    // made by the employee group
//    int employee = 40;
//    //the employees for the Food and Beverage shop (50% total)
//    int eFandB = employee / 2;
//    //the employees for the Zoovenir shop (15% total)
//    int eZ = employee * 15 / 100;
//    //the employees for the Stuffed With Joy shop (15% total)
//    int eSWJ = employee * 15 / 100;
//    //the employees for the Coffee shop (20% total)
//    int eCS = employee / 5;
//
//    // the starting levels of the shops, the max is 3
//    int levelFandB = 1;
//    int levelZ = 1;
//    int levelSWJ = 1;
//    int levelCS = 1;
//
//    //the prices in order to increase the level from 1 to 2
//    double priceFandB_2 = 5000;
//    double priceZ_2 = 5700;
//    double priceSWJ_2 = 6000;
//    double priceCS_2 = 6200;
//
//    //the prices in order to increase the level from 2 to 3
//    double priceFandB_3 = 15000;
//    double priceZ_3 = 15700;
//    double priceSWJ_3 = 16000;
//    double priceCS_3 = 16200;
//
//
//    public void increaseLevel() {
//        String message = "\nI am glad that you want to invest money in your shops";
//        IBIO.output(message);
//        message = "Which shop do you want to upgrade?";
//        IBIO.output(message);
//        String answer2 = IBIO.input(" \nAnswer \n(F) for Food and beverage, \n" +
//                "(Z) for Zoovenir,\n(S) for stuffed with joy, \n" +
//                "(C) for coffee shop, \nAny other key to cancel");
//
//        if (answer2.equals("F")) {
//            message = String.format("The current level of Food and beverage is %d", levelFandB);
//            IBIO.output(message);
//            if (levelFandB == 1) {
//                message = String.format("The price required to upgrade Food and beverage " +
//                        "from level 1 to level 2 is %f", priceFandB_2);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//                if (totalMoney >= priceFandB_2) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelFandB = 2;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else if (levelFandB == 2) {
//                message = String.format("The price required to upgrade Food and beverage " +
//                        "from level 2 to level 3 this shop is %f", priceFandB_3);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//                if (totalMoney >= priceFandB_3) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelFandB = 3;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else {
//                message = "You have reached the max level for this shop";
//                IBIO.output(message);
//            }
//
//        } else if (answer2.equals("Z")) {
//            message = String.format("The current level of Zoovenir is %d", levelZ);
//            IBIO.output(message);
//            if (levelZ == 1) {
//                message = String.format("The price required to upgrade Zoovenir " +
//                        "from level 1 to level 2 is %f", priceZ_2);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//                if (totalMoney >= priceZ_2) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelZ = 2;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else if (levelZ == 2) {
//                message = String.format("The price required to upgrade Zoovenir " +
//                        "from level 2 to level 3 this shop is %f", priceZ_3);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//
//                if (totalMoney >= priceZ_3) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelZ = 3;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else {
//                message = "You have reached the max level for this shop";
//                IBIO.output(message);
//            }
//
//        } else if (answer2.equals("S")) {
//            message = String.format("The current level of Stuffed with joy is %d", levelSWJ);
//            IBIO.output(message);
//            if (levelSWJ == 1) {
//                message = String.format("The price required to upgrade Stuffed with joy " +
//                        "from level 1 to level 2 is %f", priceSWJ_2);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//                if (totalMoney >= priceSWJ_2) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelSWJ = 2;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else if (levelSWJ == 2) {
//                message = String.format("The price required to upgrade Stuffed with joy " +
//                        "from level 2 to level 3 this shop is %f", priceSWJ_3);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//
//                if (totalMoney >= priceSWJ_3) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelSWJ = 3;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else {
//                message = "You have reached the max level for this shop";
//                IBIO.output(message);
//            }
//
//        } else if (answer2.equals("C")) {
//            message = String.format("The current level of Coffe shop is %d", levelCS);
//            IBIO.output(message);
//            if (levelCS == 1) {
//                message = String.format("The price required to upgrade Coffe shop " +
//                        "from level 1 to level 2 is %f", priceCS_2);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//                if (totalMoney >= priceCS_2) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelCS = 2;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else if (levelCS == 2) {
//                message = String.format("The price required to upgrade Coffe shop " +
//                        "from level 2 to level 3 this shop is %f", priceCS_3);
//                IBIO.output(message);
//                message = String.format("At the moment tou have %f money", totalMoney);
//                IBIO.output(message);
//
//                if (totalMoney >= priceCS_3) {
//                    message = "Do you want to proceed with this upgrade?";
//                    IBIO.output(message);
//                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
//                            "any other key if you don’t");
//                    if (answerFandB.equals("Y")) {
//                        levelCS = 3;
//                        message = "You have successfully upgraded your shop";
//                        IBIO.output(message);
//                    } else {
//                        message = "Upgrade not completed";
//                        IBIO.output(message);
//                    }
//
//                } else {
//                    message = "You are too poor to upgrade this shop to a higher level";
//                    IBIO.output(message);
//                }
//            } else {
//                message = "You have reached the max level for this shop";
//                IBIO.output(message);
//            }
//
//        }
//    }
//
//    public void intro() {
//        String message = "Hello " + username + ", you are entering the gift shop area of your zoo.";
//        IBIO.output(message);
//        message = "This is the list of the shops that you have available, followed by their level.";
//        IBIO.output(message);
//        message = String.format("\nFood and beverage shop —> level %d", levelFandB);
//        IBIO.output(message);
//        message = String.format("Zoovenir shop —> level %d", levelZ);
//        IBIO.output(message);
//        message = String.format("Stuffed with joy shop —> level %d", levelSWJ);
//        IBIO.output(message);
//        message = String.format("Coffee shop —> level %d\n", levelCS);
//        IBIO.output(message);
//        message = "Every shop will help you to earn more money from your customers.";
//        IBIO.output(message);
//        message = "The more customers you have, the more money you will earn.";
//        IBIO.output(message);
//        message = "You can also invest some money in your shops and increase their level.";
//        IBIO.output(message);
//        message = "In this way your shops will be more attractive and expansive for the customers.";
//        IBIO.output(message);
//        message = "Hence you will earn more money.";
//        IBIO.output(message);
//    }
//
//    public void foodAndBeverage() {
//        // the customers for the food and beverage shop will be 50%
//        // of the total customers in the zoo
//        double customers = totalCustomers * 0.5;
//        // the amount of money that each customer will spend in this shop
//        // corresponds to a random generated number
//        // which goes from a minimum fixed number (in this case 1)
//        // plus the number of employyes for the shop,
//        // to a maximum fixed number (in this case 20)
//        // plus the number of emplyees for the shop,
//        // in this way increasing the amount of emplyees in a shop
//        // there will be an increase in profit,
//        // the same thing is valid also for the other shops below
//        int min = (1 + eFandB)*levelFandB;
//        int max = (20 + eFandB)*levelFandB;
//
//        for (int i = 0; i < customers; i++) {
//            int random = min + (int) (Math.random() * ((max - min) + 1));
//            int money = random;
//            totalMoney = totalMoney + money;
//        }
//    }
//
//    public void zoovenir() {
//        // the customers for the food and beverage shop will be 70% of total
//        double customers = totalCustomers * 0.7;
//        int min = (5 + eZ)*levelZ;
//        int max = (15 + eZ)*levelZ;
//
//        for (int i = 0; i < customers; i++) {
//            int random = min + (int) (Math.random() * ((max - min) + 1));
//            int money = random;
//            totalMoney = totalMoney + money;
//        }
//    }
//
//    public void stuffedWithJoy() {
//        // the customers for the food and beverage shop will be 30% of total
//        double customers = totalCustomers * 0.3;
//        int min = (20 + eSWJ)*levelSWJ;
//        int max = (50 + eSWJ)*levelSWJ;
//
//        for (int i = 0; i < customers; i++) {
//            int random = min + (int) (Math.random() * ((max - min) + 1));
//            int money = random;
//            totalMoney = totalMoney + money;
//        }
//    }
//
//    public void coffeeShop() {
//        // the customers for the food and beverage shop will be 90% of total
//        double customers = totalCustomers * 0.9;
//        int min = (5 + eCS)*levelCS;
//        int max = (15 + eCS)*levelCS;
//
//        for (int i = 0; i < customers; i++) {
//            int random = min + (int) (Math.random() * ((max - min) + 1));
//            int money = random;
//            totalMoney = totalMoney + money;
//        }
//    }
//
//    public void runShops() {
//        intro();
//        String message = String.format("\n" +username + ", you know have %f money",totalMoney);
//        IBIO.output(message);
//        message = "Do you want to open your shops and start earning some more?";
//        IBIO.output(message);
//        String answerOpenShops = IBIO.input("Answer (Y) if you do, answer with any other key if you don’t");
//        if (answerOpenShops.equals("Y")) {
//            foodAndBeverage();
//            zoovenir();
//            stuffedWithJoy();
//            coffeeShop();
//            message = String.format("\nThe shops are now open! " +
//                    "\nYour money are already increased to %f", totalMoney);
//            IBIO.output(message);
//        }
//
//        message = "\nHey " + username + ", do you want to increase the level of any of your shops?";
//        IBIO.output(message);
//        String answerIncreaseLvl = IBIO.input("Answer (Y) if you do, answer with any other key if you don’t");
//        if (answerIncreaseLvl.equals("Y")) {
//            increaseLevel();
//        }
//    }
//
//    public static void main(String args[]) {
//        GiftShop myShops = new GiftShop();
//        myShops.runShops();
//    }
//}
//
//
//
