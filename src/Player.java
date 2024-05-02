package src;

public class Player {
    private Stuff stuff;

    protected String playerName;
    protected String playerJob;

    protected int health;
    protected int strength;

    protected Stuff offensiveStuff;
    protected Stuff defensiveStuff;

    public Player() {
        this.playerName = "";
        this.playerJob = "";

        this.health = 0;
        this.strength = 0;

        this.offensiveStuff = null;
        this.defensiveStuff = null;
    }

    public Player(String playerName, String playerJob) {
        this.playerName = playerName;
        this.playerJob = playerJob;
    }


    public void setPlayerName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerJob(String playerJob) {
        this.playerJob = playerJob;
    }

    public String getPlayerJob() {
        return playerJob;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setOffensiveStuff(Stuff offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public Stuff getOffensiveStuff() {
        return offensiveStuff;
    }

    public void setDefensiveStuff(Stuff defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }

    public Stuff getDefensiveStuff() {
        return defensiveStuff;
    }
}
