package file;

import file.board.dice.DefaultDice;
import file.board.dice.Dice;
import file.db.DB;
import file.menu.Menu;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class App
{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException, SQLException {
        Menu menu = new Menu();
//        Dice dice = new FakeDice(1);
        Dice dice = new DefaultDice();

//        DB db = new DB(64);
//        db.test();

//        while(true) {
//            Game game = new Game(dice, menu);
//            game.init();
//            game.launch();
//
//            if (menu.getGameMenu().isNewGame()) {
//                break;
//            }
//        }
    }
}
