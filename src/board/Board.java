package src.board;

public class Board {
    protected int[] cells;

    public Board() {
        this.cells = new int[0];
    }

    public Board(int boardCellsCount) {
        this.cells = new int[boardCellsCount];
    }

    public void setBoard() {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = i + 1;
        }
    }

    public void getBoard(int playerPosition) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == playerPosition) {
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
    }
}
