package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    private static final String PASSWORD_KEY = "12345678";
    private static final String USERNAME_KEY = "postgres";
    private static final String URL_KEY = "jdbc:postgresql://localhost:5432/TVprogram";


    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("java.sql.Driver");
            connection = DriverManager.getConnection(URL_KEY, USERNAME_KEY, PASSWORD_KEY);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Error");
        }
        return connection;

    }
}