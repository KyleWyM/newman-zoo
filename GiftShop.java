import ibio.*;

public class GiftShop {
    static int totalCustomers;
    totalCustomers = 500;
    int totalMoney = 0;

    public static double foodAndBeverage {
        int customers = totalCustomers * 0.5;
        int min = 1;
        int max = 20;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public static double zoovenir {
        int customers = totalCustomers * 0.5;
        int min = 5;
        int max = 15;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public static double stuffedWithJoy {
        int customers = totalCustomers * 0.5;
        int min = 20;
        int max = 50;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public static double coffeeShop {
        int customers = totalCustomers * 0.5;
        int min = 5;
        int max = 15;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

}
