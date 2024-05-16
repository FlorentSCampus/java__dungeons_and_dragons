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
                String type = resultSet.getString("type").toUpperCase();
                String name = resultSet.getString("name").toUpperCase();
                int health = resultSet.getInt("health");
                int strength = resultSet.getInt("strength");
                String offStuff = resultSet.getString("off_stuff").toUpperCase();
                String defStuff = resultSet.getString("def_stuff").toUpperCase();

                System.out.println("Id: " + id);
                System.out.println("Type: " + type);
                System.out.println("Name: " + name);
                System.out.println("Health: " + health);
                System.out.println("Strength: " + strength);
                System.out.println("Off stuff: " + offStuff);
                System.out.println("Def stuff: " + defStuff);
                System.out.println();
            }

            db.close();
        } catch (SQLException e) {
            System.out.println("Failed connection to database!");
        }
    }

    public void createHero(Connection db, String type, String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        classes.add(Warrior.class);
        classes.add(Wizard.class);

        String req = "INSERT INTO hero (type, name, health, strength, off_stuff, def_stuff) VALUES (?, ?, ?, ?, ?, ?)";

        for (Class<?> item : classes) {
            Object itemInstance = item.getDeclaredConstructor().newInstance();
            Object job = item.getMethod("getPlayerJob").invoke(itemInstance);
            Object health = item.getMethod("getHealth").invoke(itemInstance);
            Object strength = item.getMethod("getStrength").invoke(itemInstance);

            Object defStuff = item.getMethod("getDefensiveStuff").invoke(itemInstance);
            Object defStuffName = defStuff.getClass().getMethod("getName").invoke(defStuff);

            Object offStuff = item.getMethod("getOffensiveStuff").invoke(itemInstance);
            Object offStuffName = offStuff.getClass().getMethod("getName").invoke(offStuff);

            if (type.toUpperCase().equals(job)) {
                try {
                    PreparedStatement statement = db.prepareStatement(req);

                    statement.setString(1, (String) job);
                    statement.setString(2, name.toUpperCase());
                    statement.setInt(3, (Integer) health);
                    statement.setInt(4, (Integer) strength);
                    statement.setString(5, (String) offStuffName);
                    statement.setString(6, (String) defStuffName);

                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("Successful insertion !");
                    } else {
                        System.out.println("no line inserted");
                    }
                } catch (SQLException e) {
                    System.out.println("Failed to database insertion");
                }

                break;
            }
//            Object itemInstance = item.getDeclaredConstructor().newInstance();
//
//            Object job = item.getMethod("getPlayerJob").invoke(itemInstance);
//            Object health = item.getMethod("getHealth").invoke(itemInstance);
//            Object strength = item.getMethod("getStrength").invoke(itemInstance);
//
//            System.out.println(job + "\n" + health + "\n" + strength);
//            System.out.println();
        }
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
