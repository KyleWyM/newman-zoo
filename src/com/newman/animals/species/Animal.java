package com.newman.animals.species;

public class Animal {
    String name;
    int price;
    int maintenance; // per day; including food price as well
    int reputation; //scale of 1-10; aka attention given
    int level; // 1-10;
    

    public Animal(String name, int price, int maintenance, int reputation, int level) {
        this.name = name;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;
        this.level = level;

       Animal zebra = new Animal("Zebra", 75, 35, 4);
       Animal ostrich = new Animal("Ostrich",75,35,6);
       Animal snake = new Animal("Snake",150,15, 5);
       Animal panda = new Animal("Panda", 450, 65, 8);
       Animal giraffe = new Animal("Giraffe", 300,35, 8);
       Animal flamingo = new Animal("Flamingo",25,15,4);
       Animal tiger = new Animal("Tiger",1500, 60,8);
       Animal lion = new Animal("Lion", 1500, 60, 10);
       Animal hippo = new Animal("Hippo",1500, 60,7);
       Animal orangutan = new Animal("Orangutan", 350,33,5);
       Animal elephant = new Animal("Elephant",1000,70,9);
       Animal kangaroo = new Animal("Kangaroo", 400, 20,9);
       Animal koala = new Animal ("Koala", 200,10, 8);
       Animal armadillo = new Animal("Armadillo",50, 5, 7);
       Animal okapi = new Animal("Okapi", 300, 15,8);
       Animal penguin = new  Animal("Penguin", 150,50,10);
       Animal camel = new Animal("Camel", 600,30,6);
       Animal dragon = new Animal("Dragon", 20000,500,10);






    }
}
