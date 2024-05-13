package src.player;

import src.stuff.defensive.DefStuff;
import src.stuff.offensive.OffStuff;

public abstract class Player {
    protected String playerName;
    protected String playerJob;

    protected int health;
    protected int strength;

    protected DefStuff defensiveStuff;
    protected OffStuff offensiveStuff;

    public Player() {
        this.playerName = "";
        this.playerJob = "";

        this.health = 0;
        this.strength = 0;

        this.defensiveStuff = null;
        this.offensiveStuff = null;
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

    public void setDefensiveStuff(DefStuff defensiveStuff) {
        this.defensiveStuff = defensiveStuff;
    }

    public DefStuff getDefensiveStuff() {
        return defensiveStuff;
    }

    public void setOffensiveStuff(OffStuff offensiveStuff) {
        this.offensiveStuff = offensiveStuff;
    }

    public OffStuff getOffensiveStuff() {
        return offensiveStuff;
    }
}
