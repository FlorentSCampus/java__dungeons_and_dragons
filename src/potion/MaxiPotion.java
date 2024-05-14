package src.potion;

import src.board.cell.Cell;
import src.player.Player;

public class MaxiPotion implements Cell {
    String name;
    int care;

    public MaxiPotion() {
        this.name = "MAXI POTION";
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
