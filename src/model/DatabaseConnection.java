package model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {
        Properties prop = new Properties();
        try (InputStream input = DatabaseConnection.class.getClassLoader().getResourceAsStream("config.properties")) {
            System.out.println("Connecting to Database...");
            if (input != null) {
                prop.load(input);

                DriverManager.setLoginTimeout(3);
                System.out.println("Successfully Connected to Database.");

                return DriverManager.getConnection(
                        prop.getProperty("db.url"),
                        prop.getProperty("db.user"),
                        prop.getProperty("db.password")
                );
            } else {
                System.out.println("Error: config.properties not found!");
            }
        } catch (Exception ex) {
            System.out.println("Database Connection Failed: " + ex.getMessage());
        }
        return  null;
    }
}
