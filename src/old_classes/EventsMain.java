package old_classes;

import ibio.*;


public class EventsMain {
    public static int employees = 1;
    public static int visitors = 1;
    public static int animals = 1;
    public static int janitors = 1;
    public static int IQTotalofallanimals = 1;
    public static int restaurantemployees = 1;
    public static int getRestaurantemployees = 1;
    public static int zoolevel = 1;
    public static int ticketprice = 1;
    public static int numberofjanitors = 5;
    public static int animalamount = 100;
    static Complaints longLines = new Complaints("Long lines", "The lines are too long, get some more employees!", -150, 0);
    static Complaints cleancomplaint = new Complaints("Clean Complain", "The zoo is not clean, get some more janitors!", -100, 0);
    static Complaints boring = new Complaints("Boring Animals", "The animals are boring to visits, teach them new tricks", -500, 0);
    static Complaints ticketscosttoomuch = new Complaints ("Ticket Price", "The tickets cost too much at the zoo and the visitors don't feel like they are getting the price they put in back",
            -2000, 0);
    static Complaints  badfood = new Complaints("Bad Food", "The food at the restaurants taste bad get more restaurant employees",
    -750, 0);
    static Complaints zooistoosmall = new Complaints("Upgrade Zoo", "Upgrade your zoo so it is bigger and can attract more visitors", -0, -0);


    public static void main(String[] args) {
        for (int day = 0; day <= 100; day = day + 1) {
            if (employees * 10 < visitors)
            {
                IBIO.output(longLines.getDescription());
            }
            if (animals/janitors > 10)
            {
                IBIO.output(cleancomplaint.getDescription());
            }
            if (IQTotalofallanimals *100 < visitors)
            {
                IBIO.output(boring.getDescription());
            }
            if ((restaurantemployees*10) < visitors)
            {
                IBIO.output(ticketscosttoomuch.getDescription());
            }
            if ((restaurantemployees*10) < visitors)
            {
                IBIO.output(badfood.getDescription());
            }
            if ((zoolevel * 1000) < visitors)
            {
                IBIO.output(zooistoosmall.getDescription());
            }
        }
    }
}




/* make array of instances, run through instance and
check if animal (string names int price, cause is true)
make a list of all current complaints*/
