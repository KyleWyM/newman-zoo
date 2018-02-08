import ibio.*;

public class Main_V1 {
    public static void main(String args[]){
        intro();
        UserInterface UI = new UserInterface(true);

        while (UI.keepGoing) {
                String user_input = IBIO.input();
                UI.requestCommand(user_input);
        }
    }

    public static void intro() {
        String username = IBIO.input("** Hello, what is you're name?\n");
        String message = "** Welcome to the zoo " + username +
                ". (insert exposition)...";
        IBIO.output(message);
    }
}
