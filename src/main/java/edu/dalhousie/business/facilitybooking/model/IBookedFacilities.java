package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public interface IBookedFacilities {
    public List<Facility> getBookedFacilities();

    public void setBookedFacilities(List<Facility> bookedFacilities);
}
