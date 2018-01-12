import ibio.*;

//This is a file to play with the idea of commands.
//Basically, the user an type "/" and then a command.
//We don't necesarrily have to use this,
//but if it is easier we can easily add no commands.
//In addition, the user can choose the order of actions.

public class CommandList {
    String command_name;
    String command_description;

    public CommandList(String command_name, String command_description) {
        this.command_name = command_name;
        this.command_description = command_description;
    }
}