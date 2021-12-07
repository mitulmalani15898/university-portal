package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.AvailableFacilitySlots;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetFacilityAvailability implements IGetFacilityAvailability {
    private static DatabaseConnection databaseConnection;
    AvailableFacilitySlots facilityBookingModel;

    public GetFacilityAvailability() {
        facilityBookingModel = new AvailableFacilitySlots();
    }

    @Override
    public void getFacilityAvailability(String facilityName) {
        String query = FacilityBookingConstants.selectFacilityAvailabilityQuery
            .replace("tableName", Constants.FacilitiesTable)
            .replace("facilityName", facilityName);

        try {
            databaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = databaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Facility> facilitySlots = new ArrayList<>();
            while (resultSet.next()) {
                Facility facility = new Facility();
                facility.setFacilityId(resultSet.getInt(FacilityBookingConstants.facilityIdColumn));
                facility.setFacilityName(resultSet.getString(FacilityBookingConstants.facilityNameColumn));
                facility.setAvailableDate(resultSet.getString(FacilityBookingConstants.facilityAvailableDateColumn));
                facility.setAvailableTime(resultSet.getString(FacilityBookingConstants.facilityAvailableTimeColumn));
                facility.setAvailableSlots(resultSet.getInt(FacilityBookingConstants.facilityAvailableSlotsColumn));
                facilitySlots.add(facility);
            }
            facilityBookingModel.setFacilitySlots(facilitySlots);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(GetFacilityAvailability.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
    }
}
