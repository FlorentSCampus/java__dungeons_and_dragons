package file.player.job;

import file.player.Player;
import file.stuff.defensive.philtra.Barrier;
import file.stuff.offensive.spell.Fire;

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
