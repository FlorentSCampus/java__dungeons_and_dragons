import java.util.Scanner;

public class Menu {
    public void characterChoice() {
        if (newGame()) {
            // Character character = new Character();
        } else {
            System.exit(0);
        }
    }

    public boolean newGame() {
        System.out.println("New game (NG) or Exit (E)");

        Scanner scanner = new Scanner(System.in);
        String value = "";

        while (true) {
            try {
                value = scanner.nextLine().toUpperCase();

                if (value.equals("NG")) {
                    scanner.close();
                    return true;
                } else if (value.equals("E")) {
                    scanner.close();
                    return false;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Please enter valid data :");
            }
        }
    }
}