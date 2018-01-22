import java.util.Scanner;

public class Main{
    public static int cows = 0;
    public static int pigs = 0;
    public static int chickens = 0;
    public static boolean buyingAnimals;
    public static int cashMoney = 1000;
    public static void main(String args[]){
        Scanner user_input = new Scanner(System.in);
        System.out.println("Yo whatup");
        System.out.println("Okay do you wanna buy any animals for your zoo? true or false => ");
        buyingAnimals = user_input.nextBoolean();
        Buyer.buyAnimal();
        System.out.println(cows);
        System.out.println(pigs);
        System.out.println(chickens);
        System.out.println(cashMoney);


    }
}
