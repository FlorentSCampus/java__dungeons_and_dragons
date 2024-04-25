package menu;

import helper.Helper;

public class Menu {
    Helper helper = new Helper();

    public boolean newGame() {
        return helper.getUserValue("NG");
    }
}