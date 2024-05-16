package src.db;

import src.player.job.Warrior;
import src.player.job.Wizard;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
    Config config;
    List<Class<?>> classes = new ArrayList<>();

    public DB() {
        this.config = new Config();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(config.getURL(), config.getUSERNAME(), config.getPWD());
        } catch (SQLException e) {
            System.out.println("Failed connection to database!");
        }

        return null;
    }

    public void getHero(Connection db) throws SQLException {
        try {
            Statement statement = db.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM hero");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int health = resultSet.getInt("health");
                int strength = resultSet.getInt("strength");
                String offStuff = resultSet.getString("off_stuff");
                String defStuff = resultSet.getString("def_stuff");

                System.out.println("Id: " + id);
                System.out.println("Type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Health: " + health);
                System.out.println("Strength: " + strength);
                System.out.println("Off stuff: " + offStuff);
                System.out.println("Def stuff: " + defStuff);
            }
        } catch (SQLException e) {
            System.out.println("Failed connection to database!");
        }
    }

    public void createHero() {

    }

    public void editHero() {

    }

    public void editHealth(int health) {

    }

//
//
//

//    public void getHero() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        classes.add(Warrior.class);
//        classes.add(Wizard.class);
//
//        for(Class<?> item : classes) {
//            Object itemInstance = item.getDeclaredConstructor().newInstance();
//
//            Object job = item.getMethod("getPlayerJob").invoke(itemInstance);
//            Object health = item.getMethod("getHealth").invoke(itemInstance);
//            Object strength = item.getMethod("getStrength").invoke(itemInstance);
//
//            System.out.println(job + "\n" + health + "\n" + strength);
//            System.out.println();
//        }
//    }
}
