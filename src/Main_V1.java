import ibio.*;

import java.util.ArrayList;
import java.util.List;

public class Main_V1 {
    public static void main(String args[]) {
        int money;
        int reputation;
        List<Animal_Test> animals = new ArrayList<Animal_Test>();

        UserInterface UI = new UserInterface(true, animals);

        intro();

        while (UI.keepGoing) {
                String user_input = IBIO.input();
                UI.requestCommand(user_input);
        }
    }

    public static void intro() {
        String username = IBIO.input("** Hello, what is you're name?\n");
        String message = "** Welcome to the zoo " + username +
                ". (insert exposition)...\nType 'help' for a list of commands.";
        IBIO.output(message);
    }
}
