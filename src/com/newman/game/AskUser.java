package com.newman.game;

import ibio.*;

public class AskUser {
    //Over and over in the code there was a need to ask the user similar questions
    //For example, a "yes or no" question.
    //This class is for convenient methods that allow the code to be neater and easier.

    public static boolean yesOrNo() {
        boolean ResponseIsYes = false;
        boolean userHasAnswered = false;


        String message = "Please respond with 'yes' or 'no.' (y/n)";
        String user_response;
        while(!userHasAnswered) {
            user_response = IBIO.input(message).toLowerCase();

            switch (user_response) {
                case "yes":
                case "y":
                    userHasAnswered = true;
                    ResponseIsYes = true;
                    break;
                case "no":
                case "n":
                    userHasAnswered = true;
                    break;
                default:
                    IBIO.output("Response not recognized.");
            }
        }

        return ResponseIsYes;
    }
}
