//import java.util.Scanner;
//
//public class Buyer {
//    public static void buyAnimal(){
//        while (Main_V1.buyingAnimals == true) {
//            Scanner user_input = new Scanner(System.in);
//            System.out.println("What animal would you like to buy: Cows = 1 , Pigs = 2 , Chickens = 3, Done = 4");
//            int decisions = user_input.nextInt();
//            if (decisions == 1) {
//                System.out.println("How many Cows would you like to buy");
//                int tempcows = user_input.nextInt();
//                int priceofcows = tempcows * 200;
//                if (priceofcows > Main_V1.cashMoney) {
//                    System.out.println("You don't have that kind of money");
//                } else {
//                    Main_V1.cows = tempcows + Main_V1.cows;
//                    Main_V1.cashMoney = Main_V1.cashMoney - priceofcows;
//                    System.out.println("You now own " + Main_V1.cows + " cows");
//                    System.out.println("Money = " + Main_V1.cashMoney);
//
//                }
//            } else {
//                if (decisions == 2) {
//                    System.out.println("How many Pigs would you like to buy");
//                    int temppigs = user_input.nextInt();
//                    int priceofpigs = temppigs * 100;
//                    if (priceofpigs > Main_V1.cashMoney) {
//                        System.out.println("You don't have that kind of money");
//                    } else {
//                        Main_V1.pigs = temppigs + Main_V1.pigs;
//                        Main_V1.cashMoney = Main_V1.cashMoney - priceofpigs;
//                        System.out.println("You now own " + Main_V1.pigs + " Pigs");
//                        System.out.println("Money = " + Main_V1.cashMoney);
//
//                    }
//                } else {
//                    if (decisions == 3) {
//                        System.out.println("How many Chickens would you like to buy");
//                        int tempchickens = user_input.nextInt();
//                        int priceofchickens = tempchickens * 50;
//                        if (priceofchickens > Main_V1.cashMoney) {
//                            System.out.println("You don't have that kind of money");
//                        } else {
//                            Main_V1.chickens = tempchickens + Main_V1.chickens;
//                            Main_V1.cashMoney = Main_V1.cashMoney - priceofchickens;
//                            System.out.println("You now own " + Main_V1.chickens + " chickens");
//                            System.out.println("Money = " + Main_V1.cashMoney);
//                        }
//
//                    } else {
//                        if (decisions == 4) {
//                            Main_V1.buyingAnimals = false;
//                        } else {
//                            System.out.println("you f***** up somewhere");
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
