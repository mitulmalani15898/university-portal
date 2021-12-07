package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IPickFacility;
import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.databse.IBookFacility;
import edu.dalhousie.business.facilitybooking.databse.IUsersBookedFacilities;
import edu.dalhousie.business.facilitybooking.model.Facility;

public class BookValidFacility implements IBookValidFacility {
    public void showResultMessage(int result) {
        if (result == 1) {
            System.out.println(FacilityBookingConstants.BOOKING_SUCCESSFUL);
        } else {
            System.out.println(FacilityBookingConstants.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN);
        }
    }

    public void checkForSlotsConflicts(Facility facility) {
        int result = -1;
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookFacility bookFacilityApi = FacilityBookingFactory.getInstance().getBookFacility();

        if (validate.hasConflictWithBooking(facility)) {
            System.out.println(FacilityBookingConstants.ALREADY_BOOKED_SLOT);
        } else {
            result = bookFacilityApi.bookFacility(facility);
            showResultMessage(result);
        }
    }

    @Override
    public void bookFacility(int facilityId) {
        IPickFacility pickFacility = FacilityBookingFactory.getInstance().getPickFacility();
        IUsersBookedFacilities usersBookedFacilities = FacilityBookingFactory.getInstance().getUsersBookedFacilities();

        usersBookedFacilities.getBookedFacilitiesByUsername(FacilityBooking.userName);
        Facility facility = pickFacility.getFacilityById(facilityId);
        if (facility.getAvailableSlots() > 0) {
            checkForSlotsConflicts(facility);
        } else {
            System.out.println(FacilityBookingConstants.NO_SLOTS_AVAILABLE);
        }
    }
}
