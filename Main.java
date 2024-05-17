import src.Game;

import src.board.Board;
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
//        db.getHeroes();
//        db.getPlayer("10889ce0-f590-4dce-8efd-5c9c4fe09a8b");
//        db.setPlayer("azerty", "wizard");
//        System.out.println(db.getName("10889ce0-f590-4dce-8efd-5c9c4fe09a8b"));
//        db.setName("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", "florent");
//        System.out.println(db.getType("10889ce0-f590-4dce-8efd-5c9c4fe09a8b"));
//        db.setType("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", "warrior");
//        System.out.println(db.getHealth("10889ce0-f590-4dce-8efd-5c9c4fe09a8b"));
//        db.setHealth("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", 9999);
//        System.out.println(db.getStrength("10889ce0-f590-4dce-8efd-5c9c4fe09a8b"));
//        db.setStrength("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", 9999);

        db.setCells();
//        db.setGameboard("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", board.getDbCells());
//        System.out.println(db.getCells());



//        System.out.println(db.getUuid());

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