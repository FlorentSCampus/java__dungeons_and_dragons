package src.stuff.defensive.philtra;

import src.player.Player;
import src.player.job.Wizard;
import src.stuff.defensive.DefStuff;

public class Barrier extends DefStuff {
    public Barrier(){
        this.category = "PHILTRA";
        this.name = "BARRIER";
        this.stat = 5;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Wizard) {
            player.setDefensiveStuff(this);
        }
    }
}
