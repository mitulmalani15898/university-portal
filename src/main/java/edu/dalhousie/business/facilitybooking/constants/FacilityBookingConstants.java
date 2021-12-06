package edu.dalhousie.business.facilitybooking.constants;

import java.util.HashMap;
import java.util.Map;

public class FacilityBookingConstants {
    public static final Map<Integer, String> facilities = new HashMap<Integer, String>() {
        {
            put(1, "swimming");
            put(2, "badminton");
            put(3, "table tennis");
            put(4, "gym");
        }
    };
    public static final String serviceTitle = "Facility booking";
    public static final String availableFacilityTitle = "Availability for ";
    public static final String enterUsername = "Enter your username:";
    public static final String provideValidUsername = "\nPlease provide valid username.";
    public static final String enterChoiceForFacility = "Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)";
    public static final String provideValidChoice = "Please provide valid choice.";

    public static final String facilityIdColumn = "facility_id";
    public static final String facilityNameColumn = "facility_name";
    public static final String facilityAvailableDateColumn = "available_date";
    public static final String facilityAvailableTimeColumn = "available_time";
    public static final String facilityAvailableSlotsColumn = "available_slots";

    public static final String usernameColumn = "user_name";

    public static final String selectAllUsersQuery = "SELECT * from tableName";

    public static final String selectFacilityAvailabilityQuery = "SELECT * from tableName WHERE facility_name='facilityName'";
}


