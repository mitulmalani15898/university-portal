package edu.dalhousie.database;
import java.sql.*;
public class DatabaseConnectivity {
    private Connection connection = null;
    public void connectWithDataBase() throws Exception {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager
                    .getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_9_DEVINT"
                            ,"CSCI5308_9_DEVINT_USER","zoDooSheupaefau1");

            System.out.println("DATABASE CONNECTIVITY ESTABLISHED");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            connection.close();
        }

    }

}
