package src.board;

import src.board.cell.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Board {
    private final List<Cell> cells;

    public Board(int cellsCount) {
        this.cells = new ArrayList<>(Collections.nCopies(cellsCount, null));
    }

    public void setCells() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Random random = new Random();
        List<String> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                items.add("src.stuff.offensive.spell.Fireball");
                items.add("src.potion.MaxiPotion");
            }

            if (i < 4) {
                items.add("src.enemy.Dragon");
                items.add("src.stuff.offensive.weapon.MithrilSword");
            }

            if (i < 5) {
                items.add("src.stuff.offensive.weapon.IronMass");
                items.add("src.stuff.offensive.spell.Lightning");
            }

            if (i < 6) {
                items.add("src.potion.MiniPotion");
            }

            if (i < 10) {
                items.add("src.enemy.Goblin");
                items.add("src.enemy.Necromancer");
            }
        }

        Collections.shuffle(items);

        for (String item : items) {
            int i;

            do {
                i = random.nextInt(getSize());
            }
            while (cells.get(i) != null);
            {
                Class<?> itemClass = Class.forName(item);
                Constructor<?> constructor = itemClass.getDeclaredConstructor();
                Object itemInstance = constructor.newInstance();

                cells.set(i, (Cell) itemInstance);
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i) == null) {
                Class<?> itemClass = Class.forName("src.board.cell.EmptyCell");
                Constructor<?> constructor = itemClass.getDeclaredConstructor();
                Object itemInstance = constructor.newInstance();

                cells.set(i, (Cell) itemInstance);
            }
        }
    }

    public Cell getCell(int playerPosition) {
        for (int i = 0; i < cells.size(); i++) {
            if (i == playerPosition) {
                System.out.print("[X]");
            } else {
                String format = String.format("[%d]", (i + 1));
                System.out.print(format);
            }

            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n");

        return cells.get(playerPosition);
    }

    public int getSize() {
        return cells.size();
    }
}
