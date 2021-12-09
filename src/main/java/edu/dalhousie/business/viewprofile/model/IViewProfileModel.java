package edu.dalhousie.business.viewprofile.model;

public interface IViewProfileModel {
    String getUsername();

    void setUsername(String username);

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getEmail();

    void setEmail(String email);

    String getContactNumber();

    void setContactNumber(String contactNumber);

    String getDateOfBirth();

    void setDateOfBirth(String dateOfBirth);

    String getGender();

    void setGender(String gender);

    String getStreetAddress();

    void setStreetAddress(String streetAddress);

    String getApartmentNumber();

    void setApartmentNumber(String apartmentNumber);

    String getCity();

    void setCity(String city);

    String getProvince();

    void setProvince(String province);

    String getZipcode();

    void setZipcode(String zipcode);

    String getUserID();

    void setUserID(String userID);
}
