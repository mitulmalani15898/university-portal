package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.databse.IGetFacilityAvailability;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IAvailableFacilitySlots;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.PrintHeading;

import java.util.List;

public class FacilityBooking implements IFacilityBooking {
    public void renderFacilityAvailability(String facility) {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IGetFacilityAvailability facilityAvailability = FacilityBookingFactory.getInstance().getGetFacilityAvailability();
        IAvailableFacilitySlots facilitySlots = FacilityBookingFactory.getInstance().getAvailableFacilitySlots();
        facilityAvailability.getFacilityAvailability(facility);
        List<Facility> availableFacilitySlots = facilitySlots.getFacilitySlots();
        view.showFormattedMessage("\n%40s\n", FacilityBookingConstants.availableFacilityTitle.concat(facility).toUpperCase());
        view.showFormattedMessage("%8s %10s %13s %16s %6s\n", "ID", "Date", "Time", "Availability", "Slots");
        int count = 0;
        for (Facility slot : availableFacilitySlots) {
            String counter = ++count + "";
            String facilityId = slot.getFacilityId() + "";
            String availableDate = slot.getAvailableDate();
            String availableTime = slot.getAvailableTime();
            String availableSlots = slot.getAvailableSlots() + "";
            view.showFormattedMessage("%s. %4s | %12s | %9s | %8s\n", counter, facilityId, availableDate, availableTime, availableSlots);
        }
    }

    public void bookFacilityForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        String facilityChoice = "";
        view.showMessage(FacilityBookingConstants.enterChoiceForFacility);
        facilityChoice = view.getString();
        while (!facilityChoice.equals("1") && !facilityChoice.equals("2") && !facilityChoice.equals("3") && !facilityChoice.equals("4")) {
            view.showMessage(FacilityBookingConstants.provideValidChoice);
            view.showMessage(FacilityBookingConstants.enterChoiceForFacility);
            facilityChoice = view.getString();
        }
        facilityChoice = FacilityBookingConstants.facilities.get(Integer.parseInt(facilityChoice));
        renderFacilityAvailability(facilityChoice);
    }

    public void renderFacilityBookingForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidateFacilityBooking validateFacilityBooking = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        String username = "";
        view.showMessage(FacilityBookingConstants.enterUsername);
        username = view.getString();
        if (validateFacilityBooking.isValidUsername(username)) {
            bookFacilityForm();
        } else {
            view.showMessage(FacilityBookingConstants.provideValidUsername);
        }
    }

    public void startFacilityBookingService() {
        PrintHeading.printHeadingForTheScreen(FacilityBookingConstants.serviceTitle, 42);
        renderFacilityBookingForm();
    }
}
