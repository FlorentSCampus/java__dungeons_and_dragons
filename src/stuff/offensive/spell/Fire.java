package src.stuff.offensive.spell;

import src.player.Player;
import src.player.job.Wizard;
import src.stuff.offensive.OffStuff;

public class Fire extends OffStuff {
    public Fire(){
        this.category = "SPELL";
        this.name = "FIRE";
        this.stat = 1;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Wizard) {
            player.setOffensiveStuff(this);

            if(this.getStat() > player.getOffensiveStuff().getStat()) {
                player.setStrength(player.getStrength() + this.getStat());
            }
        }
    }

    @Override
    public String getItemCategory() {
        return getCategory();
    }

    @Override
    public String getItemName() {
        return getName();
    }

    @Override
    public int getItemHealth() {
        return 0;
    }

    @Override
    public void setItemHealth(int health){};

    @Override
    public int getItemStrength() {
        return 0;
    }

    @Override
    public String toString() {
        return "You find a " + getCategory() + " !" + "\n" + "Name: " + getName() + "\n" + "Attack stat: " + getStat() + "\n";
    }
}
