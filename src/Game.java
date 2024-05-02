package src;

import src.job.Warrior;
import src.job.Wizard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Menu menu;
    Player player;

    List<Player> players = new ArrayList<Player>();

    private int playersCount = 1;

    public void launch() {
        menu = new Menu();

        if (menu.isNewGame()) {
            playersCount = menu.getPlayersCount();

            for (int i = 0; i < playersCount; i++) {
                player = new Player();
                player = menu.create(player);

                if (player.getPlayerJob().equals("WARRIOR")) {
                    players.add(new Warrior(player.getPlayerName(), player.getPlayerJob()));
                }

                if (player.getPlayerJob().equals("WIZARD")) {
                    players.add(new Wizard(player.getPlayerName(), player.getPlayerJob()));
                }
            }
        } else {
            System.exit(0);
        }

//        generate game board !!!


//        display players infos
        for (int i = 0; i < players.size(); i++) {
            System.out.println("Name: " + players.get(i).getPlayerName());
            System.out.println("Job: " + players.get(i).getPlayerJob());
            System.out.println("Health: " + players.get(i).getHealth());
            System.out.println("Strength: " + players.get(i).getStrength() + "\n");
            System.out.println("Offensive Stuff: ");
            System.out.println("Name: " + players.get(i).getOffensiveStuff().getName());
            if (players.get(i).getOffensiveStuff().getCategory().equals("SWORD") || players.get(i).getOffensiveStuff().getCategory().equals("SPELL")) {
                System.out.println("Attack: " + players.get(i).getOffensiveStuff().getStat() + "\n");
            }
        }
    }
}
