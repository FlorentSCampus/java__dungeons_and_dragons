package file.stuff.offensive.spell;

import file.player.Player;
import file.player.job.Wizard;
import file.stuff.offensive.OffStuff;

public class Lightning extends OffStuff {
    public Lightning() {
        this.category = "SPELL";
        this.name = "LIGHTNING";
        this.stat = 2;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Wizard) {
            int currentPlayerStrength = player.getStrength();
            int currentWeaponStat = player.getOffensiveStuff().getStat();

            if(this.getStat() > player.getOffensiveStuff().getStat()) {
                player.setStrength((currentPlayerStrength - currentWeaponStat) + this.getStat());
                player.setOffensiveStuff(this);
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
