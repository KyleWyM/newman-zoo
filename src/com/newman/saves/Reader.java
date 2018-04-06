package com.newman.saves;//Used to optimize "Autocorrect"

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.newman.animals.*;
import com.newman.player.PlayerStats;
import ibio.*;

public class Reader {

    public static void save_reader(String file_path) throws IOException {
        File save = new File(file_path);
        BufferedReader save_reader = new BufferedReader(new FileReader(save));

        String line;
        while ((line = save_reader.readLine()) != null) {
            String keyWord = getStringFromLine(line);
            switch (keyWord) {
                case "Name:":
                    String name = getName(line);
                    PlayerStats.name = name;
                    IBIO.output("Name: " + name);
                    break;
                case "TurnNumber:":
                    int turnNum = getNumberFromLine(line);
                    PlayerStats.turnNum = turnNum;
                    IBIO.output("Turn Number: " + turnNum);
                    break;
                case "Money:":
                    int money = getNumberFromLine(line);
                    PlayerStats.money = money;
                    IBIO.output("Money: " + money);
                    break;
                case "Reputation:":
                    int reputation = getNumberFromLine(line);
                    PlayerStats.reputation = reputation;
                    IBIO.output("Reputation: " + reputation);
                    break;
                case "Animals:":
                    List<Animals> animals = new ArrayList<>();
                    getAnimalsFromLine(line);
            }
        }
    }

    private static int getNumberFromLine(String line) {
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

    private static String getStringFromLine(String line) {
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

    private static String getName(String line) {
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

    private static void getAnimalsFromLine(String line) {

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
                addAnimal(species_name, name);

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
    }

    private static void addAnimal(String species_name, String name) {
        Animals animal = null;
        switch (species_name.toLowerCase()) {
            case "flamingo":
                Species.addFlamingo(name);
                IBIO.output("Flamingo " + name + " loaded.");
                break;
            case "kangaroo":
                Species.addKangaroo(name);
                IBIO.output("Kangaroo " + name + " loaded.");
                break;
            case "zebra":
                Species.addZebra(name);
                IBIO.output("Zebra " + name + " loaded.");
                break;
            default:
                IBIO.output("Error, animal in save file not found.");
                IBIO.output("Apparent species name: " + species_name);
        }
    }
}