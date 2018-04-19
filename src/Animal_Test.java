//This is for testing purposes so we can use animals
//By Brendan

public class Animal_Test {
    private int cost;
    private int maintenance;
    private int popularity;
    private String name;
    String species_name;

    public Animal_Test(int cost, int maintenance, int popularity, String species_name, String name) {
        this.cost = cost;
        this.maintenance = maintenance;
        this.popularity = popularity;
        this.name = name;
        this.species_name = species_name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getSpecies_name() {
        return species_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
