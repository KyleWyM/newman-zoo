/*package com.newman.shop_work_in_progress;

import ibio.*;

public class CoffeeShop extends GiftShop {
    public CoffeeShop(int shopEmployee, int shopCustomers) {
        super(shopEmployee, shopCustomers, 1, 5700, 15700, 5,
                15, 3,2);
        this.shopEmployee = totalEmployee *15/100;
        this.shopCustomers = GiftShop.totalCustomers * 9 / 10;
    }

    public void runShop() {
        if (GiftShop.userLevel>=this.unlockLevel) {
            // the amount of money that each customer will spend in this shop
            // corresponds to a random generated number
            // which goes from a minimum fixed number (in this case 1)
            // plus the number of employyes for the shop,
            // to a maximum fixed number (in this case 20)
            // plus the number of emplyees for the shop,
            // in this way increasing the amount of emplyees in a shop
            // there will be an increase in profit,
            // the same thing is valid also for the other shops below
            this.min = (this.min + this.shopEmployee) * this.shopLevel;
            this.max = (this.max + this.shopEmployee) * this.shopLevel;

            for (int i = 0; i < this.shopCustomers; i++) {
                int random = this.min + (int) (Math.random() * ((this.max - this.min) + 1));
                int money = random;
                GiftShop.totalMoney = GiftShop.totalMoney + money;
            }
        }
    }

    public void increaseLevel() {
        String message;
        if (GiftShop.userLevel>=this.unlockLevel) {
            message = String.format("The current level of Coffee shop is %d", this.shopLevel);
            IBIO.output(message);
            if (this.shopLevel == 1) {
                message = String.format("The price required to upgrade Coffe shop " +
                        "from level 1 to level 2 is %f", this.upgrade1_2);
                IBIO.output(message);
                message = String.format("At the moment tou have %f money", GiftShop.totalMoney);
                IBIO.output(message);
                if (GiftShop.totalMoney >= this.upgrade1_2) {
                    message = "Do you want to proceed with this upgrade?";
                    IBIO.output(message);
                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
                            "any other key if you don’t");
                    if (answerFandB.equals("Y")) {
                        this.shopLevel = 2;
                        message = "You have successfully upgraded your shop";
                        IBIO.output(message);
                    } else {
                        message = "Upgrade not completed";
                        IBIO.output(message);
                    }

                } else {
                    message = "You are too poor to upgrade this shop to a higher level";
                    IBIO.output(message);
                }
            } else if (this.shopLevel == 2) {
                message = String.format("The price required to upgrade Coffee shop " +
                        "from level 2 to level 3 this shop is %f", this.upgrade2_3);
                IBIO.output(message);
                message = String.format("At the moment tou have %f money", GiftShop.totalMoney);
                IBIO.output(message);

                if (GiftShop.totalMoney >= this.upgrade2_3) {
                    message = "Do you want to proceed with this upgrade?";
                    IBIO.output(message);
                    String answerFandB = IBIO.input("\nAnswer (Y) if you do, answer with " +
                            "any other key if you don’t");
                    if (answerFandB.equals("Y")) {
                        this.shopLevel = 3;
                        message = "You have successfully upgraded your shop";
                        IBIO.output(message);
                    } else {
                        message = "Upgrade not completed";
                        IBIO.output(message);
                    }

                } else {
                    message = "You are too poor to upgrade this shop to a higher level";
                    IBIO.output(message);
                }
            } else {
                message = "You have reached the max level for this shop";
                IBIO.output(message);
            }
        } else {
            IBIO.output(String.format("You can't upgrade this shop because it is locked," +
                    "\n Increase your level to unlock it"));
        }


    }

}
*/