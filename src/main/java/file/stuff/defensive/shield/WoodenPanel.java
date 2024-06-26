package file.stuff.defensive.shield;

import file.player.Player;
import file.player.job.Warrior;
import file.stuff.defensive.DefStuff;

public class WoodenPanel extends DefStuff {
    public WoodenPanel(){
        this.category = "SHIELD";
        this.name = "WOODEN PANEL";
        this.stat = 5;
    }

    @Override
    public void open(Player player) {
        if(player instanceof Warrior) {
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
