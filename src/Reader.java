//Used to optimize "Autocorrect"

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
                case "Animals:":
                    List<Animal_Test> animals = new ArrayList<>();
                    animals = getAnimalsFromLine(line);
                    UI.animals= animals;
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

    public static List<Animal_Test> getAnimalsFromLine(String line) {
        List<Animal_Test> animals = new ArrayList<>();

        boolean keepGoing = true;
        int i = 0;
        while (keepGoing) {
            if ((line.charAt(i)) == ':') {
                keepGoing = false;
            } else if (i >= 30) {
                //If ':' not found
                IBIO.output("Save file corrupted.");
                IBIO.output("Name missing ':'");
                keepGoing = false;
            }
            i++;
        }

        String species_name = "";
        String name = "";
        keepGoing = true;
        while (keepGoing) {
            if (line.charAt(i) == '[') {
                i++; //Moves char one past '['

                //Finding species name using '[' and ',' to mark beginning and end.
                while (line.charAt(i) != ',') {
                    species_name += line.charAt(i);
                    i++;
                }

                i++; //Moves char one past ','

                while (line.charAt(i) != ']') {
                    name += line.charAt(i);
                    if (line.charAt(i) != ']') i++;
                }
                animals.add(addAnimal(species_name, name));

                //Reset names for next animal saved on list
                species_name = "";
                name = "";
            }

            i++;

            if (line.charAt(i) == '&') {
                keepGoing = false;
            } else if (i >= 1000) {
                keepGoing = false;
            }
        }
        return animals;
    }

    public static Animal_Test addAnimal(String species_name, String name) {
        Animal_Test animal = null;
        switch (species_name) {
            case "Kangaroo":
                animal = new Kangaroo(name);
                IBIO.output("Kangaroo " + name + " loaded.");
                break;
            case "Zebra":
                animal = new Zebra(name);
                IBIO.output("Zebra " + name + " loaded.");
                break;
            default:
                IBIO.output("Error, animal in save file not found.");
                IBIO.output("Apparent species name: " + species_name);
        }
        return animal;
    }
}