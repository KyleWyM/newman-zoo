import ibio.*;

import java.util.ArrayList;
import java.util.List;

public class Main_V1 {
    static int money = 1000;
    static int reputation = 100;
    static int revenue = 5;

    public static void main(String args[]) {
        List<Animal_Test> animals = new ArrayList<Animal_Test>();

        UserInterface UI = new UserInterface(animals, intro(), 1000);

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
            } else UI.myReport();
        }
    }

    public static String intro() {
        //Exposition and returns name to UI object.
        String username = IBIO.input("** Hello, what is you're name?\n");
        String message = "** Welcome to the zoo " + username +
                ". (insert exposition)...\nType 'help' for a list of commands.";
        IBIO.output(message);

        return username;
    }

}
