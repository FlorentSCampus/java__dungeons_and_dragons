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

        DB db = new DB(64);
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
//        db.setGameboardPlayer("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", db.getCells());
        db.updateGameboardPlayer("10889ce0-f590-4dce-8efd-5c9c4fe09a8b", db.getCells());
        String[] gbp = db.getGameboardPlayer("10889ce0-f590-4dce-8efd-5c9c4fe09a8b");

        for(String cell : gbp) {
            System.out.println(cell);
        }

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
