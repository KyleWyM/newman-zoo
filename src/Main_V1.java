/*import ibio.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_V1 {
    static String name = null;
    static int turnNum = 0;
    static int reputation = 100;
    static List<Animal_Test> animals = new ArrayList<>();
    //When switching over to Animals instead of Animal_Test, be careful of compatibility.
    //Particularly in Reader/Writer... TODO

    static String save_path = "Saves/Save1.txt";

    public static void main(String args[]) {

        UserInterface UI = new UserInterface(animals, name,1000, reputation, turnNum);

        boolean userHasResponded = false;
        boolean beginNewGame = false;
        while(!userHasResponded) {
            IBIO.output("Would you like to load data from a save?");
            String message = "Yes or no?\n";
            String response = IBIO.input(message).toLowerCase();
            if (response.equals("yes")) {
                try {
                    Reader.save_reader(save_path, UI);
                    userHasResponded = true;
                } catch (IOException e) {
                    IBIO.output("Failed to load data.");
                }
            } else if (response.equals("no")) {
                IBIO.output("A new game will begin.");
                beginNewGame = true;
                userHasResponded = true;
            }
        }

        if (beginNewGame) UI.name = intro();

        while (UI.keepGoing) {
            IBIO.output("\nTurn number : " + UI.turnNum);

            while (UI.turn_in_session) {
                String user_input_temp = IBIO.input();
                String user_input = user_input_temp.toLowerCase();
                UI.requestCommand(user_input);
            }

            if (UI.keepGoing) {
                IBIO.output("Turn completed.");
                UI.turnCycle();
                UI.turnNum++;
                UI.turn_in_session = true;
            } else {
                userHasResponded = false;
                String message = "Would you like to save the game?" +
                        "\nRespond 'Yes' or 'No'...\n";

                while (!userHasResponded) {
                    String response = IBIO.input(message).toLowerCase();
                    if (response.equals("yes")) {
                        try {
                            Writer.eraseSave(save_path);
                            Writer.saveGame(UI.name, UI.turnNum, UI.money, UI.reputation, UI.animals, save_path);
                            UI.myReport();
                            userHasResponded = true;
                        } catch (IOException e) {
                            IBIO.output("Failed to save data.");
                        }
                    } else if (response.equals("no")) {
                        IBIO.output("Game not saved.");
                        UI.myReport();
                        userHasResponded = true;
                    }
                }
            }
        }
    }

    public static String intro() {
        //Exposition and returns name to UI object.
        String username = IBIO.input("** Hello, what is your name?\n");
        String message = "** Welcome to the zoo " + username +
                ". You are now its owner...\nType 'help' for a list of commands.";
        IBIO.output(message);

        return username;
    }

}
*/