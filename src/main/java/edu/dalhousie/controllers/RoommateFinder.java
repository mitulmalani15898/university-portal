package edu.dalhousie.controllers;

import edu.dalhousie.business.RoommateFinderBusiness;
import edu.dalhousie.database.RoommateFinderData;
import edu.dalhousie.models.RoommateFinderObject;
import edu.dalhousie.presentation.StudentView;

import java.sql.SQLException;
import java.util.List;

public class RoommateFinder {
    String kFood = "1. Enter your food preference: (1. Veg, 2. Non-Veg, 3. No preference)";
    String kGender = "2. Enter your gender preference: (1. Male, 2. Female, 3. No preference)";
    String kHobbies = "3. Mention your hobbies: (eg. cooking, travelling, football) ";
    String kCampus = "4. Do you prefer staying on-campus or off-campus?: (1. Off-campus, 2. On-campus)";
    String kAccomodation = "5. Would you like to share the room? (1. Yes, 2. No)";
    String kPriority = "6. Enter the priority of the above questions on which you would like to consider your roommate: (eg. 23145)";
    String kLoading = "Finding your roommates..";
    String kSuggestions = "Here are the suggestions for roommates:";

    public void displayForm() throws SQLException {
        StudentView view = new StudentView();
        RoommateFinderObject roommateFinderObject = new RoommateFinderObject();
        RoommateFinderData roommateFinderData = new RoommateFinderData();
        RoommateFinderBusiness roommateFinderBusiness = new RoommateFinderBusiness();


        view.showMessage(kFood);
        roommateFinderObject.setFoodPreference(view.getInt());

        view.showMessage(kGender);
        roommateFinderObject.setGenderPreference(view.getInt());

        view.showMessage(kHobbies);
        roommateFinderObject.setHobbies(view.getString());

        view.showMessage(kCampus);
        roommateFinderObject.setCampusPreference(view.getInt());

        view.showMessage(kAccomodation);
        roommateFinderObject.setAccomodationPreference(view.getInt());

        view.showMessage(kPriority);
        roommateFinderObject.setPriority(view.getInt());

        roommateFinderData.storeData(roommateFinderObject);

        // TODO - username!=current (take from preferences)
        List<String> matches = roommateFinderData.retrieveData(roommateFinderObject);
        List<String> filteredMatches = roommateFinderBusiness.filterData(roommateFinderObject, matches);

        view.showMessage(kLoading);
        view.showMessage(kSuggestions);
        for(String match: filteredMatches) {
            view.showMessage(match);
        }
    }

}
