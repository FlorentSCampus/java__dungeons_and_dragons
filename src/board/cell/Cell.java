package src.board.cell;

import src.player.Player;

public interface Cell {
    void open(Player player);

    String getItemCategory();

    String getItemName();

    int getItemHealth();

    void setItemHealth(int health);

    int getItemStrength();
}
