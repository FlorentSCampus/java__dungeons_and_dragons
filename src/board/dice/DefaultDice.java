package src.board.dice;

import java.util.Random;

public class DefaultDice implements Dice {

    @Override
    public int throwDice() {
        return new Random().nextInt(6) + 1;
    }
}
