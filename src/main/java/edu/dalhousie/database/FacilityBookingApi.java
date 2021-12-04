package edu.dalhousie.database;

import edu.dalhousie.models.Facility;
import edu.dalhousie.models.FacilityBookingModel;
import edu.dalhousie.utilities.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityBookingApi {
    ExecuteQuery executeQuery;
    FacilityBookingModel facilityBookingModel;

    public FacilityBookingApi() {
        executeQuery = new ExecuteQuery();
        facilityBookingModel = new FacilityBookingModel();
    }

    public List<Facility> makeFacilityListFromResulSet(ResultSet resultSet) throws SQLException {
        List<Facility> facilitySlots = new ArrayList<>();
        while (resultSet.next()) {
            Facility facility = new Facility();
            facility.setFacilityId(resultSet.getInt("facility_id"));
            facility.setFacilityName(resultSet.getString("facility_name"));
            facility.setAvailableDate(resultSet.getString("available_date"));
            facility.setAvailableTime(resultSet.getString("available_time"));
            facility.setAvailableSlots(resultSet.getInt("available_slots"));
            facilitySlots.add(facility);
        }
        return facilitySlots;
    }

    public void getFacilityAvailability(String facility) throws SQLException {
        String query = String.format("SELECT * from %s WHERE facility_name='%s'", Constants.FacilitiesTable, facility);
        ResultSet resultSet = executeQuery.executeUpdateSQL(query);
        List<Facility> facilitySlots = makeFacilityListFromResulSet(resultSet);
        facilityBookingModel.setFacilitySlots(facilitySlots);
    }
}
