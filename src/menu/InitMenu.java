package src.menu;

import src.player.Player;
import src.player.job.Warrior;
import src.player.job.Wizard;

import java.util.Scanner;

public class InitMenu {
    private Warrior warrior = new Warrior();
    private Wizard wizard = new Wizard();

    private Scanner scanner = new Scanner(System.in);

    private String userValue;
    private int menuIndex;

    private String playerName;
    private String playerJob;

    public InitMenu() {
        this.userValue = "";
        this.menuIndex = 1;
    }

    public Player create() {
        while (true) {
            switch (menuIndex) {
                case 1:
                    menuIndex = setPlayerName(false);
                    break;
                case 2:
                    menuIndex = setPlayerJob(false);
                    break;
                case 3:
                    menuIndex = jobInfo();
                    break;
                case 4:
                    menuIndex = modifyPlayerInfo();
                    break;
                case 5:
                    menuIndex = validationPlayerInfo();
                    break;
                case 6:
                    menuIndex = 1;
                    return createPlayer();
            }
        }
    }

    public boolean isNewGame() {
        System.out.println("\n\n" + "WELCOME TO D&D" + "\n");
        System.out.println("New Game [N]");
        System.out.println("Exit [E]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("N")) {
                    return true;
                }

                if (userValue.equals("E")) {
                    return false;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data:");
                System.out.println("New Game [N]");
                System.out.println("Exit [E]");
            }
        }
    }

    public int getPlayersCount() {
        System.out.println("\n\n" + "CHOOSE PLAYERS NUMBER" + "\n");
        System.out.println("1 by default [ENTER]");

        while (true) {
            try {
                userValue = scanner.nextLine();

                if (userValue.equals("")) {
                    return 1;
                }

                if (Integer.valueOf(userValue) instanceof Integer) {
                    return Integer.valueOf(userValue);
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
    }

    public int setPlayerName(boolean isModify) {
        System.out.println("\n\n" + "PLAYER NAME" + "\n");
        System.out.println("Please enter your Player Name:");

        playerName = scanner.nextLine().toUpperCase();

        if (!isModify) {
            return 2;
        } else {
            return 4;
        }
    }

    public int setPlayerJob(boolean isModify) {
        System.out.println("\n\n" + "JOB SELECTION" + "\n");
        System.out.println("Please choose a job between WARRIOR or WIZARD:");
        System.out.println("Job Info [J]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("J")) {
                    return 3;
                }

                if (userValue.equals("WARRIOR") || userValue.equals("WIZARD")) {
                    playerJob = userValue;

                    if (!isModify) {
                        return 5;
                    } else {
                        return 4;
                    }
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data:");
                System.out.println("WARRIOR or WIZARD");
                System.out.println("Job Info [J]");
            }
        }
    }

    public int jobInfo() {
        System.out.println("\n\n" + "JOB STAT" + "\n");

        System.out.println("WARRIOR");
        System.out.println("Health: " + warrior.getHealth());
        System.out.println("Strength: " + warrior.getStrength() + "\n");
        System.out.println("Offensive Stuff: ");
        System.out.println("Name: " + warrior.getOffensiveStuff().getName());
        System.out.println("Attack: " + warrior.getOffensiveStuff().getStat() + "\n");

        System.out.println("WIZARD");
        System.out.println("Health: " + wizard.getHealth());
        System.out.println("Strength: " + wizard.getStrength() + "\n");
        System.out.println("Offensive Stuff: ");
        System.out.println("Name: " + wizard.getOffensiveStuff().getName());
        System.out.println("Attack: " + wizard.getOffensiveStuff().getStat() + "\n");

        System.out.println("Back [B]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("B")) {
                    return 2;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "Back [B]");
            }
        }
    }

    public int modifyPlayerInfo() {
        System.out.println("\n\n" + "MODIFY INFO" + "\n");
        System.out.println("Player Name: " + playerName);
        System.out.println("Job: " + playerJob);
        System.out.println("\n\n" + "Player Name [P]" + "\n" + "Job [J]" + "\n" + "Back [B]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("P")) {
                    setPlayerName(true);
                    return 4;
                }

                if (userValue.equals("J")) {
                    setPlayerJob(true);
                    return 4;
                }

                if (userValue.equals("B")) {
                    return 5;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "Player Name [P]" + "\n" + "Job [J]" + "\n"
                        + "Back [B]");
            }
        }
    }

    public int validationPlayerInfo() {
        System.out.println("\n\n" + "VALIDATION" + "\n");
        System.out.println("Player Name: " + playerName);
        System.out.println("Job: " + playerJob);
        System.out.println("\n\n" + "Modify [M]" + "\n" + "Ok [O]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("M")) {
                    return 4;
                }

                if (userValue.equals("O")) {
                    return 6;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "Modify [M]" + "\n" + "Ok [O]");
            }
        }
    }

    public Player createPlayer() {
        if (playerJob.equals("WARRIOR")) {
            return new Warrior(playerName, playerJob);
        }

        if (playerJob.equals("WIZARD")) {
            return new Wizard(playerName, playerJob);
        }

        return null;
    }
}
