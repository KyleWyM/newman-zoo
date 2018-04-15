package com.newman.saves;

import java.io.*;

import com.newman.animals.*;
import com.newman.game.RealTime_GameLoop;
import com.newman.player.PlayerStats;
import com.newman.game.MainSinglePlayer;

import ibio.*;

public class Reader {

    public static void save_reader(String file_path) throws IOException {
        File save = new File(file_path);
        BufferedReader save_reader = new BufferedReader(new FileReader(save));

        String line;
        while ((line = save_reader.readLine()) != null) {
            String keyWord = getSaveType(line);
            switch (keyWord) {
                case "Name:":
                    String name = getStringLists(line, 1)[0][0];
                    //The method getStringLists() returns a string list.
                    //But name is only one variable, so it takes the [0][0] entry
                    PlayerStats.name = name;
                    IBIO.output("Name: " + name);
                    break;
                case "TurnNumber:":
                    int turnNum = getNumberFromLine(line);
                    PlayerStats.dayNum = turnNum;
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
//                    List<Animals> animals = new ArrayList<>();
                    int numAnimalsVars = 6;
                    String[][] animal_data = getStringLists(line, numAnimalsVars);

                    /* The following for loop goes through the list just recovered from the text
                     * (i.e. animal_data). 0 of the second index is species, 1 is name,
                     * and more variables can be added. The first on the other hand just indicates
                     * the number of the specific animal (e.g. each number refers to a particular saved
                     * animal).
                     *
                     * If the entry is null, the end of the list has been reached.
                     * This is because the length of the list is much longer than it needs to be,
                     * so there are many empty slots.
                     */
                    for (int i = 0; i < animal_data.length; i++) {
                        if (animal_data[i][0] != null) {

                            String species = animal_data[i][0];
                            String animal_name = animal_data[i][1];
                            int maintenance = getNumberFromLine(animal_data[i][2]);
                            int animal_reputation = getNumberFromLine(animal_data[i][3]);
                            int birthTime = getNumberFromLine(animal_data[i][4]);
                            int level = getNumberFromLine(animal_data[i][5]);

                            addAnimal(species, animal_name, maintenance, animal_reputation,
                                     birthTime, level);

                        } else i = animal_data.length;
                    }
                    break;
                case "GameMode:":
                    //2 variables. 1st is the boolean Main.inRealTime, and the second is global time or turnNum respectively
                    String[][] gameModeData = getStringLists(line, 2);
                    //1 is true, 0 is false. If true, inRealTime activated.
                    boolean inRealTime = false;
                    if(getNumberFromLine(gameModeData[0][0]) == 1) inRealTime = true;

                    if (inRealTime) {
                        IBIO.output("Game mode: real time");
                        MainSinglePlayer.inRealTime = true;
                        RealTime_GameLoop.globalTime = getNumberFromLine(gameModeData[0][1]); //Sets the global time
                        PlayerStats.dayNum = (int) (RealTime_GameLoop.globalTime - RealTime_GameLoop.globalTime % 60) / 60;
                    } else {
                        IBIO.output("Game mode: turn based");
                        MainSinglePlayer.inRealTime = false;
                        PlayerStats.dayNum = getNumberFromLine(gameModeData[0][1]); //Sets the global time
                    }
            }
        }
    }

    private static int getNumberFromLine(String line) {
        String dataString = "";
        for(int i = 0; i < 40; i++) {
            try {
                String tempString = "" + line.charAt(i);
                line.charAt(i);
                Integer.parseInt(tempString);
                //Tests to see if string is also an integer

                dataString += line.charAt(i);
            } catch (Exception e) {
                //If the string is not an integer, this will catch it. Nothing to worry about
            }
        }

        int dataNumber = 0;

        try {
            dataNumber = Integer.parseInt(dataString);
        } catch (Exception e) {
        }


        return dataNumber;
    }

    private static String getSaveType (String line) {
        //This method gets the save type coming before the ':'
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

    private static String[][] getStringLists(String line, int numVariables_saved) {
        String[][] itemList = new String[1000][numVariables_saved];
        int itemList_index1 = 0; //This is the specific object in itemList. E.g. it could be specific animal
        int itemList_index2 = 0; //Index 2 refers to all the variables, e.g. species name and animal name

        boolean keepGoing = true;
        int i = 0; //i is the character index of the line
        /* The following loop goes through the line, char by char (i.e. 'i'),
         * until it gets to ':'. This is because ':' indicates where data type identifier ends
         * and the following list of data begins.
         */
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


        String item; //item refers to the string that will be identified from save text
        keepGoing = true;

        while (keepGoing) {
            try {
                if (line.charAt(i) == '[') {
                    item = ""; //Item must start at "" because then characters can be added to it with '+'
                    //'[' indicates the beginning of an item with all its variables kept between '[]'
                    i++; //Moves char index 'i' one past '['

                    //Finding variable string using ',' to mark the end of each individual variable
                    //Next, the next variable is searched for, looping until all except the last variable has
                    //been selected. The last one is not included, because it does not end with ',' but with
                    //']'. Hence, why the for loop goes until 'numVariables_saved - 1'
                    for (int q = 0; q < numVariables_saved - 1; q++) {
                        itemList_index2 = q; //Tells which variable index it goes in. E.g. begins at [index1][0]
                        while (line.charAt(i) != ',') {
                            //This goes char by char from the initial value of 'i' when the loop is started
                            //to ','. It adds each character to the string item.
                            item += line.charAt(i);
                            i++;
                        }
                        //Hence, once the string is found, it is added to itemList:
                        itemList[itemList_index1][itemList_index2] = item;
                        item = ""; //This sets the item blank so that the variable can be reused to find the next item
                        i++; //Moves char one past ',' for the next item to be searched for (if any)

                        itemList_index2++; //Increases index2 so that the last item can be added for the specific object
                        //If this is not the end of the while(), then itemList_index2 is set to q at the start of the loop
                        //If this is outside the if(), then there are issues when only 1 variable is present due to 'out of range'
                    }

                    //Finally, the last variable in the list for the specific itemList[i][x] / object
                    //It goes until ']' which indicates the end of the specific object
                    while (line.charAt(i) != ']') {
                        item += line.charAt(i);
                        if (line.charAt(i) != ']') i++;
                    }

                    itemList[itemList_index1][itemList_index2] = item; //This adds the last item to itemList[][]

                    itemList_index2 = 0; //Sets index2 to 0 to reset it for the next specific object
                    itemList_index1++; //Increases index1 to set it to the index of the subsequent object
                }

                if (line.charAt(i) == '&') { //'&' indicates the end of a line. This will terminate the loop.
                    keepGoing = false;
                } else if (i == line.length()) {
                    keepGoing = false; //If '&' is not found, the loop will stop after 1000 characters searched
                }

                if (itemList_index1 >= 999) {
                    IBIO.output("Max number of entries reached (1000)");
                    keepGoing = false;
                    //Because the amount of entries that a list will have is not known,
                    //it was set to 1000 to be save. Still, just in case, this is in place
                    //so as to ensure not 'out or range' errors crash the program.
                }
                i++;
            } catch (Exception e) {
                //If there is no '&', the program can run into the issue of going beyond the bounds of 'line'
                //This has also been accounted for by restricting the scan of the line to within bounds of its index
                keepGoing = false;
                IBIO.output("\nFailure to read save file.");
                IBIO.output("Possible failure due to missing '&&&' in save file to terminate line.\n");

                e.printStackTrace();
            }
        }

        return itemList;
    }

    private static void addAnimal(String species_name, String name, int maintenance,
                                  int reputation, int birthTime, int level) {
        switch (species_name.toLowerCase()) {
            case "flamingo":
                //myArrayList.get(myArrayList.size()-1)
                Species_SinglePlayer.addFlamingo(name, birthTime);
                IBIO.output("Flamingo " + name + " loaded.");

                //Now, flamingo is the last one in. The following line of code
                //sets the variables of the last animal added to myAnimals:

                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).maintenance = maintenance;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).reputation = reputation;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).level = level;
                break;
            case "kangaroo":
                Species_SinglePlayer.addKangaroo(name, birthTime);
                IBIO.output("Kangaroo " + name + " loaded.");

                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).maintenance = maintenance;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).reputation = reputation;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).level = level;
                break;
            case "zebra":
                Species_SinglePlayer.addZebra(name, birthTime);
                IBIO.output("Zebra " + name + " loaded.");

                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).maintenance = maintenance;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).reputation = reputation;
                PlayerStats.myAnimals.get(PlayerStats.myAnimals.size() - 1).level = level;
                break;
            default:
                IBIO.output("Error, animal in save file not found.");
                IBIO.output("Apparent species name: " + species_name);
        }
    }
}