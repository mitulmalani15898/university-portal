package edu.dalhousie.business.viewprofile.database;

import edu.dalhousie.business.viewprofile.controller.ViewProfileFactory;
import edu.dalhousie.business.viewprofile.model.IViewProfileModel;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateProfileConnection implements IUpdateProfileConnection {
    private DatabaseConnection databaseConnection;
    UserSession userSession;

    public UpdateProfileConnection() {
        this.databaseConnection = DatabaseConnectivity.getInstance();
        userSession = new UserSession();
    }

    public void executeUpdateProfile(String column_name, String update_value) {
        IViewProfileModel viewProfileModel = ViewProfileFactory.initialize().getViewProfileModel();
        viewProfileModel.setUserID(userSession.getUser().getUserName());

        if (!update_value.equalsIgnoreCase("No")) {
            try {
                final Connection connection =
                        databaseConnection.getDatabaseConnection();
                final Statement statement =
                        connection.createStatement();
                String SQL_Update = String.format("UPDATE users SET %s = '%s' WHERE user_name = '%s'", column_name, update_value, viewProfileModel.getUserID());
                statement.executeUpdate(SQL_Update);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
