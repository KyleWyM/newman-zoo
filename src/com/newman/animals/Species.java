package com.newman.animals;

import com.newman.player.Player;
import com.newman.multiplayer.Client;

public class Species {
    //TODO: convert prices, maintenances, and reputations in terms of some base numbers (i.e. for flamingo)
    //This way the prices are relative to some set price so we need to only change the price of one animal
    //to affect all other animals

    public static String[] species_list = new String[] {
            "flamingo", "zebra", "kangaroo"
    };

    public static Animals addFlamingo(Client client, String name, int birthTime) {
        Animals flamingo = new Animals("Flamingo", name, 10, 1,
                5,300, birthTime, 0);

        //Attacks:
        Attack flap = new Attack("flap", 0.5, 20);
        flamingo.attacks.add(flap);
        Attack jump = new Attack("jump", 0.2, 100);
        flamingo.attacks.add(jump);

        return flamingo;
    }

    public static Animals addZebra(Client client, String name, int birthTime) {
        Animals zebra = new Animals("Zebra", name,75,1,
                4, 400, birthTime, 0);

        //Attacks:
        Attack flail = new Attack("flail", 0.5, 30);
        zebra.attacks.add(flail);
        Attack flop = new Attack("flop", 0.1, 200);
        zebra.attacks.add(flop);

        return zebra;
    }

    public static Animals addKangaroo(Client client, String name, int birthTime) {
        Animals kangaroo = new Animals("Kangaroo", name,100,35,
                4, 350, birthTime, 0);

        //Attacks:
        Attack jab = new Attack("jab", 0.5, 30);
        kangaroo.attacks.add(jab);
        Attack kick = new Attack("kick", 0.8, 200);
        kangaroo.attacks.add(kick);

        return kangaroo;
    }

    //TODO: Add the rest of the animals using the methods above as a model

//    Animals ostrich = new Animals("Ostrich", 500, 25,6);
//    Animals snake = new Animals("Snake", 150, 15,5);
//    Animals lion = new Animals("Lion", 1500,60, 9);
//    Animals monkey = new Animals("Monkey", 350, 33, 7);
//    Animals elephant = new Animals("Elelphant", 1000, 70, 8);
//    Animals tiger = new Animals("Tiger", 1500, 60, 8);
//    Animals hippo = new Animals("Hippo", 1500, 60, 7);
//    Animals panda = new Animals("Panda", 450, 65, 8);
//    Animals giraffe = new Animals("Giraffe", 300, 35, 8);

}
