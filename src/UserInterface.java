import ibio.*;
import java.util.List;

public class UserInterface extends Autocorrect {

    //indicates whether to continue the game or not.
    int turnNum;
    boolean keepGoing;
    boolean turn_in_session;

    //Variables inputed from main (e.g. data about user)
    String name;
    List<Animal_Test> animals;
    int money;
    int revenue;
    int expenses;
    int reputation;

    public UserInterface(List<Animal_Test> animals, String name, int money, int reputation, int turnNum) {
        this.keepGoing = true;
        this.animals = animals;
        this.turnNum = turnNum;
        this.turn_in_session = true;
        this.name = name;
        this.money = money; //Initial savings
        this.revenue = 10; //Initial daily revenue
        this.reputation = reputation; //Initial reputation
        this.expenses = 0; //Initial expenses
    }

    //This is a list of all commands for use in the help command
    //Each command contains a name, and then a description.
    //The first number is the number of the command
    //Second number is either 0 or 1. 0 indicates name,
    //While 1 indicates description.
    //
    //Commands listed here:
    public static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy", "buys an animal of a specific type."},
            {"report", "displays daily report_command."},
            {"animals", "lists all owned animals."},
            {"list", "lists all species available."},
            {"next", "ends the turn."},
            {"hire employee", "hires employee"},
            {"train employee", "trains employee"},
            {"list employees", "list all employees"},
            {"quit", "quits the game."}
    };

    static String[] animal_list = new String[] {
            "Kangaroo",
            "Zebra",
            "Pig"
    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public void requestCommand(String command) {
        switch (command) {
            case "help":
                help_command();
                break;
            case "report":
                myReport();
                break;
            case "buy":
                String message = "** Choose an animal you would like to purchase -> ";
                String animal_purchase = IBIO.input(message);
                animal_purchase = animal_purchase.toLowerCase();
                int endNum = buy_animal_command(animal_purchase);

                if (endNum == -1) {
                    int bestMatchIndex = findMatch(animal_purchase,
                            createListVectors(animal_list));

                    IBIO.output("Did you mean " + animal_list[bestMatchIndex] + "?");
                    String input = IBIO.input("Yes or No? -> ");
                    input = input.toLowerCase();
                    if (input.equals("yes")) {
                        buy_animal_command(animal_list[bestMatchIndex]);
                    } else IBIO.output("Action cancelled.");
                }

                break;
            case "animals":
                my_animals();
                break;
            case "list":
                animal_list();
                break;
            case "next":
                this.turn_in_session = false;
                break;
            case "hire employee":
                Addemployee.addEmployee();
                // todo add stuff to the method
                break;
            case "train employee":
                TrainEmployee.trainEmployee();
                break;
            case "list employees":
                ListEmployees.listEmpoyees();
                break;
            case "quit":
                //Just for testing purposes
                //If game is not ended, keep-going is true
                this.keepGoing = !checkForEndGame();
                break;
            default:
                int bestMatchIndex =
                        findMatch(command, createListVectors(command_vector_list));
                requestCommand(command_vector_list[bestMatchIndex]);
        }
    }

    public void help_command() {
        //Lists the commands and descriptions
        for (int i = 0; i < command_list.length; i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, command_list[i][0], command_list[i][1]);
            IBIO.output(message);
        }
    }

    public void turnCycle() {
        //Updates vistors and money after each turn
        this.money += revenue;
        this.money -= expenses;
    }

    public void myReport() {
        IBIO.output("Bank Account: " + this.money);
        IBIO.output("Reputation: " + this.reputation);
    }

    public int buy_animal_command(String animal_purchase) {
        String name; //name of the animal

        switch (animal_purchase) {
            case "kangaroo":
                name = IBIO.input("** Please name the animal -> ");
                animals.add(new Kangaroo(name));
                IBIO.output("Animal successfully named.");
                break;
            case "zebra":
                name = IBIO.input("** Please name the animal -> ");
                animals.add(new Zebra(name));
                IBIO.output("Animal successfully named.");
                break;
            default:
                IBIO.output("** Unknown animal.");
                return -1;
                //This number is returned, so that the requestCommand knows to run a search
                //of possible animals the user meant, and then re-run with the correction if
                //the user chooses to
        }
        return 0;
    }

    public void my_animals() {
        for (int i = 0; i < animals.size(); i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, animals.get(i).species_name, animals.get(i).getName());

            IBIO.output(message);
        }
    }

    public void animal_list() {
        for (int i = 0; i < animal_list.length; i = i + 1) {

            String message = String.format( "%2d. %-20s",
                    i + 1, animal_list[i]);
            IBIO.output(message);
        }
    }

    public boolean checkForEndGame() {
        //This is a boolean function. Place it in UI
        //so that it can check if user has inputed false.
        //You put user input into the the parenthesis
        //True is returned if user says false.
        boolean endGame = false;
        String message = "** Are you sure you want to end the game?\n" +
                "(Yes or No)\n";
        String response = IBIO.input(message).toLowerCase();

            switch (response) {
                case "yes":
                case "y":
                    IBIO.output("The game has been ended.");
                    turn_in_session = false;
                    endGame = true;
                    break;
                case "no":
                    IBIO.output("The game will continue.");
                    break;
                default:
                    IBIO.output("Please answer yes or no.\n" +
                            "Action cancelled.\n");
            }
        return endGame;
    }



}