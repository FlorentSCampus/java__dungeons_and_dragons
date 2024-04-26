package menu;

import config.Message;
import helper.Helper;
import player.Config;

public class Menu {
    Helper helper = new Helper();
    Message message = new Message();

    Config config = new Config();

    public String newGame() {
        return helper.getUserValue("newGame");
    }

    public void selection(String value) {
        switch (value) {
            case "NG":
                username();
                archetype();
                summary();
                break;
            case "":
                break;
        }
    }

    public void username() {
        String value = helper.getUserValue("username");

        config.setUsername(value);
    }

    public void archetype() {
        String value = helper.getUserValue("archetype");

        config.setArchetype(value);
    }

    public void summary() {
        String username = config.getUsername();
        String archetype = config.getArchetype();

        String summary = message.getMessage("summary");

        System.out.println(summary);
    }
}
