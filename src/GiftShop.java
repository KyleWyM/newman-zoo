/*import ibio.*;

public class GiftShop extends Employee{
    // at the moment is just an arbitrary number
    //it will correspond to the total number of customers declared in the Main
    int totalCustomers = 500;
    //it will correspond to the total money declared in the Main
    int totalMoney = 0;
    // Array List is the list of employees for the gift shops
    // made by the employee gruop
    int employee = ArrayList.lenght;
    //the employees for the Food and Beverage shop (50% total)
    int eFandB = employee/2;
    //the employees for the Zoovenir shop (15% total)
    int eZ = employee*15/100;
    //the employees for the Stuffed With Joy shop (15% total)
    int eSWJ = employee*15/100;
    //the employees for the Coffee shop (20% total)
    int eCS= employee/5;

    public void foodAndBeverage() {
        // the customers for the food and beverage shop will be 50%
        // of the total customers in the zoo
        double customers = totalCustomers * 0.5;
        // the amount of money that each customer will spend in this shop
        // corresponds to a random generated number
        // which goes from a minimum fixed number (in this case 1)
        // plus the number of employyes for the shop,
        // to a maximum fixed number (in this case 20)
        // plus the number of emplyees for the shop,
        // in this way increasing the amount of emplyees in a shop
        // there will be an increase in profit,
        // the same thing is valid also for the other shops below
        int min = 1 + eFandB;
        int max = 20 + eFandB;

        for (int i = 0; i < customers; i++) {
            int random = min + (int) (Math.random() * ((max - min) + 1));
            int money = random;
            totalMoney = totalMoney + money;
        }
    }

    public void zoovenir() {
        // the customers for the food and beverage shop will be 70% of total
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
        // the customers for the food and beverage shop will be 30% of total
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
        // the customers for the food and beverage shop will be 90% of total
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
*/