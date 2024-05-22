package file.menu;

import file.board.cell.Cell;
import file.player.Player;

import java.util.Scanner;

public class GameMenu {
    private Scanner scanner = new Scanner(System.in);

    private String userValue;

    public GameMenu() {
        this.userValue = "";
    }

    public boolean rollDice(Player player) {
        System.out.println(player.getPlayerName() + "'s turn !");
        System.out.println("Roll dice: [ENTER]" + "\n");

        if (scanner.nextLine().equals("")) {
            return true;
        }

        return false;
    }

    public void gameStat(int roleValue, int playerPosition) {
        System.out.println("Dice value: " + roleValue);
        System.out.println("Cell n°: " + playerPosition + "\n");
    }

    public void playerStat(Player player) {
        System.out.println("Job: " + player.getPlayerJob());
        System.out.println("Health: " + player.getHealth());
        System.out.println("Strength base: " + (player.getStrength() - player.getOffensiveStuff().getStat()));
        System.out.println("Strength full: " + player.getStrength());
        System.out.println("Stuff name: " + player.getOffensiveStuff().getName());
        System.out.println("Stuff attack: " + player.getOffensiveStuff().getStat() + "\n");
    }

    public void displayCell(Cell cell) {
        System.out.println(cell.toString());
    }

    public void isWon() {
        System.out.println("YOU WON !!!" + "\n");
    }

    public void isGameOver() {
        System.out.println("YOU LOOSE !!!" + "\n");
    }

    public boolean isNewGame() {
        System.out.println("Would you like to start a New Game ?");
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

    public boolean battlePhase(Player player, Cell cell) throws InterruptedException {
        final Object exec = new Object();

        if (cell.getItemCategory().equals("ENEMY")) {
            synchronized (exec) {
                System.out.println("BATTLE BEGIN !!!" + "\n");
                exec.wait(1000);
                System.out.println("Game chooses the first attacker" + "\n");
                for (int i = 0; i < 3; i++) {
                    exec.wait(1000);
                    System.out.print(".");

                    if (i == 2) {
                        System.out.println("\n");
                    }
                }
                exec.wait(1000);

                double turnOf = Math.round(Math.random());

                if (turnOf == 0) {
                    System.out.println("You start!" + "\n");
                    exec.wait(1000);
                } else {
                    System.out.println(cell.getItemName() + " start!" + "\n");
                    exec.wait(1000);
                }

                while (true) {
                    battleInfo(player, cell);

                    if (turnOf == 0) {
                        System.out.println("Your " + player.getPlayerJob() + " attacks" + "\n");
                        exec.wait(1000);
                        System.out.println(cell.getItemName() + " takes -" + player.getStrength() + " damages" + "\n");
                        exec.wait(1000);

                        int enemyHealth = (cell.getItemHealth() - player.getStrength());

                        cell.setItemHealth(enemyHealth);

                        if (enemyHealth <= 0) {
                            System.out.println("You've killed " + cell.getItemName() + "\n");
                            exec.wait(1000);
                            return false;
                        }

                        turnOf = 1;
                    } else {
                        System.out.println(cell.getItemName() + " attacks" + "\n");
                        exec.wait(1000);
                        System.out.println("Your " + player.getPlayerJob() + " takes -" + cell.getItemStrength() + " damages" + "\n");
                        exec.wait(1000);

                        int playerHealth = (player.getHealth() - cell.getItemStrength());

                        player.setHealth(playerHealth);

                        if (playerHealth <= 0) {
                            System.out.println(cell.getItemName() + " killed you" + "\n");
                            exec.wait(1000);
                            return true;
                        }

                        turnOf = 0;
                    }
                }
            }
        }

        return false;
    }

    public void battleInfo(Player player, Cell cell) {
        System.out.println("You stats:");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Strength: " + player.getStrength());
        System.out.println();
        System.out.println(cell.getItemName() + " stats:");
        System.out.println("Health: " + cell.getItemHealth());
        System.out.println("Strength: " + cell.getItemStrength());
        System.out.println();
    }
}
