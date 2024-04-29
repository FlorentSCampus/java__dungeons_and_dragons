package src;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    private int menuIndex = 0;
    private String userValue;

    public boolean create() {
        while (true) {
            switch (menuIndex) {
                case 0:
                    menuIndex = newGame();
                    break;
                case 1:
                    menuIndex = username();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public int newGame() {
        System.out.println("New Game [N] or Exit [E]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("N")) {
                    return 1;
                }

                if (userValue.equals("E")) {
                    return (-1);
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data : [N] or [E]");
            }
        }
    }

    public int username() {
        System.out.println("New Game [N] or Exit [E]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("N")) {
                    return 1;
                }

                if (userValue.equals("E")) {
                    return (-1);
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data : [N] or [E]");
            }
        }
    }
}
