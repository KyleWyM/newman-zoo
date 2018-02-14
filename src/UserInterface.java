import ibio.*;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    //indicates whether to continue the game or not.
    boolean keepGoing;
    List<Animal_Test> animals;

    public UserInterface(boolean keepGoing, List<Animal_Test> animals) {
        this.keepGoing = keepGoing;
        this.animals = animals;
    }

    //Please update whenever you add a new command
    //Number of commands is used when help command is called

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
            case "buy animal":
                buy_animal_command();
                break;
            case "report_command":
                report_command();
                break;
            case "my animals":
                my_animals();
                break;
            case "animal list":
                animal_list();
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
        for (int i = 0; i < command_list.length; i = i + 1) {

            String message = String.format( "%2d. %-20s %s",
                    i + 1, command_list[i][0], command_list[i][1]);

            IBIO.output(message);
        }
    }
    public void buy_animal_command() {
        String name;
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

    public void report_command() {
        //Daily finances
        //TODO
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

    public boolean checkForCancel(String input) {
        //This is a boolean function. Place it in UI
        //so that it can check if user has inputed false.
        //You put user input into the the parenthesis
        //True is returned if user says false.
        boolean cancelAction = false;
        if (input.equals("cancel")) {
            cancelAction = true;
        }
        return cancelAction;
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