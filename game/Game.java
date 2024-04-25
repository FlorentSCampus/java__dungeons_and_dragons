package game;

import menu.Menu;

public class Game {
    menu.Menu menu = new Menu();

    private boolean newGame;

    public void launch() {
        newGame = menu.newGame();
    }

    //

    // menu character creation

    public void create() {
        System.out.println(newGame);
    }
}