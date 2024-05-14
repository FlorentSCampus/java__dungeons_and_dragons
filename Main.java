import src.Game;
import src.board.dice.DefaultDice;
import src.board.dice.Dice;
import src.board.dice.FakeDice;
import src.menu.Menu;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Menu menu = new Menu();
//        Dice dice = new FakeDice(1);
        Dice dice = new DefaultDice();

        while(true) {
            Game game = new Game(dice, menu);
//            game.init();
            game.launch();

            if (menu.getGameMenu().isNewGame()) {
                break;
            }
        }


    }
}