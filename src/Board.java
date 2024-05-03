package src;

public class Board {
    private int[] cells;

    public Board() {
        this.cells = null;
    }

    public void setCells(int[] cells) {
        this.cells = cells;
    }

    public int[] getCells() {
        return cells;
    }

    public void fillBoard(int cellsCount) {
        cells = new int[cellsCount];

        for (int i = 0; i < cells.length; i++) {
            cells[i] = i++;
        }
    }

    public void printBoard() {
        for (int i = 0; i < cells.length; i++) {
            String format = String.format("[%d]", cells[i]);
            System.out.print(format);

            if ((i + 1) % 8 == 0) {
                System.out.println();
            }
        }
    }
}
