/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.database;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnectivity implements DatabaseConnection{

    private static final String DATABASE_CONFIG_FILE = "./database.properties";
    private Connection connection = null;
    private static DatabaseConnectivity databaseConnectivity;
    private DatabaseConnectivity(){

    }
    public static DatabaseConnectivity getInstance(){
            if(databaseConnectivity==null){
                databaseConnectivity = new DatabaseConnectivity();
            }
            return databaseConnectivity;
    }
    public Connection connectWithDataBase() throws DatabaseException{
        try(final InputStream inputStream = new FileInputStream(DATABASE_CONFIG_FILE)) {
            final Properties ConfigProperties = new Properties();
            ConfigProperties.load(inputStream);
            Class.forName(ConfigProperties.getProperty("JDBCDriver"))
                    .getDeclaredConstructor().newInstance();
            final String databaseType = ConfigProperties.getProperty("databaseType");
            connection = DriverManager
                    .getConnection(ConfigProperties.getProperty("databaseURL")
                            +ConfigProperties.getProperty(databaseType+"Database")
                            ,ConfigProperties.getProperty(databaseType+"Username"),
                            ConfigProperties.getProperty(databaseType+"Password"));

            return connection;

        } catch (Exception e) {
            throw new DatabaseException(e.getMessage(),e);
        }

    }
    @Override
    public Connection getDatabaseConnection() throws DatabaseException {
        clearDatabaseConnection();
        connection = connectWithDataBase();
        return connection;
    }

    @Override
    public void clearDatabaseConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            connection = null;
        }
    }


}
