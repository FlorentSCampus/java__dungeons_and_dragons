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
//        db.getHeroes(db.getConnection());
//        db.getPlayer(db.getConnection(), "000");
        db.setPlayer(db.getConnection(), "florent", "warrior");
//        db.editPlayer(db.getConnection(), 9, "new me");
//        db.editHealth(db.getConnection(), 9, 50);
//        db.createGameboard(db.getConnection(), 64);


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