import ibio.*;

public class Command {

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
            {"help", "lists possible commands"},
            {"buy animal", "buys an animal of a specific type"},
            {"report", "displays daily report"},
            {"my animals", "lists all owned animals"},
            {"animal list", "lists all species available"},
            {"end turn", "finished the turn"}
//            {"cancel", "cancels the action you are in"} TODO

    };

    //When a user enters a string, user_interface checks for
    //existing commands
    public static void user_interface(String command) {
        if (command.equals("help")) {
            help_command();
        } else if (command.equals("buy animal")) {
            buy_animal_command();
        } else if (command.equals("report")) {
            report();
        } else if (command.equals("my animals")) {
            my_animals();
        } else if (command.equals("animal list")) {
            animal_list();
        } else if (command.equals("end turn")) {
            //Just for testing purposes
            keepGoing = false;
        } else {
            //Outputed if user says something that doesn't work like "hfhfdj"
            IBIO.output("not a command");
        }
    }

    public static void help_command() {
        for (int i = 0; i < command_list.length; i = i + 1) {
            String command_info = String.format("%s -- %s",
                    command_list[i][0], command_list[i][1]);
            IBIO.output(command_info);
        }
    }

    public static void buy_animal_command() {
        String message = "Choose an animal you would like to purchase -> ";
        String animal_purchase = IBIO.input(message);

        //The following loop checks through all existing animals
        //Then it adds the animal to your array which you choose
        //species[] is the array of all the different animal names

//        for (int i = 0; i < species.length; i = i +1) {
//            if (species[i].equals(animal_purchase)) {
//                //asks for name and adds animal to array
//            }
//        }

        //allow for cancellation
    }

    public static void report() {
        //Daily finances
        //TODO
    }

    public static void my_animals() {
        //lists the animals in your array list of owned animals
        //Waiting for animal class file to be uploaded so I can
        //incorporate the animals into Profile.java, where the animals
        //the player owns are stored in an array
        //TODO
    }

    public static void animal_list() {
        //Lists all species and cost in animal array
        //Waiting for animal class file to be uploaded so I can
        //List access the array for this method
        //TODO
    }

    public static boolean checkForCancel(String input) {
        //This is a boolean function. Place it in UI
        //so that it can check if user has inputed false.
        //You put user input into the the parenthesis
        //True is returned if user says false.
        boolean endTurn = false;
        if (input.equals("cancel")) {
            endTurn = true;
        }
        return endTurn;    }

    public static boolean checkForEndTurn(String input) {
        //This is a boolean function. Place it in UI
        //so that it can check if user has inputed false.
        //You put user input into the the parenthesis
        //True is returned if user says false.
        boolean endTurn = false;
        if (input.equals("end turn")) {
            endTurn = true;
        }
        return endTurn;
    }



    //
    //
    //Main here for testing purposes only
    //
    //
    static boolean keepGoing = true;
    public static void main(String[] args) {

        while (keepGoing) {
            user_interface(IBIO.input("-> "));
        }
    }

}