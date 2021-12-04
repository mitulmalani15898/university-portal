package edu.dalhousie.database;

import edu.dalhousie.utilities.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersApi {
    ExecuteQuery executeQuery;

    public UsersApi() {
        executeQuery = new ExecuteQuery();
    }

    public ResultSet getAllUsers() throws SQLException {
        String query = "SELECT * from " + Constants.UsersTable;
        ResultSet resultSet = executeQuery.executeUpdateSQL(query);
        return resultSet;
    }
}
