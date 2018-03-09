//This is for testing purposes so we can use animals
//By Brendan

public class Animal_Test {
    private int cost;
    private int maitenance;
    private int popularity;
    private String name;
    String species_name;

    public Animal_Test(int cost, int maitenance, int popularity, String species_name, String name) {
        this.cost = cost;
        this.maitenance = maitenance;
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

    public int getMaitenance() {
        return maitenance;
    }

    public void setMaitenance(int maitenance) {
        this.maitenance = maitenance;
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
