import java.util.Scanner;

public class Helper {
    public String getUserValue() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        scanner.close();
        return value;
    }
}