import ibio.*;

public class GiftShop {
    int totalCustomers = 500;
    int totalMoney = 0;
    int employee = 40;
    int eFandB = employee/2; //the employees for the Food and Beverage shop (50% total)
    int eZ = employee*15/100; //the employees for the Zoovenir shop (15% total)
    int eSWJ = employee*15/100; //the employees for the Stuffed With Joy shop (15% total)
    int eCS= employee/5; //the employees for the Coffee shop (20% total)

    public void foodAndBeverage() {
        double customers = totalCustomers * 0.5;
        int min = 1 + eFandB;
        int max = 20 + eFandB;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void zoovenir() {
        double customers = totalCustomers * 0.7;
        int min = 5 + eZ;
        int max = 15 + eZ;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void stuffedWithJoy() {
        double customers = totalCustomers * 0.3;
        int min = 20 + eSWJ;
        int max = 50 + eSWJ;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void coffeeShop() {
        double customers = totalCustomers * 0.9;
        int min = 5 + eCS;
        int max = 15 + eCS;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

}
