package src.stuff.offensive.spell;

import src.player.Player;
import src.player.job.Wizard;
import src.stuff.offensive.OffStuff;

public class Lightning extends OffStuff {
    public Lightning() {
        this.category = "SPELL";
        this.name = "LIGHTNING";
        this.stat = 2;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Wizard) {
            player.setOffensiveStuff(this);
        }
    }

    @Override
    public String toString() {
        return "You find a " + getCategory() + " !" + "\n" + "Name: " + getName() + "\n" + "Attack stat: " + getStat() + "\n";
    }
}
