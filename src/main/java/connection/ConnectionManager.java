package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {
    private static final String PASSWORD_KEY = "12345678";
    private static final String USERNAME_KEY = "postgres";
    private static final String URL_KEY = "jdbc:postgresql://localhost:5432/TVprogram";

    private ConnectionManager() {

    }


    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("java.sql.Driver");
            conn = DriverManager.getConnection(
                    URL_KEY,
                    USERNAME_KEY,
                    PASSWORD_KEY
            );
            System.out.println("Connection OK");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
}