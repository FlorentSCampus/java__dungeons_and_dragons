package src.db;

import src.player.job.Warrior;
import src.player.job.Wizard;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB {
    Config config;
    List<Class<?>> classes = new ArrayList<>();

    public DB() {
        this.config = new Config();
    }

    public void getConnection() {
        System.out.println(config.getURL());
        try (Connection connection = DriverManager.getConnection(config.getURL(), config.getUSERNAME(), config.getPWD())) {
            System.out.println("Connexion réussie à la base de données MySQL!");
            // Vous pouvez maintenant utiliser la connexion pour exécuter des requêtes SQL
            // Par exemple :
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("SELECT * FROM ma_table");
            // Traitez les résultats...
        } catch (SQLException e) {
            System.out.println("La connexion à la base de données a échoué!");
        }
    }

    public void getHero() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        classes.add(Warrior.class);
        classes.add(Wizard.class);

        for(Class<?> item : classes) {
            Object itemInstance = item.getDeclaredConstructor().newInstance();

            Object job = item.getMethod("getPlayerJob").invoke(itemInstance);
            Object health = item.getMethod("getHealth").invoke(itemInstance);
            Object strength = item.getMethod("getStrength").invoke(itemInstance);

            System.out.println(job + "\n" + health + "\n" + strength);
            System.out.println();
        }
    }

    public void createHero() {

    }

    public void editHero() {

    }

    public void editHealth(int health) {

    }
}
