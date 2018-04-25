package com.newman.game;

import com.newman.player.PlayerStats;
import ibio.*;

public class Random_Events {
    int reputation_change;
    int money_change;
    String description;
    String special_event;
    int min;
    int max;

    public Random_Events(String description, int min, int max, int reputation_change, int money_change, String special_event) {
        this.description = description;
        this.min = min;
        this.max = max;
        this.reputation_change = reputation_change;
        this.money_change = money_change;
        this.special_event = special_event;
    }


    static Random_Events donation = new Random_Events("A rich animal enthusiast loves your zoo " +
            "and decided to make a donation! Your zoo has been granted 1000$!", -1, 20,
            0, 1000, null);
    static Random_Events earthquake = new Random_Events("Oh no! There was an earthquake at your zoo! " +
            "You had to pay 500$ to fix the damages!", 20, 30, 0,
            -500, null);
    static Random_Events pass_go = new Random_Events("You passed go! Collect 200$!", 30, 50,
            0, 200, null);
    static Random_Events[] random_events_list = new Random_Events[] {
            donation, earthquake, pass_go
    };

    public static void check_random_events() {
        int number = (int )(Math.random() * 1000);
        for (int i = 0; i < random_events_list.length; i++) {
                if (random_events_list[i].min < number && number <= random_events_list[i].max) {
                IBIO.output(random_events_list[i].description);
                PlayerStats.money += random_events_list[i].money_change;
                PlayerStats.reputation += random_events_list[i].reputation_change;
            }
        }
    }
}
