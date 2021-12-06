package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.business.ValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.databse.GetAllUsers;
import edu.dalhousie.business.facilitybooking.databse.GetFacilityAvailability;
import edu.dalhousie.business.facilitybooking.databse.IGetAllUsers;
import edu.dalhousie.business.facilitybooking.databse.IGetFacilityAvailability;
import edu.dalhousie.business.facilitybooking.model.*;

public class FacilityBookingFactory {
    private static FacilityBookingFactory facilityBookingFactory = null;

    IFacilityBooking facilityBooking;
    IValidateFacilityBooking validateFacilityBooking;
    IGetAllUsers getAllUsers;
    IGetFacilityAvailability getFacilityAvailability;
    IFacility facility;
    IAvailableFacilitySlots availableFacilitySlots;
    IBookedFacilities bookedFacilities;

    public FacilityBookingFactory() {
        facilityBooking = new FacilityBooking();
        validateFacilityBooking = new ValidateFacilityBooking();
        getAllUsers = new GetAllUsers();
        getFacilityAvailability = new GetFacilityAvailability();
        facility = new Facility();
        availableFacilitySlots = new AvailableFacilitySlots();
        bookedFacilities = new BookedFacilities();
    }

    public static FacilityBookingFactory getInstance() {
        if (facilityBookingFactory == null) {
            facilityBookingFactory = new FacilityBookingFactory();
        }
        return facilityBookingFactory;
    }

    public IFacilityBooking getFacilityBooking() {
        return facilityBooking;
    }

    public IValidateFacilityBooking getValidateFacilityBooking() {
        return validateFacilityBooking;
    }

    public IGetAllUsers getGetAllUsers() {
        return getAllUsers;
    }

    public IGetFacilityAvailability getGetFacilityAvailability() {
        return getFacilityAvailability;
    }

    public IFacility getFacility() {
        return facility;
    }

    public IAvailableFacilitySlots getAvailableFacilitySlots() {
        return availableFacilitySlots;
    }

    public IBookedFacilities getBookedFacilities() {
        return bookedFacilities;
    }
}
