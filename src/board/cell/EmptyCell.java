package src.board.cell;

import src.player.Player;

public class EmptyCell implements Cell{
    @Override
    public void open(Player player) {
    }

    @Override
    public String toString() {
        return "EMPTY CELL" + "\n";
    }
}