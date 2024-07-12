package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root"; // Cambia esto según tu configuración
    private static final String PASSWORD = ""; // Cambia esto según tu configuración

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC no encontrado. Asegúrate de que el JAR del driver JDBC está en el classpath.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Connection failed. Error: " + e.getMessage());
        }
        return conn;
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                   + " id INT AUTO_INCREMENT PRIMARY KEY,"
                   + " username VARCHAR(255) NOT NULL UNIQUE,"
                   + " password VARCHAR(255) NOT NULL"
                   + ");";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println("Table creation failed. Error: " + e.getMessage());
        }
    }
}
