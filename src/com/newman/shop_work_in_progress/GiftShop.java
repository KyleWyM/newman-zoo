/*import com.sun.org.omg.CORBA.portable.ValueHelper;
import ibio.*;

public class GiftShop {
    static String username = "Jim";
    static int userLevel = 1;
    static int userReputation = 5;
    // at the moment is just an arbitrary number
    //it will correspond to the total number of customers declared in the Main
    static int totalCustomers = 200;
    //it will correspond to the total money declared in the Main
    static double totalMoney = 20000;
    // Array List is the list of employees for the gift shops
    // made by the employee group
    int totalEmployee = 40;
    int shopCustomers;
    int shopEmployee;
    int shopLevel;
    double upgrade1_2;
    double upgrade2_3;
    int min;
    int max;
    int unlockLevel;
    int reputation;



    public GiftShop(int employee,int shopCustomers, int shopLevel, double upgrade1_2,
                    double upgrade2_3, int min, int max, int unlockLevel,
                    int reputation) {
        this.shopEmployee = employee;
        this.shopCustomers = shopCustomers;
        this.shopLevel = shopLevel;
        this.upgrade1_2 = upgrade1_2;
        this.upgrade2_3 = upgrade2_3;
        this.min = min;
        this.max = max;
        this.unlockLevel = unlockLevel;
        this.reputation = reputation;
    }

    public static void Welcome() {
        String message = "Hello " + username + "\n __       __ ________ __       ______   ______  __       __ ________        ________  ______         ________ __    __ ________       \n" +
                "|  \\  _  |  |        |  \\     /      \\ /      \\|  \\     /  |        \\      |        \\/      \\       |        |  \\  |  |        \\      \n" +
                "| $$ / \\ | $| $$$$$$$| $$    |  $$$$$$|  $$$$$$| $$\\   /  $| $$$$$$$$       \\$$$$$$$|  $$$$$$\\       \\$$$$$$$| $$  | $| $$$$$$$$      \n" +
                "| $$/  $\\| $| $$__   | $$    | $$   \\$| $$  | $| $$$\\ /  $$| $$__             | $$  | $$  | $$         | $$  | $$__| $| $$__          \n" +
                "| $$  $$$\\ $| $$  \\  | $$    | $$     | $$  | $| $$$$\\  $$$| $$  \\            | $$  | $$  | $$         | $$  | $$    $| $$  \\         \n" +
                "| $$ $$\\$$\\$| $$$$$  | $$    | $$   __| $$  | $| $$\\$$ $$ $| $$$$$            | $$  | $$  | $$         | $$  | $$$$$$$| $$$$$         \n" +
                "| $$$$  \\$$$| $$_____| $$____| $$__/  | $$__/ $| $$ \\$$$| $| $$_____          | $$  | $$__/ $$         | $$  | $$  | $| $$_____       \n" +
                "| $$$    \\$$| $$     | $$     \\$$    $$\\$$    $| $$  \\$ | $| $$     \\         | $$   \\$$    $$         | $$  | $$  | $| $$     \\      \n" +
                " \\$$      \\$$\\$$$$$$$$\\$$$$$$$$\\$$$$$$  \\$$$$$$ \\$$      \\$$\\$$$$$$$$          \\$$    \\$$$$$$           \\$$   \\$$   \\$$\\$$$$$$$$      \n" +
                "                                                                                                                                      \n" +
                "                                                                                                                                      \n" +
                "                                                                                                                                      \n" +
                "  ______  ______ ________ ________         ______  __    __  ______  _______   ______          ______  _______  ________  ______      \n" +
                " /      \\|      |        |        \\       /      \\|  \\  |  \\/      \\|       \\ /      \\        /      \\|       \\|        \\/      \\     \n" +
                "|  $$$$$$\\\\$$$$$| $$$$$$$$\\$$$$$$$$      |  $$$$$$| $$  | $|  $$$$$$| $$$$$$$|  $$$$$$\\      |  $$$$$$| $$$$$$$| $$$$$$$|  $$$$$$\\    \n" +
                "| $$ __\\$$ | $$ | $$__      | $$         | $$___\\$| $$__| $| $$  | $| $$__/ $| $$___\\$$      | $$__| $| $$__| $| $$__   | $$__| $$    \n" +
                "| $$|    \\ | $$ | $$  \\     | $$          \\$$    \\| $$    $| $$  | $| $$    $$\\$$    \\       | $$    $| $$    $| $$  \\  | $$    $$    \n" +
                "| $$ \\$$$$ | $$ | $$$$$     | $$          _\\$$$$$$| $$$$$$$| $$  | $| $$$$$$$ _\\$$$$$$\\      | $$$$$$$| $$$$$$$| $$$$$  | $$$$$$$$    \n" +
                "| $$__| $$_| $$_| $$        | $$         |  \\__| $| $$  | $| $$__/ $| $$     |  \\__| $$      | $$  | $| $$  | $| $$_____| $$  | $$    \n" +
                " \\$$    $|   $$ | $$        | $$          \\$$    $| $$  | $$\\$$    $| $$      \\$$    $$      | $$  | $| $$  | $| $$     | $$  | $$    \n" +
                "  \\$$$$$$ \\$$$$$$\\$$         \\$$           \\$$$$$$ \\$$   \\$$ \\$$$$$$ \\$$       \\$$$$$$        \\$$   \\$$\\$$   \\$$\\$$$$$$$$\\$$   \\$$";
        IBIO.output(message);
    }

    public static void main(String args[]) {
        FoodAndBeverage myFood = new FoodAndBeverage(0,0);
        CoffeeShop myCoffee = new CoffeeShop(0,0);
        Zoovenir myZoovenir= new Zoovenir(0,0);
        StuffedWithJoy myStuffed = new StuffedWithJoy(0,0);
        CandiesShop myCandies = new CandiesShop(0,0);
        Jewellery myJewels = new Jewellery(0,0);
        Welcome();
        String message;
        String again = "Y";
        while (again.equals("Y")) {
            String action = IBIO.input("\nThis is a list of the actions that you can do:\n" +
                    "1. have some information about this area\n" +
                    "2. view your money\n" +
                    "3. list of the shops\n" +
                    "4. upgrade your shops\n" +
                    "5. open your shops to the customers\n" +
                    "Type any other key to exit the gift shop area\n");

            switch (action) {
                case "1":
                    message = "In the gift shop area of your zoo you will be able to manage many different shops.\n" +
                            "Every shop will help you to earn more money from your customers.\n" +
                            "The more customers you have, the more money you will earn.\n" +
                            "Increasing your reputation, and so your level, you will unlock new and more lucrative shops.\n" +
                            "You can also invest some money in your shops and increase their level.\n" +
                            "Higher level shops will be more attractive and expansive for your customers.\n";
                    IBIO.output(message);
                    break;
                case "2":
                    message = String.format("You have %f money at the moment.\n", totalMoney);
                    IBIO.output(message);
                    break;
                case "3":
                    message = "These are the shops that you currently own:\n";
                    IBIO.output(message);
                    if (userLevel >= myFood.unlockLevel) {
                        message = String.format("Food and beverage --> Level %d", myFood.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Food and beverage --> unlock at level %d", myFood.unlockLevel));
                    }

                    if (userLevel >= myCoffee.unlockLevel) {
                        message = String.format("Coffee Shop --> Level %d", myCoffee.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Coffee Shop --> unlock at level %d", myCoffee.unlockLevel));
                    }

                    if (userLevel >= myZoovenir.unlockLevel) {
                        message = String.format("Zoovenir --> Level %d", myZoovenir.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Zoovenir --> unlock at level %d", myZoovenir.unlockLevel));
                    }

                    if (userLevel >= myStuffed.unlockLevel) {
                        message = String.format("Stuffed With Joy --> Level %d", myStuffed.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Stuffed With Joy --> unlock at level %d", myStuffed.unlockLevel));
                    }

                    if (userLevel >= myCandies.unlockLevel) {
                        message = String.format("Candies Shop --> Level %d", myCandies.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Candies Shop --> unlock at level %d", myCandies.unlockLevel));
                    }

                    if (userLevel >= myJewels.unlockLevel) {
                        message = String.format("Jewellery --> Level %d", myJewels.shopLevel);
                        IBIO.output(message);

                    } else {
                        IBIO.output(String.format("Jewellery --> unlock at level %d", myJewels.unlockLevel));
                    }
                    break;
                case "4":
                    message = "\nI am glad that you want to invest money in your shops";
                    IBIO.output(message);
                    message = "Which shop do you want to upgrade?";
                    IBIO.output(message);
                    String answer = IBIO.input(" \n1. for Food and beverage, \n" +
                            "2. for Zoovenir,\n3. for stuffed with joy, \n" +
                            "4. for coffee shop, \n5. for candies shop, \n6. for Jewellery," +
                            "\nAny other key to cancel\n");


                    switch (answer) {
                        case "1":
                            myFood.increaseLevel();
                            break;
                        case "2":
                            myZoovenir.increaseLevel();
                            break;
                        case "3":
                            myStuffed.increaseLevel();
                            break;
                        case "4":
                            myCoffee.increaseLevel();
                            break;
                        case "5":
                            myCandies.increaseLevel();
                            break;
                        case "6":
                            myJewels.increaseLevel();
                            break;
                        default:
                            break;

                    }

                    break;
                case "5":
                    myFood.runShop();
                    myZoovenir.runShop();
                    myStuffed.runShop();
                    myCoffee.runShop();
                    myCandies.runShop();
                    myJewels.runShop();
                    message = String.format("Your shops are now open! Your money are already increased to %f", totalMoney);
                    IBIO.output(message);
                    break;
                default:
                    IBIO.output("It had been a pleasure, come back soon to the gift shop area \n");
                    again = "Forza inter";

            }
            if (action.equals("1") || action.equals("2") || action.equals("3") || action.equals("4") || action.equals("5")) {
                again = IBIO.input("\nDo you want to do something else? \nAnswer (Y) if you do," +
                        " \nAnswer any other key if you don't");
                if (!again.equals("Y")){
                    IBIO.output("\nIt had been a pleasure, come back soon to the gift shop area \n");
                }
            }
        }
    }
}
*/


