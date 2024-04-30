package src;

public class Attribute {
    private int[] warriorBaseStats = { 10, 10 };
    private int[] wizardBaseStats = { 6, 15 };

    private int health;
    private int strength;

    public Attribute() {
    }

    public Attribute(int[] stat) {
        this.health = stat[0];
        this.strength = stat[1];
    }

    public int[] getWarriorBaseStats() {
        return warriorBaseStats;
    }

    public int[] getWizardBaseStats() {
        return wizardBaseStats;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }
}
