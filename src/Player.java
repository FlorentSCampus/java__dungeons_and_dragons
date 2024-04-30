package src;

public class Player {
    private String playerName;
    private String playerJob;

    public Player() {
    }

    public void setName(String name) {
        playerName = name;
    }

    public void setJob(String job) {
        playerJob = job;
    }

    public String getName() {
        return playerName;
    }

    public String getJob() {
        return playerJob;
    }
}
