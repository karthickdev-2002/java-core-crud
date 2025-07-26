package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/schooldb";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456789";

    public static Connection getConnection() throws SQLException {
    	 try {
             Class.forName("org.postgresql.Driver"); // Load driver
             return DriverManager.getConnection(URL, USER, PASSWORD);
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
    }
}
