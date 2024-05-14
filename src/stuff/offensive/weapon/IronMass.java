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
            player.setOffensiveStuff(this);
        }
    }

    @Override
    public String toString() {
        return "You find a " + getCategory() + " !" + "\n" + "Name: " + getName() + "\n" + "Attack stat: " + getStat() + "\n";
    }
}
