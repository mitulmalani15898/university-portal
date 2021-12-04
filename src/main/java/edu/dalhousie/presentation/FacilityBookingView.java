package edu.dalhousie.presentation;

import edu.dalhousie.business.FacilityBookingBusiness;
import edu.dalhousie.database.FacilityBookingApi;

import java.util.HashMap;
import java.util.Map;

public class FacilityBookingView {
    StudentView view;
    FacilityBookingBusiness facilityBookingBusiness;
    FacilityBookingApi facilityBookingApi;
    Map<Integer, String> facilities = new HashMap<Integer, String>() {
        {
            put(1, "swimming");
            put(2, "badminton");
            put(3, "table tennis");
            put(4, "gym");
        }
    };

    public FacilityBookingView() {
        view = new StudentView();
        facilityBookingBusiness = new FacilityBookingBusiness();
        facilityBookingApi = new FacilityBookingApi();
    }

    public void bookFacilityForm() {
        String facilityChoice = "";
        System.out.println("Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)");
        facilityChoice = view.getString();
        while (!facilityChoice.equals("1") && !facilityChoice.equals("2") && !facilityChoice.equals("3") && !facilityChoice.equals("4")) {
            System.out.println("Please provide valid choice.");
            System.out.println("Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)");
            facilityChoice = view.getString();
        }
        facilityChoice = facilities.get(Integer.parseInt(facilityChoice));

    }

    public void renderFacilityBookingForm() throws Exception {
        String username = "";
        System.out.println("Enter your username:");
        username = view.getString();
        if (facilityBookingBusiness.isValidUsername(username)) {
            bookFacilityForm();
        } else {
            System.out.println("\nPlease provide valid username.");
        }
    }
}
