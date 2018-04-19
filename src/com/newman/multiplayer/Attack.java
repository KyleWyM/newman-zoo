package com.newman.multiplayer;

import com.newman.animals.Animals;
import com.newman.multiplayer.Client;

public class Attack {
    public double probability_coefficient;
    //A number between 0 and 1 that governs the likeliness that the attack will deal full damage
    public String attackName;
    public double maxEffectiveness; //The maximum amount of damage that can be done.

    public Attack(String attackName, double probability_coefficient, double maxEffectiveness) {
        this.probability_coefficient = probability_coefficient;
        this.attackName = attackName;
        this.maxEffectiveness = maxEffectiveness;
    }

    public void attackAnimal(Animals attacker, Animals target, Client client1, Client client2) {
        int damage = Math.min((int) (Math.random() * probability_coefficient * 100), (int) maxEffectiveness);
        target.health -= damage;
        String msg = attacker.species + " " + attacker.name + " has used " + attackName;
        client1.println(msg);
        client2.println(msg);
        msg = target.species + " " + target.name + " now has " + target.health + " health.";
        client1.println(msg);
        client2.println(msg);
    }
}
