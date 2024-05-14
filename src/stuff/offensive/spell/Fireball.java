package src.stuff.offensive.spell;

import src.player.Player;
import src.player.job.Wizard;
import src.stuff.offensive.OffStuff;

public class Fireball extends OffStuff {
    public Fireball() {
        this.category = "SPELL";
        this.name = "FIREBALL";
        this.stat = 7;
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
