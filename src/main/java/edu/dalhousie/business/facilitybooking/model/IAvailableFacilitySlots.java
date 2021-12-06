package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public interface IAvailableFacilitySlots {
    public List<Facility> getFacilitySlots();

    public void setFacilitySlots(List<Facility> facilitySlots);
}
