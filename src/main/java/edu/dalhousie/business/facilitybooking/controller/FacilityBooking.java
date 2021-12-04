package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.databse.FacilityBookingApi;
import edu.dalhousie.business.facilitybooking.FacilityBookingView;
import edu.dalhousie.business.facilitybooking.model.FacilityBookingModel;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.utilities.PrintHeading;

public class FacilityBooking {
    FacilityBookingView facilityBookingView;
    FacilityBookingModel facilityBookingModel;
    FacilityBookingApi facilityBookingApi;

    public FacilityBooking() {
        facilityBookingModel = new FacilityBookingModel();
        facilityBookingView = new FacilityBookingView();
        facilityBookingApi = new FacilityBookingApi();
    }

    public void startFacilityBookingService() throws Exception {
        StudentMainClass studentMainClass = new StudentMainClass();
        PrintHeading.printHeadingForTheScreen("Facility booking", 42);
        facilityBookingView.renderFacilityBookingForm();
        studentMainClass.displayStudentMenu();
    }
}
