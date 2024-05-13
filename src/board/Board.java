package src.board;

import src.enemy.Enemy;
import src.stuff.defensive.philtra.Barrier;
import src.stuff.defensive.shield.WoodenPanel;

import java.util.ArrayList;

public class Board {

    protected ArrayList<Cell> cells;

    public Board() {
        this.cells = new ArrayList<>();

        this.cells.add(new EmptyCell()); // start cell
        this.cells.add(new EmptyCell());
        this.cells.add(new Enemy());
        this.cells.add(new WoodenPanel());
        this.cells.add(new Barrier());
        this.cells.add(new Potion());
        this.cells.add(new EmptyCell()); // end cell
    }


    public Cell getCell(int playerPosition) {
        return cells.get(playerPosition);
//        for (int i = 0; i < cells.length; i++) {
//            if (cells[i] == playerPosition) {
//                System.out.print("[X]");
//            } else {
//                String format = String.format("[%d]", (i + 1));
//                System.out.print(format);
//            }
//
//            if ((i + 1) % 8 == 0) {
//                System.out.println();
//            }
//        }
//
//        System.out.println("\n");
    }

    public int size() {
        return cells.size();
    }
}
