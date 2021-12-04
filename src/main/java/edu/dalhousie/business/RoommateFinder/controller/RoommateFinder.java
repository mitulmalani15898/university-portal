package edu.dalhousie.business.RoommateFinder.controller;

import edu.dalhousie.business.RoommateFinder.business.IRoommateFinderBusiness;
import edu.dalhousie.business.RoommateFinder.business.RoommateFinderBusiness;
import edu.dalhousie.business.RoommateFinder.data.IRoommateFinderData;
import edu.dalhousie.business.RoommateFinder.data.RoommateFinderData;
import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObject;
import edu.dalhousie.business.RoommateFinder.constants.StringConstants;
import edu.dalhousie.presentation.StudentView;

import java.util.List;

public class RoommateFinder implements IRoommateFinder{

    StudentView view;
    RoommateFinderObject roommateFinderObject;
    IRoommateFinderData roommateFinderData;
    IRoommateFinderBusiness roommateFinderBusiness;

    public RoommateFinder() {
        view = new StudentView();
        roommateFinderObject = new RoommateFinderObject();
        roommateFinderData = new RoommateFinderData();
        roommateFinderBusiness = new RoommateFinderBusiness();
    }

    public void displayForm() throws Exception {
        view.showMessage(StringConstants.kGender);
        int gender = view.getInt();
        boolean genderVerified = roommateFinderBusiness.verifyGender(gender);
        if (!genderVerified) {
            while(!genderVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kGender);
                gender = view.getInt();
                genderVerified = roommateFinderBusiness.verifyGender(gender);
            }
        }
        view.showMessage(String.valueOf(gender));
        roommateFinderObject.setGender(gender);

        view.showMessage(StringConstants.kFood);
        int food = view.getInt();
        boolean foodVerified = roommateFinderBusiness.verifyFood(food);
        if (!foodVerified) {
            while(!foodVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kFood);
                food = view.getInt();
                foodVerified = roommateFinderBusiness.verifyGender(food);
            }
        }
        view.showMessage(String.valueOf(food));
        roommateFinderObject.setFoodPreference(food);

        view.showMessage(StringConstants.kGenderPreference);
        int genderPreference = view.getInt();
        boolean genderPreferenceVerified = roommateFinderBusiness.verifyGenderPreference(genderPreference);
        if (!genderPreferenceVerified) {
            while(!genderPreferenceVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kGenderPreference);
                genderPreference = view.getInt();
                genderPreferenceVerified = roommateFinderBusiness.verifyGenderPreference(genderPreference);
            }
        }
        view.showMessage(String.valueOf(genderPreference));
        roommateFinderObject.setGenderPreference(genderPreference);

        view.showMessage(StringConstants.kHobbies);
        roommateFinderObject.setHobbies(view.getString());

        view.showMessage(StringConstants.kCampus);
        int campus = view.getInt();
        boolean campusVerified = roommateFinderBusiness.verifyCampus(campus);
        if (!campusVerified) {
            while(!campusVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kCampus);
                campus = view.getInt();
                campusVerified = roommateFinderBusiness.verifyCampus(campus);
            }
        }
        view.showMessage(String.valueOf(campus));
        roommateFinderObject.setCampusPreference(campus);

        view.showMessage(StringConstants.kAccomodation);
        int accomodation = view.getInt();
        boolean accomodationVerified = roommateFinderBusiness.verifyAccomodation(accomodation);
        if (!accomodationVerified) {
            while(!accomodationVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kAccomodation);
                accomodation = view.getInt();
                accomodationVerified = roommateFinderBusiness.verifyAccomodation(accomodation);
            }
        }
        view.showMessage(String.valueOf(accomodation));
        roommateFinderObject.setAccomodationPreference(accomodation);

        roommateFinderData.storeData(roommateFinderObject);

        // TODO - username!=current (take from preferences)
        List<String> matches = roommateFinderData.retrieveData(roommateFinderObject);
        List<String> filteredMatches = roommateFinderBusiness.filterData(roommateFinderObject, matches);

        view.showMessage(StringConstants.kLoading);
        view.showMessage(StringConstants.kSuggestions);

        for(String match: filteredMatches) {
            view.showMessage(match);
        }
    }
}