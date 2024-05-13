package src.stuff.offensive.spell;

import src.player.Player;
import src.player.job.Wizard;
import src.stuff.offensive.OffStuff;

public class Fire extends OffStuff {
    public Fire(){
        this.category = "SPELL";
        this.name = "FIRE";
        this.stat = 10;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Wizard) {
            player.setOffensiveStuff(this);
        }
    }
}
