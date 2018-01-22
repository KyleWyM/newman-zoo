import java.util.Scanner;

public class Buyer {
    public static void buyAnimal(){
        while (Main.buyingAnimals == true) {
            Scanner user_input = new Scanner(System.in);
            System.out.println("What animal would you like to buy: Cows = 1 , Pigs = 2 , Chickens = 3, Done = 4");
            int decisions = user_input.nextInt();
            if (decisions == 1) {
                System.out.println("How many Cows would you like to buy");
                int tempcows = user_input.nextInt();
                int priceofcows = tempcows * 200;
                if (priceofcows > Main.cashMoney) {
                    System.out.println("You don't have that kind of money");
                } else {
                    Main.cows = tempcows + Main.cows;
                    Main.cashMoney = Main.cashMoney - priceofcows;
                    System.out.println("You now own " + Main.cows + " cows");
                    System.out.println("Money = " + Main.cashMoney);

                }
            } else {
                if (decisions == 2) {
                    System.out.println("How many Pigs would you like to buy");
                    int temppigs = user_input.nextInt();
                    int priceofpigs = temppigs * 100;
                    if (priceofpigs > Main.cashMoney) {
                        System.out.println("You don't have that kind of money");
                    } else {
                        Main.pigs = temppigs + Main.pigs;
                        Main.cashMoney = Main.cashMoney - priceofpigs;
                        System.out.println("You now own " + Main.pigs + " Pigs");
                        System.out.println("Money = " + Main.cashMoney);

                    }
                } else {
                    if (decisions == 3) {
                        System.out.println("How many Chickens would you like to buy");
                        int tempchickens = user_input.nextInt();
                        int priceofchickens = tempchickens * 50;
                        if (priceofchickens > Main.cashMoney) {
                            System.out.println("You don't have that kind of money");
                        } else {
                            Main.chickens = tempchickens + Main.chickens;
                            Main.cashMoney = Main.cashMoney - priceofchickens;
                            System.out.println("You now own " + Main.chickens + " chickens");
                            System.out.println("Money = " + Main.cashMoney);
                        }

                    } else {
                        if (decisions == 4) {
                            Main.buyingAnimals = false;
                        } else {
                            System.out.println("you f***** up somewhere");
                        }
                    }
                }
            }
        }
    }
}
