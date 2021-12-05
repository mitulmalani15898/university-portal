package edu.dalhousie.business.RoommateFinder.business;
import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObjectModel;
import edu.dalhousie.business.RoommateFinder.constants.StringConstants;


import java.util.ArrayList;
import java.util.List;

public class ValidateRoommateFinder implements IValidateRoommateFinder {

    public boolean verifyGender(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }

    public boolean verifyFood(int input) {
        if (input == 1 || input == 2 || input == 3) {
            return true;
        }
        return false;
    }

    public boolean verifyGenderPreference(int input) {
        if (input == 1 || input == 2 || input == 3) {
            return true;
        }
        return false;
    }

    public boolean verifyCampus(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }

    public boolean verifyAccomodation(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }
}
