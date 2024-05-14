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
}
