package file.menu;

public class Menu {
    private GameMenu gameMenu;
    private InitMenu initMenu;

    public Menu() {
        this.initMenu = new InitMenu();
        this.gameMenu = new GameMenu();
    }

    public void setGameMenu(GameMenu gameMenu) {
        this.gameMenu = gameMenu;
    }

    public GameMenu getGameMenu() {
        return gameMenu;
    }

    public void setInitMenu(InitMenu initMenu) {
        this.initMenu = initMenu;
    }

    public InitMenu getInitMenu() {
        return initMenu;
    }
}
