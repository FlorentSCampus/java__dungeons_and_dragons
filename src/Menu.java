package src;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    private String userValue;
    private int menuIndex = 0;

    public Menu() {
    }

    public int start() {
        menuIndex = newGame();
        return setPlayersNb();
    }

    public Player create(Player player) {
        while (true) {
            switch (menuIndex) {
                case 1:
                    menuIndex = setPlayerName(player, false);
                    break;
                case 2:
                    menuIndex = setJob(player, false);
                    break;
                case 3:
                    menuIndex = jobInfo();
                    break;
                case 4:
                    menuIndex = modify(player);
                    break;
                case 5:
                    menuIndex = validation(player);
                    break;
                case 6:
                    menuIndex = 1;
                    return player;
            }
        }
    }

    public int newGame() {
        System.out.println("\n\n" + "WELCOME TO D&D" + "\n");
        System.out.println("New Game [N]" + "\n" + "Exit [E]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("N")) {
                    return 1;
                }

                if (userValue.equals("E")) {
                    System.exit(0);
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "New Game [N]" + "\n" + "Exit [E]");
            }
        }
    }

    public int setPlayersNb() {
        System.out.println("\n\n" + "CHOOSE PLAYERS NUMBER" + "\n");
        System.out.println("[ENTER] 1 by default");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

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

    public int setPlayerName(Player player, boolean isModify) {
        System.out.println("\n\n" + "PLAYER NAME" + "\n");
        System.out.println("Please enter your Player Name :");

        userValue = scanner.nextLine().toUpperCase();

        player.setName(userValue);

        if (!isModify) {
            return 2;
        } else {
            return 4;
        }
    }

    public int setJob(Player player, boolean isModify) {
        System.out.println("\n\n" + "JOB SELECTION" + "\n");
        System.out.println("Please choose a job between WARRIOR or WIZARD :" + "\n" + "Job Info [J]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("J")) {
                    return 3;
                }

                if (userValue.equals("WARRIOR") || userValue.equals("WIZARD")) {
                    player.setJob(userValue);

                    if (!isModify) {
                        return 5;
                    } else {
                        return 4;
                    }
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println(
                        "Please enter a valid data :" + "\n" + "WARRIOR or WIZARD" + "\n" + "Job Info [J]");
            }
        }
    }

    public int jobInfo() {
        // Attribute attribute = new Attribute();
        System.out.println("\n\n" + "JOB STAT" + "\n");
        /// get job info
        /// get job info
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

    public int modify(Player player) {
        System.out.println("\n\n" + "MODIFY INFO" + "\n");
        System.out.println("PLAYER NAME: " + player.getName());
        System.out.println("JOB: " + player.getJob());
        System.out.println("\n\n" + "Player Name [P]" + "\n" + "Job [J]" + "\n" + "Back [B]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("P")) {
                    setPlayerName(player, true);
                    return 4;
                }

                if (userValue.equals("J")) {
                    setJob(player, true);
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

    public int validation(Player player) {
        System.out.println("\n\n" + "CONFIRMATION" + "\n");
        System.out.println("PLAYER NAME: " + player.getName());
        System.out.println("JOB: " + player.getJob());
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
}
