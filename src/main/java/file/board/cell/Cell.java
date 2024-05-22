package file.board.cell;

import file.player.Player;

public interface Cell {
    void open(Player player);

    String getItemCategory();

    String getItemName();

    int getItemHealth();

    void setItemHealth(int health);

    int getItemStrength();
}
