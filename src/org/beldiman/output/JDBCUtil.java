package org.beldiman.output;

import org.beldiman.exceptions.OutputException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

     private static String url = "jdbc:mysql://localhost:3306/stef_test";
    private static String user = "root";
    private static String password = "admin";
    public static Connection getConnection() throws OutputException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new OutputException("Connection error");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) throws OutputException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new OutputException("Error closing database");
        }
    }
}
