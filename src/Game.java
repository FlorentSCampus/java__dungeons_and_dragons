package src;

import java.util.ArrayList;

public class Game {
    Menu menu = new Menu();

    ArrayList<Player> players = new ArrayList<>();

    private int playersCount = 1;
    private int i = 0;

    public Game() {
    }

    public void launch () {
        playersCount = menu.start();

        while (i < playersCount) {
            players.add(menu.create());
            i++;
        }

        System.out.println("IS CONFIG");

        System.out.println(players.get(0).getName() + "\n" + players.get(0).getJob());
        System.out.println(players.get(1).getName() + "\n" + players.get(1).getJob());
    }
}
