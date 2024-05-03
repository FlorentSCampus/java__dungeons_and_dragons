package src;

import src.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Menu menu = new Menu();

    List<Player> players = new ArrayList<Player>();

    public void init() {
        if (menu.isNewGame()) {
            int playersCount = menu.getPlayersCount();

            for (int i = 0; i < playersCount; i++) {
                players.add(menu.create());
            }
        } else {
            System.exit(0);
        }
    }

    public void launch() {


//        board = new Board(boardCellsCount);
//        board.setBoard();
//
//        int i = 0;
//        while(i < 10){
//            Die die = new Die();
//            die.getDieValue();
//            i++;
//        }


//        display players infos
//        for (int i = 0; i < players.size(); i++) {
//            System.out.println("Name: " + players.get(i).getPlayerName());
//            System.out.println("Job: " + players.get(i).getPlayerJob());
//            System.out.println("Health: " + players.get(i).getHealth());
//            System.out.println("Strength: " + players.get(i).getStrength() + "\n");
//            System.out.println("Offensive Stuff: ");
//            System.out.println("Name: " + players.get(i).getOffensiveStuff().getName());
//            if (players.get(i).getOffensiveStuff().getCategory().equals("WEAPON") || players.get(i).getOffensiveStuff().getCategory().equals("SPELL")) {
//                System.out.println("Attack: " + players.get(i).getOffensiveStuff().getStat() + "\n");
//            }
//            System.out.println("Defensive Stuff: ");
//            System.out.println("Name: " + players.get(i).getDefensiveStuff().getName());
//            if (players.get(i).getDefensiveStuff().getCategory().equals("SHIELD") || players.get(i).getDefensiveStuff().getCategory().equals("PHILTRA")) {
//                System.out.println("Defense: " + players.get(i).getDefensiveStuff().getStat() + "\n");
//            }
//        }
    }
}
