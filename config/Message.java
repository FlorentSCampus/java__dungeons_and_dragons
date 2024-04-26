package config;

public class Message {
    public String getMessage(String menuContext) {
        switch (menuContext) {
            case "newGame":
                return "New Game [NG] or Exit [E]";
            case "username":
                return "Please enter your username";
            case "archetype":
                return "Please choose between [WARRIOR] or [WIZARD]";
            case "summary":
                return "Summary of your information";
            default:
                return "";
        }
    }
}
