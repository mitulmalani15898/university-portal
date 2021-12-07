package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.databse.IGetFacilityAvailability;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IAvailableFacilitySlots;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.PrintHeading;

public class FacilityBooking implements IFacilityBooking {
    public void renderFacilityAvailability(String facility) {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IGetFacilityAvailability facilityAvailability = FacilityBookingFactory.getInstance().getGetFacilityAvailability();
        IAvailableFacilitySlots facilitySlots = FacilityBookingFactory.getInstance().getAvailableFacilitySlots();

        facilityAvailability.getFacilityAvailability(facility);

        view.showFormattedMessage("\n%40s\n", FacilityBookingConstants.AVAILABILITY_FOR.concat(facility).toUpperCase());
        view.showFormattedMessage("%8s %10s %13s %16s %6s\n", "ID", "Date", "Time", "Availability", "Slots");
        int count = 0;
        for (Facility slot : facilitySlots.getFacilitySlots()) {
            String counter = ++count + "";
            String facilityId = slot.getFacilityId() + "";
            String availableDate = slot.getAvailableDate();
            String availableTime = slot.getAvailableTime();
            String availableOrNot = slot.getAvailableSlots() > 0 ? FacilityBookingConstants.AVAILABLE : FacilityBookingConstants.BOOKED;
            String availableSlots = slot.getAvailableSlots() + "";

            view.showFormattedMessage("%s. %4s | %12s | %9s | %12s | %4s\n", counter, facilityId, availableDate, availableTime, availableSlots, availableOrNot);
        }
    }

    public void bookFacilityForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        String facilityChoice = "";

        view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
        facilityChoice = view.getString();

        while (!facilityChoice.equals("1") && !facilityChoice.equals("2") && !facilityChoice.equals("3") && !facilityChoice.equals("4")) {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_CHOICE);
            view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
            facilityChoice = view.getString();
        }
        facilityChoice = FacilityBookingConstants.facilities.get(Integer.parseInt(facilityChoice));
        renderFacilityAvailability(facilityChoice);
    }

    public void renderFacilityBookingForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidateFacilityBooking validateFacilityBooking = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        String username = "";

        view.showMessage(FacilityBookingConstants.ENTER_YOUR_USERNAME);
        username = view.getString();

        if (validateFacilityBooking.isValidUsername(username)) {
            bookFacilityForm();
        } else {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_USERNAME);
        }
    }

    public void startFacilityBookingService() {
        PrintHeading.printHeadingForTheScreen(FacilityBookingConstants.FACILITY_BOOKING, 42);
        renderFacilityBookingForm();
    }
}
