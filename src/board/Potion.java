package src.board;

import src.player.Player;

public class Potion implements Cell{
    @Override
    public void open(Player player) {
        player.setHealth(player.getHealth() + 3);
    }

    @Override
    public String toString() {
        return "POTION: +3 de santé";
    }
}
