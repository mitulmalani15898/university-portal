package edu.dalhousie.database;
import java.sql.*;
public class DatabaseConnectivity {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    public void connectWithDataBase() throws Exception {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager
                    .getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_9_DEVINT"
                            ,"CSCI5308_9_DEVINT_USER","zoDooSheupaefau1");

            System.out.println("DATABASE CONNECTIVITY ESTABLISHED");

            statement = connection.createStatement();
            resultSet = statement
                    .executeQuery("select * from test");
            showResultSet(resultSet);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            connection.close();
        }

    }

    private void showResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
    }
}
