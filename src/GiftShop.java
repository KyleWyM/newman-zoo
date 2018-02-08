import ibio.*;

public class GiftShop {
    int totalCustomers = 500;
    int totalMoney = 0;

    public void foodAndBeverage() {
        double customers = totalCustomers * 0.5;
        int min = 1;
        int max = 20;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void zoovenir() {
        double customers = totalCustomers * 0.7;
        int min = 5;
        int max = 15;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void stuffedWithJoy() {
        double customers = totalCustomers * 0.3;
        int min = 20;
        int max = 50;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void coffeeShop() {
        double customers = totalCustomers * 0.9;
        int min = 5;
        int max = 15;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

}
