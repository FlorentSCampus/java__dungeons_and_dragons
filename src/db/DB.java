package src.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DB {
    Config config;
    
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

    public void getHeroes(Connection db) throws SQLException {
        System.out.println();
        System.out.println("______");
        System.out.println("HEROES");
        System.out.println("‾‾‾‾‾‾");
        System.out.println();

        String req = "SELECT " +
                "h.type, " +
                "h.health, " +
                "h.strength," +
                "os.category AS os_cat, " +
                "os.name AS os_name, " +
                "os.stat AS os_stat, " +
                "ds.category AS ds_cat, " +
                "ds.name AS ds_name, " +
                "ds.stat AS ds_stat " +
                "FROM " +
                "hero h " +
                "JOIN " +
                "off_stuff os ON h.off_stuff_id = os.id " +
                "JOIN " +
                "def_stuff ds ON h.def_stuff_id = ds.id";

        ResultSet res = db.prepareStatement(req).executeQuery();

        while (res.next()) {
            String type = res.getString("type").toLowerCase();
            int health = res.getInt("health");
            int strength = res.getInt("strength");
            String offCat = res.getString("os_cat");
            String offName = res.getString("os_name");
            int offStat = res.getInt("os_stat");
            String defCat = res.getString("ds_cat");
            String defName = res.getString("ds_name");
            String defStat = res.getString("ds_stat");

            System.out.println("Type: " + type);
            System.out.println("Health: " + health);
            System.out.println("Strength: " + strength);
            System.out.println();
            System.out.println("OFF STUFF:\nCAT: " + offCat + ", NAME: " + offName + ", STAT: " + offStat);
            System.out.println("DEF STUFF:\nCAT: " + defCat + ", NAME: " + defName + ", STAT: " + defStat);
            System.out.println();
            System.out.println();
        }

        db.close();
    }

    public void getPlayer(Connection db, int player_id) throws SQLException {
        System.out.println();
        System.out.println("______");
        System.out.println("PLAYER");
        System.out.println("‾‾‾‾‾‾");
        System.out.println();

        String req = "SELECT " +
                "p.name, " +
                "p.type, " +
                "p.health, " +
                "p.strength," +
                "os.category AS os_cat, " +
                "os.name AS os_name, " +
                "os.stat AS os_stat, " +
                "ds.category AS ds_cat, " +
                "ds.name AS ds_name, " +
                "ds.stat AS ds_stat " +
                "FROM " +
                "player p " +
                "JOIN " +
                "off_stuff os ON p.off_stuff_id = os.id " +
                "JOIN " +
                "def_stuff ds ON p.def_stuff_id = ds.id " +
                "WHERE " +
                "p.id = " + player_id;

        ResultSet res = db.prepareStatement(req).executeQuery();

        while (res.next()) {
            String name = res.getString("name").toLowerCase();
            String type = res.getString("type").toLowerCase();
            int health = res.getInt("health");
            int strength = res.getInt("strength");
            String offCat = res.getString("os_cat");
            String offName = res.getString("os_name");
            int offStat = res.getInt("os_stat");
            String defCat = res.getString("ds_cat");
            String defName = res.getString("ds_name");
            String defStat = res.getString("ds_stat");

            System.out.println("Name: " + name);
            System.out.println("Type: " + type);
            System.out.println("Health: " + health);
            System.out.println("Strength: " + strength);
            System.out.println();
            System.out.println("OFF STUFF:\nCAT: " + offCat + ", NAME: " + offName + ", STAT: " + offStat);
            System.out.println("DEF STUFF:\nCAT: " + defCat + ", NAME: " + defName + ", STAT: " + defStat);
            System.out.println();
            System.out.println();
        }

        db.close();
    }

    public void setPlayer(Connection db, String name, String type) throws SQLException {

        String req = "INSERT INTO " +
                "hero (name, type, health, strength, off_stuff_id, def_stuff_id) " +
                "VALUES (" + name + ", " + type + ", ?, ?, ?, ?)";

        db.close();
    }

    public void editPlayer(Connection db, int id, String name) throws SQLException {
        String req = "UPDATE hero SET name = ? WHERE id = ?";

        PreparedStatement statement = db.prepareStatement(req);
        statement.setString(1, (String) name.toLowerCase());
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

    public void createGameboard(Connection db, int cellsCount) {
        // si plateau existe déjà
        // réinitialiser le plateau (id increament to 0)
        // sinon
        // créer nb de case = cellsCount
    }
}
