package edu.dalhousie.controllers;

import edu.dalhousie.database.FacilityBookingApi;
import edu.dalhousie.models.FacilityBookingModel;
import edu.dalhousie.presentation.FacilityBookingView;
import edu.dalhousie.utilities.Utility;

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
        Utility.printHeadingForTheScreen("Facility booking", 42);
        facilityBookingView.renderFacilityBookingForm();
        studentMainClass.displayStudentMenu();
    }
}
