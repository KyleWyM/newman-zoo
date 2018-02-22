public class Animals {
    String name;
    int price;
    int maintenance; //including the price to feed and the price to clean
    int reputation;  //on a scale of one to ten how popular the animal is

    public Animals(String name, int price, int maintenance, int reputation) {
        this.name = name;
        this.price = price;
        this.maintenance = maintenance;
        this.reputation = reputation;

        Animals zebra = new Animals("Zebra",75,35,4);
        Animals ostrich = new Animals("Ostrich", 500, 25,6);
        Animals snake = new Animals("Snake", 150, 15,5);
        Animals lion = new Animals("Lion", 1500,60, 9);
        Animals monkey = new Animals("Monkey", 350, 33, 7);
        Animals elephant = new Animals("Elelphant", 1000, 70, 8);
        Animals flamingo = new Animals("Flamingo", 25, 15, 4);
        Animals tiger = new Animals("Tiger", 1500, 60, 8);
        Animals hippo = new Animals("Hippo", 1500, 60, 7);
        Animals panda = new Animals("Panda", 450, 65, 8);
        Animals giraffe = new Animals("Giraffe", 300, 35, 8);
        

    }
}

