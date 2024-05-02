package src.job;

import src.Player;
import src.Stuff;

public class Warrior extends Player {
    public Warrior() {
        this.playerJob = "WARRIOR";
        this.health = 10;
        this.strength = 10;

        this.offensiveStuff = new Stuff("SWORD", "WOODEN SWORD", 5);
        this.defensiveStuff = new Stuff("SHIELD", "undefined", 0);
    }

    public Warrior(String playerName, String playerJob) {
        super(playerName, playerJob);

        this.health = 10;
        this.strength = 10;

        this.offensiveStuff = new Stuff("SWORD", "WOODEN SWORD", 5);
        this.defensiveStuff = new Stuff("SHIELD", "undefined", 0);
    }
}
