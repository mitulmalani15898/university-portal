package edu.dalhousie.business;

import edu.dalhousie.database.UsersApi;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacilityBookingBusiness {
    public boolean isValidUsername(String username) throws Exception {
        UsersApi usersApi = new UsersApi();
        List<String> usernames = new ArrayList<>();
        ResultSet resultSet = usersApi.getAllUsers();
        while (resultSet.next()) {
            usernames.add(resultSet.getString("user_name"));
        }
        return usernames.contains(username);
    }
}
