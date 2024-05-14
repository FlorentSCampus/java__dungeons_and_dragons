package src.stuff.offensive.weapon;

import src.player.Player;
import src.player.job.Warrior;
import src.stuff.offensive.OffStuff;

public class IronMass extends OffStuff {
    public IronMass(){
        this.category = "WEAPON";
        this.name = "IRON MASS";
        this.stat = 3;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Warrior) {
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
