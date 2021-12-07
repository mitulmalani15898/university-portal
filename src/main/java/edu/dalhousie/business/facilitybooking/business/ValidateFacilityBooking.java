package edu.dalhousie.business.facilitybooking.business;

import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.databse.IGetAllUsers;

import java.util.List;

public class ValidateFacilityBooking implements IValidateFacilityBooking {
    @Override
    public boolean isValidUsername(String username) {
        IGetAllUsers users = FacilityBookingFactory.getInstance().getGetAllUsers();
        List<String> usernames = users.getAllUsers();
        return usernames.contains(username);
    }
}
