package src.db;

import java.sql.*;
import java.util.*;

public class DB {
    Config config;

    private List<?> cells;

    public DB () {
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

    public void getHeroes() throws SQLException {
        System.out.println();
        System.out.println("______");
        System.out.println("HEROES");
        System.out.println("‾‾‾‾‾‾");
        System.out.println();

        String req = "SELECT    h.type, " +
                "               h.health, " +
                "               h.strength," +
                "               os.category AS os_cat, " +
                "               os.name AS os_name, " +
                "               os.stat AS os_stat, " +
                "               ds.category AS ds_cat, " +
                "               ds.name AS ds_name, " +
                "               ds.stat AS ds_stat " +
                "FROM           hero h " +
                "JOIN           off_stuff os ON h.off_stuff_id = os.id " +
                "JOIN           def_stuff ds ON h.def_stuff_id = ds.id";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

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

        getConnection().close();
    }

    public void getPlayer(String uuid) throws SQLException {
        System.out.println();
        System.out.println("______");
        System.out.println("PLAYER");
        System.out.println("‾‾‾‾‾‾");
        System.out.println();

        String req = "SELECT    p.name, " +
                "               p.type, " +
                "               p.health, " +
                "               p.strength," +
                "               os.category AS os_cat, " +
                "               os.name AS os_name, " +
                "               os.stat AS os_stat, " +
                "               ds.category AS ds_cat, " +
                "               ds.name AS ds_name, " +
                "               ds.stat AS ds_stat " +
                "FROM           player p " +
                "JOIN           off_stuff os ON p.off_stuff_id = os.id " +
                "JOIN           def_stuff ds ON p.def_stuff_id = ds.id " +
                "WHERE          p.id = '" + uuid + "'";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

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

        getConnection().close();
    }

    public void setPlayer(String name, String type) throws SQLException {
        UUID uuid = UUID.randomUUID();

        String req = "INSERT INTO   player (id, name, type, health, strength, off_stuff_id, def_stuff_id) " +
                "SELECT '" +        uuid + "', '" +
                                    name + "', " +
                "                   type, " +
                "                   health, " +
                "                   strength, " +
                "                   off_stuff_id, " +
                "                   def_stuff_id " +
                "FROM               hero " +
                "WHERE              type = '" + type + "'";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }

    public String getName(String uuid) throws SQLException {
        String req = "SELECT    name " +
                "FROM           player " +
                "WHERE          id = '" + uuid + "'";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

        while (res.next()) {
            getConnection().close();

            return res.getString("name").toLowerCase();
        }

        getConnection().close();

        return null;
    }

    public void setName(String uuid, String name) throws SQLException {
        String req = "UPDATE    player " +
                "SET            name = '" + name + "' " +
                "WHERE          id = '" + uuid + "'";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }

    public String getType(String uuid) throws SQLException {
        String req = "SELECT    type " +
                "FROM           player " +
                "WHERE          id = '" + uuid + "'";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

        while (res.next()) {
            getConnection().close();

            return res.getString("type").toLowerCase();
        }

        getConnection().close();

        return null;
    }

    public void setType(String uuid, String type) throws SQLException {
        String req = "UPDATE    player " +
                "SET            type = (SELECT type FROM hero WHERE type = '" + type + "'), " +
                "               health = (SELECT health FROM hero WHERE type = '" + type + "'), " +
                "               strength = (SELECT strength FROM hero WHERE type = '" + type + "'), " +
                "               off_stuff_id = (SELECT off_stuff_id FROM hero WHERE type = '" + type + "'), " +
                "               def_stuff_id = (SELECT def_stuff_id FROM hero WHERE type = '" + type + "') " +
                "WHERE          id = '" + uuid + "'";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }

    public String getHealth(String uuid) throws SQLException {
        String req = "SELECT    health " +
                "FROM           player " +
                "WHERE          id = '" + uuid + "'";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

        while (res.next()) {
            getConnection().close();

            return res.getString("health").toLowerCase();
        }

        getConnection().close();

        return null;
    }

    public void setHealth(String uuid, int health) throws SQLException {
        String req = "UPDATE    player " +
                "SET            health = '" + health + "'" +
                "WHERE          id = '" + uuid + "'";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }

    public String getStrength(String uuid) throws SQLException {
        String req = "SELECT    strength " +
                "FROM           player " +
                "WHERE          id = '" + uuid + "'";

        ResultSet res = getConnection().prepareStatement(req).executeQuery();

        while (res.next()) {
            getConnection().close();

            return res.getString("strength").toLowerCase();
        }

        getConnection().close();

        return null;
    }

    public void setStrength(String uuid, int strength) throws SQLException {
        String req = "UPDATE    player " +
                "SET            strength = '" + strength + "'" +
                "WHERE          id = '" + uuid + "'";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }


    public void setCells() throws SQLException {
        Random random = new Random();
        List<String> uuids = new ArrayList<>();

        String[] reqs = {
                "SELECT id, name FROM enemy",
                "SELECT id, name FROM def_stuff",
                "SELECT id, name FROM off_stuff",
                "SELECT id, name FROM potion"
        };

        try (Statement statement = getConnection().createStatement()) {
            for (String req: reqs) {
                try(ResultSet resultSet = statement.executeQuery(req)){
                    while (resultSet.next()) {
                        // if name == "maxi potion"
                        // loop x times
                        uuids.add(resultSet.getString("id"));
                    }
                }
            }
        }

        System.out.println(uuids);

//
//        for (int i = 0; i < 10; i++) {
//            if (i < 2) {
//                items.add(Fireball.class);
//                items.add(MaxiPotion.class);
//            }
//
//            if (i < 4) {
//                items.add(Dragon.class);
//                items.add(MithrilSword.class);
//            }
//
//            if (i < 5) {
//                items.add(IronMass.class);
//                items.add(Lightning.class);
//            }
//
//            if (i < 6) {
//                items.add(MiniPotion.class);
//            }
//
//            if (i < 10) {
//                items.add(Goblin.class);
//                items.add(Necromancer.class);
//            }
//        }
//
//        Collections.shuffle(items);
//
//        for (Class<?> item : items) {
//            int i;
//
//            do {
//                i = random.nextInt(getSize());
//            }
//            while (cells.get(i) != null);
//            {
//                Object itemInstance = item.getDeclaredConstructor().newInstance();
//
//                cells.set(i, (Cell) itemInstance);
//            }
//        }
//
//        for (int i = 0; i < cells.size(); i++) {
//            if (cells.get(i) == null) {
//                Class<?> itemClass = Class.forName("src.board.cell.EmptyCell");
//                Constructor<?> constructor = itemClass.getDeclaredConstructor();
//                Object itemInstance = constructor.newInstance();
//
//                cells.set(i, (Cell) itemInstance);
//            }
//        }
    }

    public List<?> getCells() {
        return cells;
    }




    public void setGameboard(String uuidPlayer, List cells) throws SQLException {
        UUID uuid = UUID.randomUUID();

        String req = "INSERT INTO   gameboard ('" + uuid + "', '" + cells + "', '" + uuidPlayer + "')";

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(req);
        }

        getConnection().close();
    }



//    public UUID getUuid() {
//        UUID uuid = UUID.randomUUID();
//
//        return uuid;
//    }
}
