package src.stuff.offensive.weapon;

import src.player.Player;
import src.player.job.Warrior;
import src.stuff.offensive.OffStuff;

public class MithrilSword extends OffStuff {
    public MithrilSword(){
        this.category = "WEAPON";
        this.name = "MITHRIL SWORD";
        this.stat = 5;
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
    public String toString() {
        return "You find a " + getCategory() + " !" + "\n" + "Name: " + getName() + "\n" + "Attack stat: " + getStat() + "\n";
    }
}
