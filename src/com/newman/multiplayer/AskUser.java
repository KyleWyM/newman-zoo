package com.newman.multiplayer;

import com.newman.multiplayer.Multiplayer_Manager;
import com.newman.multiplayer.Client;

import java.util.Scanner;

public class AskUser {
    //Over and over in the code there was a need to ask the user similar questions
    //For example, a "yes or no" question.
    //This class is for convenient methods that allow the code to be neater and easier.

    public static boolean yesOrNo(Client client) {
        boolean ResponseIsYes = false;
        boolean userHasAnswered = false;


        String msg = "(y/n)";
        client.println(msg);
        String user_response;
        while(!userHasAnswered) {
            user_response = client.readLine();
            System.out.println(user_response);

            switch (user_response.toLowerCase()) {
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
                    msg = "Response not recognized.";
                    client.println(msg);
                    userHasAnswered = true;
            }
        }

        return ResponseIsYes;
    }

    public static boolean yesOrNo(int client_index) {
        return yesOrNo(Multiplayer_Manager.clients.get(client_index));
    }

    public static boolean yesOrNo() {
        boolean ResponseIsYes = false;
        boolean userHasAnswered = false;
        Scanner sc = new Scanner(System.in);

        String msg = "(y/n)";
        System.out.println(msg);
        String user_response;
        while(!userHasAnswered) {
            user_response = sc.nextLine();

            switch (user_response.toLowerCase()) {
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
                    msg = "Response not recognized.";
                    System.out.println(msg);
                    userHasAnswered = true;
            }
        }

        return ResponseIsYes;
    }
}