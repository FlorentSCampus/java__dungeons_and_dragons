package src.enemy;

import src.board.cell.Cell;
import src.player.Player;

public class Enemy implements Cell {
    protected String category;
    protected String name;
    protected int health;
    protected int strength;

    public Enemy () {
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void open(Player player) {
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
        return getHealth();
    }

    @Override
    public void setItemHealth(int health) {
        this.health = health;
    }

    @Override
    public int getItemStrength() {
        return getStrength();
    }

    @Override
    public String toString() {
        return getName() + " appear !" + "\n" + "Health: " + getHealth() + "\n" + "Strength: " + getStrength() + "\n";
    }
}
