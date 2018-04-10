import ibio.IBIO;

public class Complaints extends Values {
    public int reputationChange;
    public int moneyChange;
    String description;

    public Complaints(String name, String description, int reputationChange, int moneyChange) {
        super(name, description);
        this.reputationChange = reputationChange;
        this.moneyChange = moneyChange;
        this.description = description;

    }

    public String getDescription() {
        return description;
    }
}


// mathrandom() < 0.2