import ibio.*;

//Lists the commands and descriptions

public class HelpCommand extends CommandList {

    //Add constructor. Currently it will not work
    //src folder needed?

    public static void run_command() {
        IBIO.output("These are the available commands: ");

        for (int i = 0; i < CommandList.length; i = i + 1) {
            String command_info = String.format("%s -- %s",
                    this.command_name, this.command_description);
            IBIO.output(command_info);
        }
    }
}