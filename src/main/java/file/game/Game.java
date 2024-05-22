package file.game;

import file.board.Board;
import file.board.cell.Cell;
import file.board.dice.Dice;
import file.menu.Menu;
import file.player.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Menu menu;

    private int playerPosition;
    private boolean isWon;
    private boolean isGameOver;

    private final List<Player> players;

    public Game(Dice dice, Menu menu) {
        this.board = new Board(64);
        this.dice = dice;
        this.menu = menu;

        this.playerPosition = (-1);
        this.isWon = false;
        this.isGameOver = false;

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

    public void launch() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        board.setCells();

        while (!isWon && !isGameOver) {
            for (int i = 0; i < players.size() && !isWon; i++) {
                Cell cell;
                int diceValue = 0;
                int boardSize = (board.getSize() - 1);

                if (menu.getGameMenu().rollDice(players.get(i))) {
                    diceValue = dice.throwDice();
                    playerPosition = playerPosition + diceValue;

                    if (playerPosition > boardSize) {
                        playerPosition = boardSize - (playerPosition - boardSize);
                    }

                    if (playerPosition == boardSize) {
                        menu.getGameMenu().isWon();
                        isWon = true;
                    } else {
                        menu.getGameMenu().gameStat(diceValue, (playerPosition + 1));
                        menu.getGameMenu().playerStat(players.get(i));

                        cell = board.getCell(playerPosition);
                        menu.getGameMenu().displayCell(cell);

                        cell.open(players.get(i));

                        isGameOver = menu.getGameMenu().battlePhase(players.get(i), cell);

                        board.deleteCell(cell, playerPosition);
                    }

                    if (isGameOver) {
                        menu.getGameMenu().isGameOver();
                    }
                }
            }
        }
    }
}
