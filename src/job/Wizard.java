package src.job;

import src.Player;
import src.Stuff;

public class Wizard extends Player {
    public Wizard() {
        this.playerJob = "WIZARD";
        this.health = 6;
        this.strength = 15;

        this.offensiveStuff = new Stuff("SPELL", "FIRE", 10);
        this.defensiveStuff = new Stuff("PHILTRA", "undefined", 0);
    }

    public Wizard(String playerName, String playerJob) {
        super(playerName, playerJob);

        this.health = 6;
        this.strength = 15;

        this.offensiveStuff = new Stuff("SPELL", "FIRE", 10);
        this.defensiveStuff = new Stuff("PHILTRA", "undefined", 0);
    }
}
