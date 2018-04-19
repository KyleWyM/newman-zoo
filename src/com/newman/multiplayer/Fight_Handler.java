package com.newman.multiplayer;

public class Fight_Handler {
    public static Client client1;
    public static Client client2;
    public static int client1_animal;
    public static int client2_animal;
    public static boolean client1_hasResponded;
    public static boolean client2_hasResponded;

    public static void battle(Client clientA, Client clientB, int bet) {

        client1_animal = 0;
        client2_animal = 0;
        client1_hasResponded = false;
        client2_hasResponded = false;
        client1 = clientA;
        client2 = clientB;

//        client1.listeningOn = false;
//        client2.listeningOn = false;
        Multiplayer_Manager.broadcast(client1.getUsername() + " is now fighting " + client2.getUsername() + ".");

        boolean turn_client1 = false; //Client 2 goes first
        boolean continue_battle = true;

        client1_selector selector1 = new client1_selector();
        client2_selector selector2 = new client2_selector();
        selector1.start();
        selector2.start();

        while(!(client2_hasResponded && client1_hasResponded)) {
            //Wait for both responses before continuing
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }

        String msg = "\n\tThe battle will now begin.\n";
        client2.println(msg);
        client1.println(msg);

        System.out.println("Turn client1 " + turn_client1); //todo

        while (continue_battle) {
            System.out.println("in while loop"); //todo
            if (client1.player.myAnimals.get(client1_animal).health <= 0 && client2.player.myAnimals.get(client2_animal).health <= 0) {
                client2.player.myAnimals.get(client2_animal).health = 0;
                client1.player.myAnimals.get(client1_animal).health = 0;
                msg = "It's a tie";
                client2.println(msg);
                client1.println(msg);
                client2.acceptFight = false;
//                client1.listeningOn = true;
                break;
            } else if (client1.player.myAnimals.get(client1_animal).health <= 0) {
                client1.player.myAnimals.get(client1_animal).health = 0;
                victoryMessage(client2, client1, bet);
                client2.acceptFight = false;
//                client1.listeningOn = true;
                break;
            } else if (client2.player.myAnimals.get(client2_animal).health <= 0) {
                client2.player.myAnimals.get(client2_animal).health = 0;
                victoryMessage(client2, client1, bet);
                client2.acceptFight = false;
//                client1.listeningOn = true;
                break;
            } else if (!client2.isConnected || !client2.isConnected) {
                Multiplayer_Manager.broadcast("A connection error has ended the fight.");
            }

            System.out.println("here");

            if (turn_client1) {
                msg = "\n\tIt is now " + client1.getUsername() + "'s turn.";
                System.out.println(msg);
                client1.println(msg);
                client2.println(msg);

                attack(client1, client2, client1_animal, client2_animal);
                turn_client1 = false;
            } else {
                msg = "\n\tIt is now " + client2.getUsername() + "'s turn.";
                client2.println(msg);
                client1.println(msg);
                System.out.println(msg);
                attack(client2, client1, client2_animal, client1_animal);
                turn_client1 = true;
            }
        }
    }

    private static void attack(Client attacker, Client target, int attackAnimal, int targetAnimal) {
        System.out.println("in attack"); //todo
        attacker.println("\nChoose the number of the attack you would like to use: ");
        int attack_index;

        attacker.println("\nnm\tAvailable attacks: ");
        for (int i = 0; i < attacker.player.myAnimals.get(attackAnimal).attacks.size(); i++) {

            String msg = String.format("%2d. %-20s",
                    i + 1, attacker.player.myAnimals.get(attackAnimal).attacks.get(i).attackName);
            attacker.println(msg);
        }

        while (true) {
            try {
                attack_index = Integer.parseInt(attacker.readLine()) - 1;
                if (attack_index < attacker.player.myAnimals.get(attackAnimal).attacks.size()) {
                    break;
                } else {
                    attacker.println("Attack number not recognized.");
                }
            } catch (Exception e) {
                attacker.println("Attack not selected.");
            }
        }

        Attack attack = attacker.player.myAnimals.get(attackAnimal).attacks.get(attack_index);

        attack.attackAnimal(attacker.player.myAnimals.get(attackAnimal), target.player.myAnimals.get(targetAnimal),
                attacker, target);
    }

    public static void victoryMessage(Client winner, Client loser, int bet) {
        String msg;
        msg = winner.getUsername() + " has won.";
        Multiplayer_Manager.broadcast(msg);
        msg = winner.getUsername() + " has received $" + bet + ".";
        Multiplayer_Manager.broadcast(msg);
        msg = winner.getUsername() + "now has $" + winner.player.getMoney() + ".";
        Multiplayer_Manager.broadcast(msg);
        msg = loser.getUsername() + "now has $" + loser.player.getMoney() + ".";
        Multiplayer_Manager.broadcast(msg);

        //Gives the winner their earnings
        int money = winner.player.getMoney();
        money += bet;
        winner.player.setMoney(money);

        //Takes money from the loser
        money = winner.player.getMoney();
        money -= bet;
        winner.player.setMoney(money);
    }

    public static void startBattle(int client_index) {
        Client client1 = Multiplayer_Manager.clients.get(client_index);
//        client1.listeningOn = false;
        String msg;

        client1.println("Enter the number of the player you want to fight");

        for (int i = 0; i < Multiplayer_Manager.clients.size(); i = i + 1) {
            Client temp_client = Multiplayer_Manager.clients.get(i);
            if (client_index != i && !temp_client.acceptFight && temp_client.isConnected) {
                msg = String.format("%2d. %-20s",
                        i + 1, temp_client.getUsername());
                client1.println(msg);
            }
        }

        int client2_index;
        int bet;
        try {
            client2_index = Integer.parseInt(client1.readLine()) - 1;
            int numberOfClients = Multiplayer_Manager.clients.size();

            Client client2 = Multiplayer_Manager.clients.get(client2_index);
            String client1_username = client1.getUsername();

            if ((client2_index < numberOfClients) && (client2_index != client_index)
                    && !client2.acceptFight && client2.isConnected) {

                client1.println("How much do you want to fight for?");
                while (true) {
                    try {
                        bet = Integer.parseInt(client1.readLine());
                        if (bet > 0 && bet < client1.player.getMoney() && bet < client2.player.getMoney()) {
                            client1.println("Bet set at $" + bet + ".");
                            break;
                        } else client1.println("That is too much. Enter a valid amount.");
                    } catch (Exception e) {
                        client1.println("Please enter a valid amount.");
                    }
                }

                client2.println(client1_username + " would liked to fight.");
                client2.println("Accept the fight for $" + bet + "?");
                client2.println("Type '/accept' in the next 30 seconds if you want to fight.");
                client2.queuedForFight = true;
                int startTime = GameLoop.globalTime;

                while ((GameLoop.globalTime - startTime) < 30) {
                    if (client2.acceptFight) {
                        client1.println(client2.getUsername() + " has accepted.");
                        client2.queuedForFight = false;
                        break;
                    } else if ((GameLoop.globalTime - startTime) == 20) {
                        client2.println("You have 10 seconds left to choose whether to accept or not...");
                    }

                    Thread.sleep(500);
                }

                if (client2.acceptFight) {
                    Fight_Handler.battle(client1, client2, bet);
                } else {
                    client1.println("The fight has not been accepted within the given time.");
                }
            } else {
                client1.println("Player not available.");
            }
        } catch (Exception e) {
            client1.println("Player not available.");
        }
//        client1.listeningOn = true;
    }
}

class client1_selector extends Thread {
    public void run() {
        Fight_Handler.client1.println("Please select the number of the first animal you will fight with: ");
        ManageAnimals.my_animals(Fight_Handler.client1);

        int animal_index;

        while (true) {
            try {
                animal_index = Integer.parseInt(Fight_Handler.client1.readLine()) - 1;
                if (animal_index < Fight_Handler.client1.player.myAnimals.size()) {
                    Fight_Handler.client1_animal = animal_index;
                    Fight_Handler.client1_hasResponded = true;
                    break;
                } else {
                    Fight_Handler.client1.println("Animal number not recognized.");
                }
            } catch (Exception e) {
                Fight_Handler.client1.println("Animal not selected.");
            }
        }
    }
}

class client2_selector extends Thread {
    public void run() {
        Fight_Handler.client2.println("Please select the number of the first animal you will fight with: ");
        ManageAnimals.my_animals(Fight_Handler.client2);

        int animal_index;

        while (true) {
            try {
                animal_index = Integer.parseInt(Fight_Handler.client2.readLine()) - 1;
                if (animal_index < Fight_Handler.client2.player.myAnimals.size()) {
                    Fight_Handler.client2_animal = animal_index;
                    Fight_Handler.client2_hasResponded = true;
                    break;
                } else {
                    Fight_Handler.client2.println("Animal number not recognized.");
                }
            } catch (Exception e) {
                Fight_Handler.client2.println("Animal not selected.");
            }
        }
    }
}