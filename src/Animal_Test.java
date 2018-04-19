//This is for testing purposes so we can use animals
//By Brendan

public class Animal_Test {
    private int cost;
    private int maintenance;
    private int reputation;
    private String name;
    String species_name;

    public Animal_Test(int cost, int maintenance, int reputation, String species_name, String name) {
        this.cost = cost;
        this.maintenance = maintenance;
        this.reputation = reputation;
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

    public int getReputation() {
        return reputation;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
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
