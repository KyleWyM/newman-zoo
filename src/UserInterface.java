import ibio.*;
import java.util.List;

public class UserInterface {

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

    public UserInterface(List<Animal_Test> animals, String name, int money) {
        this.keepGoing = true;
        this.animals = animals;
        this.turnNum = 1;
        this.turn_in_session = true;
        this.name = name;
        this.money = money; //Initial savings
        this.revenue = 10; //Initial daily revenue
        this.reputation = 100; //Initial reputation
        this.expenses = 0; //Initial expenses
    }

    //This is a list of all commands for use in the help command
    //Each command contains a name, and then a description.
    //The first number is the number of the command
    //Second number is either 0 or 1. 0 indicates name,
    //While 1 indicates description.
    //
    //Commands listed here:
    static String[][] command_list = new String[][]{
            {"help", "lists possible commands."},
            {"buy animal", "buys an animal of a specific type."},
            {"report_command", "displays daily report_command."},
            {"my animals", "lists all owned animals."},
            {"animal list", "lists all species available."},
            {"turn", "ends the turn."},
            {"end game", "quits the game."}
//            {"cancel", "cancels the action you are in"} TODO
    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public void requestCommand(String command) {
        switch (command) {
            case "help":
                help_command();
                break;
            case "my report":
                myReport();
                break;
            case "buy animal":
                buy_animal_command();
                break;
            case "my animals":
                my_animals();
                break;
            case "animal list":
                animal_list();
                break;
            case "turn":
                this.turn_in_session = false;
                break;
            case "end game":
                //Just for testing purposes
                //If game is not ended, keep-going is true
                this.keepGoing = !checkForEndGame();
                break;
            default:
                //Outputed if user says something that doesn't work like "hfhfdj"
                IBIO.output("** Type 'help' for a list of commands.");
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

    public void buy_animal_command() {
        String name; //name of the animal
        String message = "** Choose an animal you would like to purchase -> ";
        String animal_purchase = IBIO.input(message);

        switch (animal_purchase) {
            case "Kangaroo":
                name = IBIO.input("** Please name the animal -> ");
                animals.add(new Kangaroo(name));
                IBIO.output("Animal successfully named.");
                break;
            case "Zebra":
                name = IBIO.input("** Please name the animal -> ");
                animals.add(new Zebra(name));
                IBIO.output("Animal successfully named.");
                break;
            default:
                //Outputed if user says something that doesn't work like "hfhfdj"
                IBIO.output("** Unknown animal. (Entries are case sensitive).");
        }
    }

    public void my_animals() {
        for (int i = 0; i < animals.size(); i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, animals.get(i).species_name, animals.get(i).getName());

            IBIO.output(message);
        }
    }

    public void animal_list() {
        //Lists all species and cost in animal array
        //Waiting for animal class file to be uploaded so I can
        //List access the array for this method
        //TODO
    }

    public boolean checkForEndGame() {
        //This is a boolean function. Place it in UI
        //so that it can check if user has inputed false.
        //You put user input into the the parenthesis
        //True is returned if user says false.
        boolean endGame = false;
        String message = "** Are you sure you want to end the game?\n" +
                "(Yes or No)\n";
        String response = IBIO.input(message);

            switch (response) {
                case "Yes":
                    IBIO.output("The game has been ended.");
                    turn_in_session = false;
                    endGame = true;
                    break;
                case "No":
                    IBIO.output("The game will continue.");
                    break;
                default:
                    IBIO.output("Please answer yes or no.\n" +
                            "Action cancelled.\n");
            }
        return endGame;
    }



}