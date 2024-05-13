import src.Game;
import src.board.Board;
import src.board.Dice;
import src.board.FakeDice;
import src.board.NormalDice;
import src.menu.Menu;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Dice dice = new FakeDice(1);
//        Dice dice = new NormalDice();

        while(true) {
            Game game = new Game(dice, menu);
            game.init();
            game.launch();

            if (menu.getGameMenu().isNewGame()) {
                break;
            }
        }


    }
}