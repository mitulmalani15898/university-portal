package edu.dalhousie.business.facilitybooking;

import edu.dalhousie.business.facilitybooking.business.FacilityBookingBusiness;
import edu.dalhousie.business.facilitybooking.databse.FacilityBookingApi;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.FacilityBookingModel;
import edu.dalhousie.presentation.StudentView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityBookingView {
    StudentView view;
    FacilityBookingBusiness facilityBookingBusiness;
    FacilityBookingApi facilityBookingApi;
    FacilityBookingModel facilityBookingModel;

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
        facilityBookingModel = new FacilityBookingModel();
    }

    public void renderFacilityAvailability(String facility) throws Exception {
        facilityBookingApi.getFacilityAvailability(facility);
        List<Facility> facilitySlots = facilityBookingModel.getFacilitySlots();
        String title = "Availability for " + facility;
        System.out.format("\n%25s\n", title.toUpperCase());
        System.out.format("%-10s %-10s %-10s %-10s %-10s\n", "ID", "Date", "Time", "Availability", "Slots");
        int count = 0;
        for (Facility slot : facilitySlots) {
            System.out.format("%s.  %-10s | %-10s | %-10s | %-10s\n", ++count, slot.getFacilityId(), slot.getAvailableDate(), slot.getAvailableTime(), slot.getAvailableSlots());
        }
    }

    public void bookFacilityForm() throws Exception {
        String facilityChoice = "";
        System.out.println("Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)");
        facilityChoice = view.getString();
        while (!facilityChoice.equals("1") && !facilityChoice.equals("2") && !facilityChoice.equals("3") && !facilityChoice.equals("4")) {
            System.out.println("Please provide valid choice.");
            System.out.println("Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)");
            facilityChoice = view.getString();
        }
        facilityChoice = facilities.get(Integer.parseInt(facilityChoice));
        renderFacilityAvailability(facilityChoice);
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
