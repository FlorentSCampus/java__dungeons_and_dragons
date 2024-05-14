package src.potion;

import src.board.cell.Cell;
import src.player.Player;

public class MiniPotion implements Cell {
    String name;
    int care;

    public MiniPotion() {
        this.name = "MINI POTION";
        this.care = 2;
    }

    @Override
    public void open(Player player) {
        player.setHealth(player.getHealth() + care);
    }

    @Override
    public String toString() {
        return "You collect a " + name + ":" + "\n" + "health +" + care + "\n";
    }
}
