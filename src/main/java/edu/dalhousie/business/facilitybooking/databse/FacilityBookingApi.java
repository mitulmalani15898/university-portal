package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.FacilityBookingModel;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FacilityBookingApi {
    private static DatabaseConnection databaseConnection;
    FacilityBookingModel facilityBookingModel;

    public FacilityBookingApi() {
        facilityBookingModel = new FacilityBookingModel();
    }

    public List<Facility> makeFacilityListFromResultSet(ResultSet resultSet) {
        List<Facility> facilitySlots = new ArrayList<>();
        try {
            while (resultSet.next()) {
                Facility facility = new Facility();
                facility.setFacilityId(resultSet.getInt("facility_id"));
                facility.setFacilityName(resultSet.getString("facility_name"));
                facility.setAvailableDate(resultSet.getString("available_date"));
                facility.setAvailableTime(resultSet.getString("available_time"));
                facility.setAvailableSlots(resultSet.getInt("available_slots"));
                facilitySlots.add(facility);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return facilitySlots;
    }

    public void getFacilityAvailability(String facility) {
        databaseConnection = DatabaseConnectivity.getInstance();
        String query = String.format("SELECT * from %s WHERE facility_name='%s'", Constants.FacilitiesTable, facility);
        try {
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Facility> facilitySlots = makeFacilityListFromResultSet(resultSet);
            facilityBookingModel.setFacilitySlots(facilitySlots);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }
}
