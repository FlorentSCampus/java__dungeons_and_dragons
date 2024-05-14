package src.menu;

import src.board.cell.Cell;
import src.player.Player;

import java.util.Scanner;

public class GameMenu {
    private Scanner scanner = new Scanner(System.in);

    private String userValue;

    public GameMenu() {
        this.userValue = "";
    }

    public void gameStat(Player player, int roleValue, int playerPosition) {
        System.out.println("Player: " + player.getPlayerName());
        System.out.println("Dice value: " + roleValue);
        System.out.println("Cell n°: " + playerPosition + "\n");
    }

    public boolean rollDice() {
        System.out.println("Roll dice: [ENTER]" + "\n");

        if (scanner.nextLine().equals("")) {
            return true;
        }

        return false;
    }

    public void isWon() {
        System.out.println("IS WON !!!" + "\n");
    }

    public boolean isNewGame() {
        System.out.println("would you like to start a New Game ?");
        System.out.println("Yes [Y]");
        System.out.println("No [N]");


        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("Y")) {
                    return false;
                }

                if (userValue.equals("N")) {
                    return true;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data:");
                System.out.println("Yes [Y]");
                System.out.println("No [N]");
            }
        }
    }

    public void displayCell(Cell cell) {
        System.out.println("Vous avez ouvert la cellule:");
        System.out.println(cell.toString());
    }
}
