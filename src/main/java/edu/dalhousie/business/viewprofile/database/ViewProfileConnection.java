package edu.dalhousie.business.viewprofile.database;

import edu.dalhousie.business.viewprofile.model.ViewProfileModel;
import edu.dalhousie.controllers.User;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewProfileConnection
{
    private DatabaseConnection databaseConnection;
    User userDetails;
    ViewProfileModel viewProfileModel;
    UserSession userSession;

    public ViewProfileConnection() {
        this.databaseConnection = DatabaseConnectivity.getInstance();
        userSession = UserSession.getInstance();
        viewProfileModel = new ViewProfileModel();
        viewProfileModel.setUserID(userSession.getUser().getUserName());
    }

    public void executeViewTable()
    {
        try
        {
            final Connection connection =
                    databaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            String SQL_View = String.format("SELECT * FROM users WHERE user_name = '%s'", viewProfileModel.getUserID());
            ResultSet rs_view = statement.executeQuery(SQL_View);

            while(rs_view.next()) {
                viewProfileModel.setUsername(rs_view.getString("user_name"));
                viewProfileModel.setFirstName(rs_view.getString("first_name"));
                viewProfileModel.setLastName(rs_view.getString("last_name"));
                viewProfileModel.setEmail(rs_view.getString("email_address"));
                viewProfileModel.setContactNumber(rs_view.getString("contact_number"));
                viewProfileModel.setDateOfBirth(rs_view.getString("dob"));
                viewProfileModel.setGender(rs_view.getString("gender"));
                viewProfileModel.setStreetAddress(rs_view.getString("address"));
                viewProfileModel.setApartmentNumber(rs_view.getString("apartment_number"));
                viewProfileModel.setCity(rs_view.getString("city"));
                viewProfileModel.setProvince(rs_view.getString("province"));
                viewProfileModel.setZipcode(rs_view.getString("zip_code"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void executeUpdateTable(String column_name, String update_value)
    {
        if (!update_value.equalsIgnoreCase("No"))
        {
            try {
                final Connection connection =
                        databaseConnection.getDatabaseConnection();
                final Statement statement =
                        connection.createStatement();
                String SQL_Update = String.format("UPDATE user SET %s = '%s' WHERE username = '%s'", column_name, update_value, viewProfileModel.getUserID());
                statement.executeUpdate(SQL_Update);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
