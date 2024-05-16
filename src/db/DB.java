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
    }

    public void createHero(Connection db, String type, String name) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {
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
                PreparedStatement statement = db.prepareStatement(req);

                statement.setString(1, (String) job);
                statement.setString(2, name.toUpperCase());
                statement.setInt(3, (Integer) health);
                statement.setInt(4, (Integer) strength);
                statement.setString(5, (String) offStuffName);
                statement.setString(6, (String) defStuffName);

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("Successful insertion!");
                } else {
                    System.out.println("no line inserted");
                }

                break;
            }
        }

        db.close();
    }

    public void editHero(Connection db, int id, String name) throws SQLException {
        String req = "UPDATE hero SET name = ? WHERE id = ?";

        PreparedStatement statement = db.prepareStatement(req);
        statement.setString(1, (String) name.toUpperCase());
        statement.setInt(2, (Integer) id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Successful update!");
        } else {
            System.out.println("no updated");
        }

        db.close();
    }

    public void editHealth(Connection db, int id, int health) throws SQLException {
        String req = "UPDATE hero SET health = ? WHERE id = ?";

        PreparedStatement statement = db.prepareStatement(req);
        statement.setInt(1, (Integer) health);
        statement.setInt(2, (Integer) id);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Successful update!");
        } else {
            System.out.println("no updated");
        }

        db.close();
    }
}
