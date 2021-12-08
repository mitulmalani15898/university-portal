package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.Constants;
import edu.dalhousie.utilities.PrintHeading;

public class FacilityBooking implements IFacilityBooking {
    public static String userName = "";

    public void renderFacilityBookingForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidateFacilityBooking validateFacilityBooking = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookFacilityForm bookFacilityForm = FacilityBookingFactory.getInstance().getBookFacilityForm();
        String username = "";

        view.showMessage(FacilityBookingConstants.ENTER_YOUR_USERNAME);
        username = view.getString();
        if (validateFacilityBooking.isValidUsername(username)) {
            userName = username;
            bookFacilityForm.renderFacilityForm();
        } else {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_USERNAME);
        }
    }

    public void startFacilityBookingService() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();

        PrintHeading.printHeadingForTheScreen(FacilityBookingConstants.FACILITY_BOOKING, 42);
        renderFacilityBookingForm();

        System.out.println(Constants.PRESS_ENTER_TO_GO_BACK);
        view.getString();
    }
}
