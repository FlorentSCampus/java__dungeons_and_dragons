package src.board;

import src.board.cell.Cell;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private final int cellsCount;
    private final List<Cell> cells;

    public Board(int cellsCount) {
        this.cellsCount = cellsCount;
        this.cells = new ArrayList<>();
    }

    public void setCells() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        for (int i = 0; i < cellsCount; i++) {
            cells.add(null);
        }

        setCellItems();
    }

    public void setCellItems() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Map<String, int[]> items = new HashMap<>();

        items.put("src.enemy.Dragon", new int[]{45, 52, 56, 62});
        items.put("src.enemy.Goblin", new int[]{3, 6, 9, 12, 15, 18, 21, 24, 27, 30});
        items.put("src.enemy.Necromancer", new int[]{10, 20, 25, 32, 35, 36, 37, 40, 44, 47});

        items.put("src.stuff.offensive.weapon.IronMass", new int[]{2, 100, 5, 22, 38});
        items.put("src.stuff.offensive.weapon.MithrilSword", new int[]{19, 26, 42, 53});
        items.put("src.stuff.offensive.spell.Fireball", new int[]{48, 49});
        items.put("src.stuff.offensive.spell.Lightning", new int[]{1, 4, 8, 17, 23});

        items.put("src.potion.MaxiPotion", new int[]{28, 41});
        items.put("src.potion.MiniPotion", new int[]{7, 13, 31, 33, 39, 43});

        for (Map.Entry<String, int[]> item : items.entrySet()) {
            String itemName = item.getKey();
            int[] itemIndex = item.getValue();

            for(int i = 0; i < cells.size(); i++) {
                for(int j : itemIndex) {
                    if (i == j) {
                        Class<?> itemClass = Class.forName(itemName);
                        Constructor<?> constructor = itemClass.getDeclaredConstructor();
                        Object itemInstance = constructor.newInstance();

                        cells.set((i - 1), (Cell) itemInstance);
                    }
                }
            }
        }

        //
        for(Cell k : cells) {
            System.out.println(k);
        }
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

    public int getSize() {
        return cells.size();
    }
}
