package edu.dalhousie.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteQuery {

    private Connection connection = null;
    private Statement statement = null;

    public ExecuteQuery() {
        try {
            connection = DatabaseConnectivity.getInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // INSERT, UPDATE, DELETE
    public int executeSQL(String query) throws SQLException {
        int result = 0;
        try {
            result = statement.executeUpdate(query); //insert, update, delete
        } catch (SQLException sqlException) {
            connection.close();
        }
        return result;
    }

    // SELECT
    public ResultSet executeUpdateSQL(String query) throws SQLException {
        ResultSet resultSet = null;
        try {
            resultSet= statement.executeQuery(query); //retrieve - select
        } catch (SQLException sqlException) {
            connection.close();
        }
        return resultSet;
    }
}
