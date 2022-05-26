package com.beldiman.output;

import com.beldiman.exceptions.OutputException;
import org.tinylog.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBOutput implements OutputInt{

    public void createTables() throws OutputException {
        Connection connection = null;
        {
            try {
                connection = JDBCUtil.getConnection();
            } catch (OutputException e) {
                Logger.error("Connection error encountered.");
                System.exit(0);
            }
        }
        String operationTable = "CREATE TABLE IF NOT EXISTS operation" +
                "(operation_id INT auto_increment primary key, first_number INT NOT NULL," +
                "operand VARCHAR(10) NOT NULL, second_number INT NOT NULL, result DOUBLE NOT NULL, time_stamp TIMESTAMP)";

        String logTable = "CREATE TABLE IF NOT EXISTS log" +
                "(log_id INT auto_increment primary key, user VARCHAR(100)," +
                "operation_date TIMESTAMP, operation_id INT, " +
                "FOREIGN KEY (operation_id) references operation (operation_id))";
        try (
                PreparedStatement createTableOperation = connection.prepareStatement(operationTable);
                PreparedStatement createTableLog = connection.prepareStatement(logTable)) {
            createTableOperation.execute(operationTable);
            createTableLog.execute(logTable);

        }
        catch (SQLException e) {
            Logger.error("Error creating tables");
            throw new OutputException("Error creating tables");
        }
        JDBCUtil.closeConnection(connection);
        Logger.info("Tables created");

    }
    @Override
    public void outputResult(int firstNumber, char operand, int secondNumber, double result) throws OutputException {
        Connection connection = null;

        {
            try {
                connection = JDBCUtil.getConnection();
            } catch (OutputException e) {
                Logger.error("Connection error encountered.");
                System.exit(0);
            }
        }
        String insertOperation = "INSERT INTO operation" +
                "(first_number, operand, second_number, result, time_stamp)" +
                "VALUES(?, ?, ?, ?, now())";

        String insertLog = "INSERT INTO log " +
                "(user, operation_date, operation_id)" +
                "VALUES('Stefan', now(), LAST_INSERT_ID())";

        try (PreparedStatement insertIntoOperation = connection.prepareStatement(insertOperation)) {

            connection.setAutoCommit(false);
            insertIntoOperation.setInt(1, firstNumber);
            insertIntoOperation.setString(2, Character.toString(operand));
            insertIntoOperation.setInt(3, secondNumber);
            insertIntoOperation.setDouble(4, result);
            insertIntoOperation.executeUpdate();
            Logger.info("Operation table populated");


            try (PreparedStatement insertIntoLog = connection.prepareStatement(insertLog)) {
                insertIntoLog.executeUpdate();
                connection.commit();
            }
        }
        catch (SQLException e) {
            Logger.error("Error inserting operation");
            throw new OutputException("Error inserting operation");
        }
        JDBCUtil.closeConnection(connection);
        Logger.info("Tables operation and log populated with new input.");

    }

}

