package src.stuff.defensive.shield;

import src.player.Player;
import src.player.job.Warrior;
import src.stuff.defensive.DefStuff;

public class WoodenPanel extends DefStuff {
    public WoodenPanel(){
        this.category = "SHIELD";
        this.name = "WOODEN PANEL";
        this.stat = 5;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Warrior) {
            player.setDefensiveStuff(this);
        }
    }
}
