package file.board;

import file.board.cell.Cell;
import file.enemy.Dragon;
import file.enemy.Goblin;
import file.enemy.Necromancer;
import file.potion.MaxiPotion;
import file.potion.MiniPotion;
import file.stuff.offensive.spell.Fireball;
import file.stuff.offensive.spell.Lightning;
import file.stuff.offensive.weapon.IronMass;
import file.stuff.offensive.weapon.MithrilSword;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {
    private final List<Cell> cells;

    public Board(int cellsCount) {
        this.cells = new ArrayList<>(Collections.nCopies(cellsCount, null));
    }

    public void setCells() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Random random = new Random();
        List<Class<?>> items = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                items.add(Fireball.class);
                items.add(MaxiPotion.class);
            }

            if (i < 4) {
                items.add(Dragon.class);
                items.add(MithrilSword.class);
            }

            if (i < 5) {
                items.add(IronMass.class);
                items.add(Lightning.class);
            }

            if (i < 6) {
                items.add(MiniPotion.class);
            }

            if (i < 10) {
                items.add(Goblin.class);
                items.add(Necromancer.class);
            }
        }

        Collections.shuffle(items);

        for (Class<?> item : items) {
            int i;

            do {
                i = random.nextInt(getSize());
            }
            while (cells.get(i) != null);
            {
                Object itemInstance = item.getDeclaredConstructor().newInstance();

                cells.set(i, (Cell) itemInstance);
            }
        }

        for (int i = 0; i < cells.size(); i++) {
            if (cells.get(i) == null) {
                Class<?> itemClass = Class.forName("file.board.cell.EmptyCell");
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

            if (((i + 1) % 8 == 0) && (i < (cells.size() - 1))) {
                System.out.println();
            }
        }

        System.out.println("\n");

        return cells.get(playerPosition);
    }

    public void deleteCell(Cell cell, int playerPosition) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (!cell.getItemName().equals("EMPTY CELL")) {
            Class<?> itemClass = Class.forName("file.board.cell.EmptyCell");
            Constructor<?> constructor = itemClass.getDeclaredConstructor();
            Object itemInstance = constructor.newInstance();

            cells.set(playerPosition, (Cell) itemInstance);
        }
    }

    public int getSize() {
        return cells.size();
    }
}
