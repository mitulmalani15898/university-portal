package edu.dalhousie.business.facilitybooking;

import java.util.List;

public class FacilityBookingModel {
    private static List<Facility> facilitySlots;
    private static List<Facility> bookedFacilities;

    public List<Facility> getFacilitySlots() {
        return facilitySlots;
    }

    public void setFacilitySlots(List<Facility> facilitySlots) {
        FacilityBookingModel.facilitySlots = facilitySlots;
    }

    public List<Facility> getBookedFacilities() {
        return bookedFacilities;
    }

    public void setBookedFacilities(List<Facility> bookedFacilities) {
        FacilityBookingModel.bookedFacilities = bookedFacilities;
    }
}
