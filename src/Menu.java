package src;

import java.util.Scanner;

public class Menu {
    Player player = new Player();
    Scanner scanner = new Scanner(System.in);

    private int menuIndex = 0;
    private String userValue;
    private boolean isModify = false;

    public Menu() {
    }

    public boolean create() {
        while (true) {
            switch (menuIndex) {
                case 0:
                    menuIndex = newGame();
                    break;
                case 1:
                    menuIndex = playerName();
                    break;
                case 2:
                    menuIndex = job();
                    break;
                case 3:
                    menuIndex = jobInfo();
                    break;
                case 4:
                    menuIndex = validation();
                    break;
                case 5:
                    menuIndex = modify();
                    break;
                case 6:
                    return true;
                default:
                    System.exit(0);
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
                    return (-1);
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "New Game [N]" + "\n" + "Exit [E]");
            }
        }
    }

    public int playerName() {
        System.out.println("\n\n" + "PLAYER NAME" + "\n");
        System.out.println("Please enter your player name :");

        userValue = scanner.nextLine().toUpperCase();

        player.setName(userValue);

        if (!isModify) {
            return 2;
        } else {
            return 4;
        }
    }

    public int job() {
        System.out.println("\n\n" + "JOB SELECTION" + "\n");
        System.out.println("Please choose a job between [WARRIOR] or [WIZARD] :" + "\n" + "Job Info [J]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("J")) {
                    return 3;
                }

                if (userValue.equals("WARRIOR") || userValue.equals("WIZARD")) {
                    player.setJob(userValue);
                    return 4;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println(
                        "Please enter a valid data :" + "\n" + "[WARRIOR] or [WIZARD]" + "\n" + "Job Info [J]");
            }
        }
    }

    public int jobInfo() {
        System.out.println("\n\n" + "JOB STAT" + "\n");
        System.out.println("WARRIOR stat :" + "\n"); /// get job info
        System.out.println("WIZARD stat :" + "\n"); /// get job info
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

    public int validation() {
        System.out.println("\n\n" + "CONFIRMATION" + "\n");
        System.out.println("PLAYER NAME :" + "\n" + player.getName());
        System.out.println("JOB :" + "\n" + player.getJob());
        System.out.println("Modify [M]" + "\n" + "Ok [O]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("M")) {
                    return 5;
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

    public int modify() {
        System.out.println("\n\n" + "MODIFY INFO" + "\n");
        System.out.println("playerName [P]" + "\n" + "Job [J]" + "\n" + "Back [B]");

        while (true) {
            try {
                userValue = scanner.nextLine().toUpperCase();

                if (userValue.equals("P")) {
                    isModify = true;
                    return 1;
                }

                if (userValue.equals("J")) {
                    return 2;
                }

                if (userValue.equals("B")) {
                    return 4;
                }

                throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter a valid data :" + "\n" + "Modify [M]" + "\n" + "Ok [O]");
            }
        }
    }
}
