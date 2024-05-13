package src;

import src.board.Board;
import src.board.Cell;
import src.board.Dice;
import src.menu.Menu;
import src.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Menu menu;

    private int playerPosition;
    private boolean isWon;

    private final List<Player> players;

    public Game(Dice dice, Menu menu) {
        this.board = new Board();
        this.dice = dice;
        this.menu = menu;

        this.playerPosition = 0;
        this.isWon = false;

        this.players = new ArrayList<>();
    }

    public void init() {
        if (menu.getInitMenu().isNewGame()) {
            int playersCount = menu.getInitMenu().getPlayersCount();

            for (int i = 0; i < playersCount; i++) {
                players.add(menu.getInitMenu().create());
            }
        } else {
            System.exit(0);
        }
    }

    public void launch() {
        while (!isWon) {
            for (int i = 0; i < players.size(); i++) {
                Cell cell;
                int diceValue = 0;
                int boardSize = board.size() - 1;

                System.out.println(playerPosition);
                System.out.println(board.size());

                if (playerPosition == 0) {
                    menu.getGameMenu().gameStat(players.get(i), diceValue, playerPosition);
                }

                if (menu.getGameMenu().rollDice()) {
                    diceValue = dice.throwDice();
                    playerPosition = playerPosition + diceValue;
                    menu.getGameMenu().gameStat(players.get(i), diceValue, playerPosition);
                }

                if (playerPosition > boardSize) {
                    playerPosition = boardSize - (playerPosition - boardSize);
                }

                if (playerPosition == boardSize) {
                    menu.getGameMenu().gameStat(players.get(i), diceValue, playerPosition);
                    board.getCell(playerPosition);
                    menu.getGameMenu().isWon();
                    isWon = true;
                } else {
                    cell = board.getCell(playerPosition);
                    menu.getGameMenu().displayCell(cell);

                    cell.open(players.get(i));
                }
            }
        }


        // TO DELETE
//        players.add(new Warrior("FLORENT", "WARRIOR"));
//        System.out.println(players.get(0).getPlayerName());
//        //
//        dice = new Dice();
//        dice.setRollValue();
//        System.out.println(dice.getRollValue());

//        board = new Board(64);
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
