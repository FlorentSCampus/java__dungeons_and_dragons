package src.board.cell;

import src.player.Player;

public class EmptyCell implements Cell{
    @Override
    public void open(Player player) {
    }

    @Override
    public String getItemCategory() {
        return "CELL";
    }

    @Override
    public String getItemName() {
        return "EMPTY CELL";
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
        return "EMPTY CELL" + "\n";
    }
}
