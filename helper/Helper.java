package helper;

import java.util.Scanner;

import config.Error;
import config.Message;

public class Helper {
    Message message = new Message();
    Error error = new Error();

    Scanner scanner = new Scanner(System.in);

    private String[] arr = {"NG", "E", "WARRIOR", "WIZARD", "I", "M", "OK"};
    private String value;

    public String getUserValue(String menuContext) {
        System.out.println(message.getMessage(menuContext));

        while (true) {
            try {
                value = scanner.nextLine().toUpperCase();
                
                for (String arrValue: arr) {
                    if (value.equals(arrValue) || menuContext.equals("username")) {
                        return value;
                    }
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println(error.getError(menuContext));
            }
        }
    }
}
