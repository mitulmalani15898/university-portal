package edu.dalhousie.database;

import edu.dalhousie.models.RoommateFinderObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoommateFinderData {

    public void storeData(RoommateFinderObject roommateFinderObject) throws SQLException {
        String userName = "";
        int gender = roommateFinderObject.getGender();
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();

        ExecuteQuery executeQuery = new ExecuteQuery();
        String query = "insert into roommates " + " values ('"+ "vignesh2" +"', '" + gender+ "', '" + campus+ "', '" + accomodation+ "', '" +genderPreference+ "', '"+foodPreference+"', '"+hobbies+"')";
        executeQuery.executeSQL(query);
    }

    public List<String> retrieveData(RoommateFinderObject roommateFinderObject) throws SQLException {
        List<String> matches = new ArrayList<>();

        String userName = "";
        int gender = roommateFinderObject.getGender();
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();

        ExecuteQuery executeQuery = new ExecuteQuery();
        String query = "select userName from roommates where genderpref = '" + gender + "' && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender = '" + genderPreference + "' && foodpref = '" + foodPreference + "' ";
        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while (rs.next()) {
            matches.add(rs.getString("userName"));
        }
        return matches;
    }
}
