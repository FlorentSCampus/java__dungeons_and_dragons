package src.potion;

import src.board.cell.Cell;
import src.player.Player;

public class MaxiPotion implements Cell {
    String category;
    String name;
    int care;

    public MaxiPotion() {
        this.category = "POTION";
        this.name = "MAXI POTION";
        this.care = 2;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    @Override
    public void open(Player player) {
        player.setHealth(player.getHealth() + care);
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
        return "You collect a " + name + ":" + "\n" + "health +" + care + "\n";
    }
}
