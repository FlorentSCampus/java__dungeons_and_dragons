package src;

import src.board.Board;
import src.board.Dice;
import src.menu.Menu;
import src.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private Dice dice;
    private Menu menu;

    private int boardCellsCount;
    private int playerPosition;
    private boolean isWon;
    private boolean isNewGame;

    private List<Player> players;

    public Game() {
        this.board = new Board();
        this.dice = new Dice();
        this.menu = new Menu();

        this.boardCellsCount = 64;
        this.playerPosition = 1;
        this.isWon = false;
        this.isNewGame = false;

        this.players = new ArrayList<Player>();
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
        board = new Board(boardCellsCount);
        board.setBoard();

        while (menu.getGameMenu().isNewGame(isWon)) {
            while (!isWon) {
                for (int i = 0; i < 1; i++) { // i < players.size()
                    menu.getGameMenu().gameStat(dice.getRollValue(), playerPosition);
                    board.getBoard(playerPosition);

                    if (menu.getGameMenu().rollDice()) {
                        dice.setRollValue();
                        playerPosition = playerPosition + dice.getRollValue();
                    }

                    if (playerPosition > boardCellsCount) {
                        playerPosition = boardCellsCount - (playerPosition - boardCellsCount);
                    }

                    if (playerPosition == boardCellsCount) {
                        menu.getGameMenu().gameStat(dice.getRollValue(), playerPosition);
                        board.getBoard(playerPosition);

                        isWon = true;
                    }
                }
            }

            menu.getGameMenu().isWon();
        }

        isWon = false;

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
