import src.Game;

import src.board.dice.DefaultDice;
import src.board.dice.Dice;
import src.board.dice.FakeDice;

import src.db.DB;

import src.menu.Menu;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException, SQLException {
        Menu menu = new Menu();
//        Dice dice = new FakeDice(1);
        Dice dice = new DefaultDice();

        DB db = new DB();
//        db.getHero(db.getConnection());
//        db.createHero(db.getConnection(), "WARRIOR", "FLORENT");
//        db.editHero(db.getConnection(), 9, "new ME");
//        db.editHealth(db.getConnection(), 9, 50);



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