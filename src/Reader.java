//Used to optimize "Autocorrect"

import java.io.*;
import ibio.*;

public class Reader {
    public static void save_reader(String file_path, UserInterface UI) throws IOException {
        File save = new File(file_path);
        BufferedReader save_reader = new BufferedReader(new FileReader(save));

        String line;
        while ((line = save_reader.readLine()) != null) {
            String keyWord = getStringFromLine(line);
            switch (keyWord) {
                case "Name:":
                    String name = getName(line);
                    UI.name = name;
                    IBIO.output("Name: " + name);
                    break;
                case "TurnNumber:":
                    int turnNum = getNumberFromLine(line);
                    UI.turnNum = turnNum;
                    IBIO.output("Turn Number: " + turnNum);
                    break;
                case "Money:":
                    int money = getNumberFromLine(line);
                    UI.money = money;
                    IBIO.output("Money: " + money);
                    break;
                case "Reputation:":
                        int reputation = getNumberFromLine(line);
                        UI.reputation = reputation;
                    IBIO.output("Reputation: " + reputation);
                    break;
                default:
            }
        }
    }

    public static int getNumberFromLine(String line) {
        String dataString = "";
        for(int i = 0; i < 25; i++) {
            try {
                String tempString = "" + line.charAt(i);
                line.charAt(i);Integer.parseInt(tempString);
                //Tests to see if string is also an integer

                dataString += line.charAt(i);
            } catch (Exception e) {
            }
        }

        int dataNumber = 0;

        try {
            dataNumber = Integer.parseInt(dataString);
        } catch (Exception e) {
        }


        return dataNumber;
    }

    public static String getStringFromLine(String line) {
        char[] ch = new char[30];
        if (line.charAt(0) != ' ') {
            int i = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                if ((line.charAt(i)) == ':') {
                    keepGoing = false;

                    //To make sure that ch is not an empty array:
                    for (int k = i + 1; k < ch.length; k++) {
                        ch[k] = ' ';
                    }
                } else if (i >= 30) {
                    //if ':' not found, avoids infinite loop
                    keepGoing = false;
                }
                ch[i] = line.charAt(i);
                i++;
            }
        }

        String stringFound = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != ' ') {
                stringFound += ch[i];
            }
        }

        return stringFound;
    }

    public static String getName(String line) {
        boolean keepGoing = true;
        int i = 0;
        while (keepGoing) {
            if ((line.charAt(i)) == ':') {
                keepGoing = false;
            } else if (i >= 30) {
                //If ':' not found
                IBIO.output("Save file corrupted");
                IBIO.output("Name missing ':'");
                keepGoing = false;
            }
            i++;
        }

        String stringFound = "";
        for (; i < line.length(); i++) {
            if (line.charAt(i) != ' ') {
                stringFound += line.charAt(i);
            }
        }

        if (stringFound.equals("")) {
            IBIO.output("Player name not found in save.");
        }

        return stringFound;
    }
}