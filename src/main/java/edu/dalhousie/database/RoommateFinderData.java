package edu.dalhousie.database;

import edu.dalhousie.models.RoommateFinderObject;

import java.sql.SQLException;

public class RoommateFinderData {

    public void storeData(RoommateFinderObject roommateFinderObject) throws SQLException {
        String userName = "";
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();

        ExecuteQuery executeQuery = new ExecuteQuery();
        String query = "insert into roommates " + " values ('"+ "vignesh2" +"', '" + campus+ "', '" + accomodation+ "', '" +genderPreference+ "', '"+foodPreference+"', '"+hobbies+"')";
        executeQuery.executeSQL(query);
    }
}
