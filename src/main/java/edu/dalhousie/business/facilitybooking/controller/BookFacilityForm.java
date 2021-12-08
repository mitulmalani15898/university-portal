package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class BookFacilityForm implements IBookFacilityForm {
    @Override
    public void bookFacilityForm() {
        IStudentView view = StudentView.getInstance();
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookValidFacility bookValidFacility = FacilityBookingFactory.getInstance().getBookValidFacility();
        String facilityId = "";

        view.showMessage(FacilityBookingConstants.ENTER_ID_FROM_LIST);
        facilityId = view.getString();
        while (validate.isInvalidFacilityId(facilityId)) {
            view.showMessage(FacilityBookingConstants.ENTER_VALID_ID_FROM_LIST);
            facilityId = view.getString();
        }
        bookValidFacility.bookFacility(Integer.parseInt(facilityId));
    }

    @Override
    public void renderFacilityForm() {
        IStudentView view = StudentView.getInstance();
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IShowFacilityAvailability showFacility = FacilityBookingFactory.getInstance().getShowFacilityAvailability();
        String facilityChoice = "";

        view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
        facilityChoice = view.getString();
        while (validate.isInvalidFacilityChoice(facilityChoice)) {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_CHOICE);
            view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
            facilityChoice = view.getString();
        }
        facilityChoice = FacilityBookingConstants.facilities.get(Integer.parseInt(facilityChoice));
        showFacility.renderFacilityAvailability(facilityChoice);
        bookFacilityForm();
    }
}
