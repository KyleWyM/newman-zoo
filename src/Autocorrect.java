public class Autocorrect {

    public static String[] command_vector_list = new String[]{
            "help", "buy animal", "report", "animals", "list", "next", "quit"
//            {"cancel", "cancels the action you are in"} TODO
    }; //TODO : this code is repeated in UserInterface. Find a way to reduce to one copy




    public static char[] alphabetArray = new char[] {'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            ' ', '!'};


    //Transforms a string into a 26-dimensional vector where each component
    //is a letter, scaled by some number (specifically 1.7^(-i) where i indicates
    //what number letter it is in the string)
    public static double[] createStringVector(String input) {
        input = input.toLowerCase();
        double[] stringVector = new double[27];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            int letterValue = 0; //i.e. "a"
            boolean keepGoing = true;
            while (keepGoing) {
                if (ch == alphabetArray[letterValue]) {
                    stringVector[letterValue]++;
                    //By making each consecutive letter have less 'weight' with Math.pow(x, -i),
                    //the result is less inaccuracy do to some phrases being "too long"
                    keepGoing = false;
                } else if (letterValue == 27) {
                    keepGoing = false;
                } else letterValue++;
            }
        }

        return stringVector;
    }

    public static double[][] createListVectors(String[] list) {
        double[][] listVectors = new double[list.length][27];

        for (int i = 0; i < list.length; i++) {
            listVectors[i] = createStringVector(list[i]);
        }

        return listVectors;
    }

    public static int findMatch(String input, double[][] listVectors) {
        double[] inputVector = createStringVector(input);
        int bestMatchIndex = findMatch(inputVector, listVectors);
        return bestMatchIndex;
    }

    public static double dotProduct(double[] vector1, double[] vector2) {
        double sum = 0;
        if (vector1.length == vector2.length) {
            for (int i = 0; i < vector1.length; i++) {
                sum += vector1[i] * vector2[i];
            }
        }

        return sum;
    }

    public static double[][] findRadialVectors(double[] inputVector, double[][] listVectors) {
        double[][] radial = new double[listVectors.length][27];
        for (int i = 0; i < listVectors.length; i++) {
            for (int k = 0; k < inputVector.length; k++) {
                radial[i][k] = inputVector[k] - listVectors[i][k];
            }
        }
        return radial;
    }

    public static int findMatch(double[] inputVector, double[][] listVectors, double[] magnitudes) {
        int bestMatchIndex = 0;
        for (int i = 0; i < magnitudes.length; i++) {
            if (magnitudes[i] < magnitudes[bestMatchIndex]) {
                bestMatchIndex = i;
            }
        }

        return bestMatchIndex;
    }


    public static int findMatch(double[] inputVector, double[][] listVectors) {
        double[][] radialVectors = findRadialVectors(inputVector, listVectors);
        double magnitudes[] = findMagnitudes(listVectors, radialVectors);


        int bestMatchIndex = findMatch(inputVector, listVectors, magnitudes);

        return bestMatchIndex;
    }



    public static double[] findMagnitudes(double[][] listVectors, double[][] radialVectors) {
        double magnitudes[] = new double[listVectors.length];

        for (int i = 0; i < magnitudes.length; i++) {
            double length = Math.sqrt(dotProduct(radialVectors[i], radialVectors[i]));
            magnitudes[i] = length;
        }

        return magnitudes;
    }

//    public static boolean checkMatchExists(int bestMatchIndex, int secondBestMatchIndex, int[][] listVectors) {
//        boolean stringExists = true;
//
//        if (listVectorsmagnitude[bestMatchIndex])
//
//        return stringExists;
//    }

    public static double findMaxMagnitude(String[] list) {
        double[][] listVectors = createListVectors(list);
        int numberOfTests = 1000000;
        double[] magnitudes = new double[listVectors.length];
        double min = 0;
        double max = 4;
        double[] randomVector = new double[27];

        for (int i = 0; i < list.length; i++) {
            double magnitudeSum = 0;
            double numberOfMatches = 0;

            for (int k = 0; k < numberOfTests; k++) {
                for (int u = 0; u < 27; u++) {
                    randomVector[u] = min + (int) (Math.random() * ((max - min) + 1));
                }

                double[][] radialVectors = findRadialVectors(randomVector, listVectors);
                magnitudes = findMagnitudes(listVectors, radialVectors);

                int bestMatchIndex = findMatch(randomVector, listVectors);
                if (bestMatchIndex == i) {
                    numberOfMatches++;
                    magnitudeSum += magnitudes[bestMatchIndex];
                }
            }

            System.out.println(list[i] + ": " + magnitudeSum/numberOfMatches);
            //output command at i, along with sum/number of correct results (ie average)
        }
        //loop through commands in listVector
        //for each command:
        //Generate string random vector with random number of letters less than 4.
        // later create method to find out average number of letters when you enter random keys
        //Test each one to see if it matches the given command
        //if true, find distance between them.
        //sum up these distances and divide them by number of correct strings
        //print command string and average magnitude
        //this is the "max magnitude"
        //increase tests until max magnitude is approx constant

        return 0;
    }


    public static void main(String[] args) {
        findMaxMagnitude(command_vector_list);
    }
}
