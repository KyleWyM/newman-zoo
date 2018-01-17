import ibio.*;

//This is a file to play with the idea of commands.
//Basically, the user an type "/" and then a command.
//We don't necesarrily have to use this,
//but if it is easier we can easily add no commands.
//In addition, the user can choose the order of actions.

public class Commands {
    public static void WaitForCommand() {
        String user_input;
        user_input = IBIO.input("-> ");

        if (user_input.charAt(0) == "/") //Haven't test if this works.
            //If you type "/..." it should realize that you said "/"
            //If not, try the .equals() method
            //Can't test it for some reason. Java issue?
        {
//            for (i = 0; )

        }

    }

}