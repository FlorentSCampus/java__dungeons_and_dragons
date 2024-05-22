package file.board.dice;

public class FakeDice implements Dice {
    private final int fixedValue;

    public FakeDice(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public int throwDice() {
        return fixedValue;
    }
}
