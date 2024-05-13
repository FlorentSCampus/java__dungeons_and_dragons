package src.enemy;

import src.board.Cell;
import src.player.Player;

public class Enemy implements Cell {
    @Override
    public void open(Player player) {

    }

    @Override
    public String toString() {
        return "DRAGON appear !";
    }
}
