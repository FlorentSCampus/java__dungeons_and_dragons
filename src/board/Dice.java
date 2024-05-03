package src.board;

import java.util.Random;

public class Dice {
    Random random;

    private int rollValue;

    public Dice() {
        this.rollValue = 0;
    }

    public void setRollValue() {
        random = new Random();

        this.rollValue = random.nextInt(6) + 1;
    }

    public int getRollValue() {
        return rollValue;
    }
}
