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

    public static final String AVAILABLE = "Available";
    public static final String BOOKED = "Booked";

    public static final String FACILITY_BOOKING = "Facility booking";
    public static final String AVAILABILITY_FOR = "Availability for ";
    public static final String ENTER_YOUR_USERNAME = "Enter your username:";
    public static final String PLEASE_PROVIDE_VALID_USERNAME = "\nPlease provide valid username.";
    public static final String ENTER_CHOICE_FOR_FACILITY = "Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)";
    public static final String PLEASE_PROVIDE_VALID_CHOICE = "Please provide valid choice.";

    public static final String FACILITY_ID_COLUMN = "facility_id";
    public static final String FACILITY_NAME_COLUMN = "facility_name";
    public static final String FACILITY_AVAILABLE_DATE_COLUMN = "available_date";
    public static final String FACILITY_AVAILABLE_TIME_COLUMN = "available_time";
    public static final String FACILITY_AVAILABLE_SLOTS_COLUMN = "available_slots";

    public static final String USER_NAME = "user_name";

    public static final String SELECT_ALL_USERS_QUERY = "SELECT * from tableName";

    public static final String SELECT_FACILITY_AVAILABILITY_QUERY = "SELECT * from tableName WHERE facility_name='facilityName'";
}


