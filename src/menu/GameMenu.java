package src.menu;

import src.board.Dice;

import java.util.Scanner;

public class GameMenu {
    private Scanner scanner = new Scanner(System.in);

    private String userValue;

    public GameMenu() {
        this.userValue = "";
    }

    public void gameStat(int roleValue, int playerPosition) {
        System.out.println("Player: FLORENT");
        System.out.println("Dice value: " + roleValue);
        System.out.println("Cell n°: " + playerPosition + "\n");
    }

    public boolean rollDice() {
        System.out.println("Roll the dice ? [ENTER]" + "\n");

        if (scanner.nextLine().equals("")) {
            return true;
        }

        return false;
    }

    public void isWon() {
        System.out.println("IS WON !!!" + "\n");
    }

    public boolean isNewGame(boolean isWon) {
        if(isWon) {
            System.out.println("would you like to start a New Game ?");
            System.out.println("Yes [Y]");
            System.out.println("No [N]");

            userValue = scanner.nextLine().toUpperCase();

            while (true) {
                try {
                    if (userValue.equals("Y")) {
                        return true;
                    }

                    if (userValue.equals("N")) {
                        return false;
                    }

                    throw new Exception();
                } catch (Exception e) {
                    System.out.println("Please enter a valid data:");
                    System.out.println("Yes [Y]");
                    System.out.println("No [N]");
                }
            }
        }

        return true;
    }
}
