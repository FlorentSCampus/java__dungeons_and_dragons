package src;

public class Game {
    private boolean isConfig = false;

    public void launch () {
        while (!isConfig) {
            Menu menu = new Menu();
            isConfig = menu.create();
        }

        System.out.println("CONFIG");
    }
}
