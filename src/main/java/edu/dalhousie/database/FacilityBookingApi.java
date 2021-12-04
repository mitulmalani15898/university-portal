package edu.dalhousie.database;

import edu.dalhousie.utilities.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacilityBookingApi {
    ExecuteQuery executeQuery;

    public FacilityBookingApi() {
        executeQuery = new ExecuteQuery();
    }

    public void getFacilityAvailability(String facility) throws SQLException {
        String query = "SELECT * from " + Constants.FacilitiesTable + " WHERE facility_name=" + facility;
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while (rs.next()) {

        }
    }
}
