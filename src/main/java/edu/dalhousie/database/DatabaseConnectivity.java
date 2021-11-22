package edu.dalhousie.database;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class DatabaseConnectivity {

    private static DatabaseConnectivity dbInstance;
    private static Connection connection;

    private DatabaseConnectivity() {

    }

    public static DatabaseConnectivity getInstance() {
        if (dbInstance == null) {
            dbInstance = new DatabaseConnectivity();
        }
        return dbInstance;
    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                String host = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_9_DEVINT";
                String username = "CSCI5308_9_DEVINT_USER";
                String password = "zoDooSheupaefau1";
                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            connection = DriverManager
                    .getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_9_DEVINT"
                            ,"CSCI5308_9_DEVINT_USER","zoDooSheupaefau1");
                connection = DriverManager.getConnection( host, username, password );
            } catch (SQLException | ClassNotFoundException | NoSuchMethodException ex) {
                System.out.println(ex);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }
}