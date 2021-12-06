package edu.dalhousie.business.facilitybooking.model;

public interface IFacility {
    public int getFacilityId();

    public void setFacilityId(int facilityId);

    public String getFacilityName();

    public void setFacilityName(String facilityName);

    public String getAvailableDate();

    public void setAvailableDate(String availableDate);

    public String getAvailableTime();

    public void setAvailableTime(String availableTime);

    public int getAvailableSlots();

    public void setAvailableSlots(int availableSlots);
}
