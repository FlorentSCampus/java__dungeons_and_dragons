package src.stuff.offensive.sword;

import src.player.Player;
import src.player.job.Warrior;
import src.stuff.offensive.OffStuff;

public class WoodenSword extends OffStuff {
    public WoodenSword(){
        this.category = "WEAPON";
        this.name = "WOODEN SWORD";
        this.stat = 5;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Warrior) {
            player.setOffensiveStuff(this);
        }
    }
}
