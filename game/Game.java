package game;

import menu.Menu;

public class Game {
    Menu menu = new Menu();

    private String value;

    public void launch() {
        value = menu.newGame();

        if (value.equals("NG")) {
            menu.selection(value);
        } else {
            System.exit(0);
        }
    }
}
