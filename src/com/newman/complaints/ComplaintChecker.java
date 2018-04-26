package com.newman.complaints;

import com.newman.player.PlayerStats;
import ibio.IBIO;

import java.util.ArrayList;

public class ComplaintChecker {
    private static ArrayList<String> complaints = new ArrayList<>();

    public static void listComplaints() {
        IBIO.output("Complaints:\n");
        for (int i = 0; i < complaints.size(); i++) {
            String message = String.format( "%2d. %-20s",
                    i + 1, complaints.get(i));
            IBIO.output(message + "\n");
        }
    }

    public static void update() {
        complaints = new ArrayList<>();
        Booleans.update_variables();

        String complaint;
        //Animal related complaints:
        if (Booleans.too_many_mammals) {
            PlayerStats.reputation--;
            complaint = "You are losing reputation because you have to many mammals! Get more diversity!";
            complaints.add(complaint);
        }
        if (Booleans.too_few_reptiles) {
            complaint = "You have too few reptiles. Get more to get the reptile bonus.";
            complaints.add(complaint);
        }
        if (Booleans.too_few_birds) {
            complaint = "You're losing money because there aren't a lot of birds so there's environmental " +
                    "\ntrouble or something. Basically, get more birds...";
            PlayerStats.money--;
            complaints.add(complaint);
        }
        if (Booleans.too_many_animals_too_fast) {
            complaint = "You're buying animals very fast! You get a bonus equal to " + PlayerStats.myAnimals.size() + "!";
            PlayerStats.money += PlayerStats.myAnimals.size();
            complaints.add(complaint);
        }
        if (Booleans.avian_bonus) {
            complaint = "You have the avian bonus because of your bird collection! " +
                    "\nGet a bonus of money equal to 5 for every bird you have!";
            PlayerStats.money += Booleans.num_birds * 5;
            PlayerStats.reputation += 10;
            complaints.add(complaint);
        }
        if (Booleans.reptile_bonus) {
            complaint = "You have the reptile bonus because of your reptile collection! " +
                    "\nGet a bonus of money equal to 15 for every reptile you have!";
            PlayerStats.money += Booleans.num_reptiles * 15;
            complaints.add(complaint);
        }
        if (Booleans.mammal_bonus) {
            complaint = "You have the mammalian bonus because of your mammal collection! " +
                    "\nGet a bonus of money equal to 100 per turn!";
            PlayerStats.money += 25;
            complaints.add(complaint);
        }
        if (Booleans.too_many_of_one_animal) {
            complaint = "People think your a fraud because you are ripping people off by " +
                    "\nshowing the same type of animal over and over. People are protesting" +
                    "\nagainst you in the thousands and maybe even hundreds of thousands." +
                    "\nYou lose 1 reputation each turn!!!!";
            PlayerStats.money--;
            complaints.add(complaint);
        }
        if (Booleans.too_many_carnivores) {
            complaint = "You have too many carnivores. It's too much. Pay 3 bucks.";
            PlayerStats.money -= 3;
            PlayerStats.reputation--;
            complaints.add(complaint);
        }
        if (Booleans.owner_is_rich) {
            int bonus = (int) ((double) PlayerStats.money * 0.1);
            complaint = "You are rolling in cash! Get a bonus of " + Math.max(bonus, 100) + " this turn! But you will lose reputation.";
            PlayerStats.money += Math.min(bonus, 100);
            PlayerStats.reputation -= 9;
            complaints.add(complaint);
        }
        if (Booleans.ticket_prices_fluctuating) {
            complaint = "Your ticket prices are fluctuating, so you will lose 5 reputation.";
            PlayerStats.reputation -= 5;
            complaints.add(complaint);
        }
        if (Booleans.reputation_dropping) {
            complaint = "Your reputation is dropping! It's building momentum and now you will lose " +
                    "\neven more reputation!";
            PlayerStats.reputation -= 5;
            complaints.add(complaint);
        }
        if (Booleans.too_crowded) {
            complaint = "Your zoo is two crowded. One guy even fell in the " + PlayerStats.myAnimals.get(0).getClass().getSimpleName() + " " +
                    "\nexhibit. Lose $5 and 1 reputation until your zoo is no longer crowded.";
            PlayerStats.reputation--;
            PlayerStats.money -= 15;
            complaints.add(complaint);
        }
        if (Booleans.too_sparse) {
            complaint = "Get more animals!";
            complaints.add(complaint);
        }
        if (Booleans.increasing_popularity) {
            complaint = "Your growing in popularity! Get 15 reputation and $100!";
            PlayerStats.money += 100;
            PlayerStats.reputation += 15;
            complaints.add(complaint);
        }
    }
}
