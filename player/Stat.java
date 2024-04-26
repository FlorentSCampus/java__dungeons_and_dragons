package player;

public class Stat {
    private int health;
    private int strength;
    private String oGear;
    private String dGear;

    public Stat(String archetype) {
        switch (archetype) {
            case "WARRIOR":
                this.health = 10;
                this.strength = 10;
                this.oGear = "";
                this.dGear = "";
                break;
            case "WIZARD":
                this.health = 6;
                this.strength = 15;
                this.oGear = "";
                this.dGear = "";
                break;
        }
    }
}
