package com.newman.game;

public class Autocorrect {

        public static char[] alphabetArray = new char[] {'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '!'};


    public static int[] createStringVector(String input) {
        /* This method creates a "vector" from the string, where each letter in the string represents a "dimension."
         * Thus, the vector will have 26 components (one for each letter)
         * The aim of this is so that the distance formula can be applied to the vectors of two strings.
         * Then, the closest one will be guessed as a match
         */
        input = input.toLowerCase(); //All characters will be stored as lower case (see "alphabetArray"
        int[] stringVector = new int[26]; //TODO: This was 27, but I changed it two 27. See if it works. May need to fix

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            int letterValue = 0; //i.e. "a"
            boolean keepGoing = true;
            while (keepGoing) {
                if (ch == alphabetArray[letterValue]) {
                    stringVector[letterValue]++;
                    keepGoing = false;
                } else if (letterValue >= 26) {
                    keepGoing = false;
                } else letterValue++;
            }
        }

        return stringVector;
    }

    public static int[][] createListMatrix(String[] list) {
        /* This method takes in a "string vector" meaning a vector with 26 components,
         * where the components are the characters and the magnitudes of these components are the number
         * of times that character is repeated in the strings
         *
         * This simply takes a list of Strings and makes a matrix where the 1st index indicates the different strings in the list
         * And the second index refers to the characters in the "string vector" for the corresponding string.
         *
         * This is used so that an entire list of strings (such as list of animals), can be manipulated with ease.
         */
        int[][] listVectors = new int[list.length][26];

        for (int i = 0; i < list.length; i++) {
            listVectors[i] = createStringVector(list[i]);
        }

        return listVectors;
    }

    public static String findMatch(String input, String[] stringList) {
        /* This method takes a "string list" (an array of vectors where the dimensions are the characters
         * in the alphabet). It also takes in a string. It transforms the string into a "string vector."
         * Then the distance formula is applied between the string vector for the inputted string and each of the
         * string vectors in the "string list." Then, the index of the string in the "string list" with the smallest
         * distance is selected as the bestMatchIndex. Then, the method returns the corresponding best match string.
         */
        int[][] listVectors = createListMatrix(stringList);

        int[] inputVector = createStringVector(input);

        //Radial is the vector difference between the string vector for the input and the 'i-th'
        //string vector from the string list
        int radial[] = new int[27];
        double magnitude[] = new double[listVectors.length];
        //magnitude[] is used to store the magnitudes of each of the radial vectors
        int bestMatchIndex = 0;
        for (int i = 0; i < listVectors.length; i++) {
            for (int k = 0; k < inputVector.length; k++) {
                radial[k] = inputVector[k] - listVectors[i][k];
            }

            double dotProduct = 0; //This the dot product of the radial vector with itself
            //(e.g. it gives the equivalent of "x^2 + y^2 + z^2" in the distance formula,
            //but instead of x,y,z, its components are a,b,c,d...

            for (int k = 0; k < radial.length; k++) {
                dotProduct += radial[k] * radial[k]; //Calculates dot product
                magnitude[i] = Math.sqrt(dotProduct);
                //The square-root is then taken of the resulting dot product to give the magnitude of the
                //radial vector (the distance between the vector of the inputted string and the 'i-th' vector in the list)
                //This gives the magnitude of the distance between the "string vectors"
            }

            if (magnitude[i] < magnitude[bestMatchIndex]) {
                bestMatchIndex = i;
                //This goes through and finds the smallest magnitude from magnitude[i]
                //The corresponding index i is set as the bestMatchIndex
            }
        }

        return stringList[bestMatchIndex];
        //The method returns the corresponding best match from the "string list" to the inputted string
    }


    public static String findMatch(String input, String[][] stringMatrix) {

        //The command_list from is a 2D array or a matrix of strings.
        //This method makes use of polymorphism so that one can enter a
        //"string array." This method will select the command names without
        //the descriptions and input this new one-dimensional list (or vector)
        //into findMatch(String input, String[] stringList)

        String[] stringList = new String[stringMatrix.length];

        for (int i = 0; i < stringList.length; i++) {
            stringList[i] = stringMatrix[i][0];
            //The first 0th entry of the 2nd index (i.e. stringMatrix[x][0])
            //is used, because stringMatrix[x][1] is assumed to have the description.
            //e.g. stringMatrix[x][0] has the command names, and stringMatrix[x][1] has their descriptions
        }

        return findMatch(input, stringList);
        //Now that the 2D "string matrix" is a 1D "string list", this is simply inputted into the other findMatch() method
    }
}