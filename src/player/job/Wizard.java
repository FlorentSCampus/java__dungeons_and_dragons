package src.player.job;

import src.player.Player;
import src.stuff.defensive.philtra.Barrier;
import src.stuff.offensive.spell.Fire;

public class Wizard extends Player {
    public Wizard() {
        this.playerJob = "WIZARD";
        this.health = 6;
        this.strength = 15;

        this.defensiveStuff = new Barrier();
        this.offensiveStuff = new Fire();
    }

    public Wizard(String playerName, String playerJob) {
        super(playerName, playerJob);

        this.health = 6;
        this.strength = 15;

        this.defensiveStuff = new Barrier();
        this.offensiveStuff = new Fire();
    }
}
