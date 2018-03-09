public class Autocorrect {

    public static String[] command_vector_list = new String[]{
            "help", "buy", "report", "animals", "list", "next", "quit"
//            {"cancel", "cancels the action you are in"} TODO
    }; //TODO : this code is repeated in UserInterface. Find a way to reduce to one copy




    public static char[] alphabetArray = new char[] {'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '!'};


    public static int[] createStringVector(String input) {
        input = input.toLowerCase();
        int[] stringVector = new int[27];

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            int letterValue = 0; //i.e. "a"
            boolean keepGoing = true;
            while (keepGoing) {
                if (ch == alphabetArray[letterValue]) {
                    stringVector[letterValue]++;
                    keepGoing = false;
                } else if (letterValue == 26) {
                    keepGoing = false;
                } else letterValue++;
            }
        }

        stringVector[26] = 0;
        return stringVector;
    }

    public static int[][] createListVectors(String[] list) {
        int[][] listVectors = new int[list.length][26];

        for (int i = 0; i < list.length; i++) {
            listVectors[i] = createStringVector(list[i]);
        }

        return listVectors;
    }

    public static int findMatch(String input, int[][] listVectors) {
        int[] inputVector = createStringVector(input);

        int radial[] = new int[27];
        double magnitude[] = new double[listVectors.length];
        int bestMatchIndex = 0;
        for (int i = 0; i < listVectors.length; i++) {
            for (int k = 0; k < inputVector.length; k++) {
                radial[k] = inputVector[k] - listVectors[i][k];
            }

            double sum = 0;

            for (int k = 0; k < radial.length; k++) {
                sum += radial[k] * radial[k];
                magnitude[i] = Math.sqrt(sum);
            }

            if (magnitude[i] < magnitude[bestMatchIndex]) {
                bestMatchIndex = i;
            }
        }

        return bestMatchIndex;
    }
}