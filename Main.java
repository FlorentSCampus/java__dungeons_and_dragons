import src.Game;
import src.board.Board;
import src.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while(true) {
            Game game = new Game(menu);
            game.init();
            game.launch();

            if (menu.getGameMenu().isNewGame()) {
                break;
            }
        }


    }
}