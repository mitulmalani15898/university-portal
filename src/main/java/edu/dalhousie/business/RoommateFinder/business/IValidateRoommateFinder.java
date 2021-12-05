package edu.dalhousie.business.RoommateFinder.business;

import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObjectModel;

import java.util.List;

public interface IValidateRoommateFinder {
    public boolean verifyGender(int input);
    public boolean verifyFood(int input);
    public boolean verifyGenderPreference(int input);
    public boolean verifyCampus(int input);
    public boolean verifyAccomodation(int input);
}