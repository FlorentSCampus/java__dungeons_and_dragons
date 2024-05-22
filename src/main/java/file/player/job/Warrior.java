package file.player.job;

import file.player.Player;
import file.stuff.defensive.shield.WoodenPanel;
import file.stuff.offensive.weapon.WoodenSword;

public class Warrior extends Player {
    public Warrior() {
        this.playerJob = "WARRIOR";
        this.health = 10;
        this.strength = 10;

        this.defensiveStuff = new WoodenPanel();
        this.offensiveStuff = new WoodenSword();
    }

    public Warrior(String playerName, String playerJob) {
        super(playerName, playerJob);

        this.health = 10;
        this.strength = 10;

        this.defensiveStuff = new WoodenPanel();
        this.offensiveStuff = new WoodenSword();
    }
}
