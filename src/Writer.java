import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Writer {

    public static void eraseSave(String file_path) throws IOException {
        FileWriter file_writer = new FileWriter(file_path,false);
        PrintWriter print_writer = new PrintWriter(file_writer);
        print_writer.print("");
        print_writer.close();
    }

    public static void saveGame(String name, int turnNum, int money,
                         int reputation, String file_path) throws IOException {

        FileWriter file_writer = new FileWriter(file_path,true);
        PrintWriter print_writer = new PrintWriter(file_writer);
        print_writer.println("Name: " + name);
        print_writer.println("Turn Number: " + turnNum);
        print_writer.println("Money: " + money);
        print_writer.println("Reputation: " + reputation);
        print_writer.close();
    }
}
