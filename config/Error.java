package config;

public class Error {
    public String getError(String menuContext) {
        switch (menuContext) {
            case "newGame":
                return "Please enter a valid data : [NG] or [E]";
            case "username":
                return "";
            case "archetype":
                return "Please enter a valid data : [WARRIOR] or [WIZARD]";
            default:
                return "";
        }
    }
}
