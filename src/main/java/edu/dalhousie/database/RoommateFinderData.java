package edu.dalhousie.database;
import edu.dalhousie.controllers.IRoommateFinderData;
import edu.dalhousie.models.RoommateFinderObject;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoommateFinderData implements IRoommateFinderData {

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
        String query = "";

        int gender = roommateFinderObject.getGender();
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();


        ExecuteQuery executeQuery = new ExecuteQuery();
        if (foodPreference == 3) {
            if (genderPreference == 3) {
                query = "select userName from roommates where genderpref > 0 && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender > 0 && foodpref > 0 && hobbies LIKE '%" + hobbies + "%' ";
            }
            query = "select userName from roommates where genderpref = '" + gender + "' && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender = '" + genderPreference + "' && foodpref > 0 && hobbies LIKE '%" + hobbies + "%' ";
        } else if(genderPreference == 3) {
            query = "select userName from roommates where genderpref > 0 && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender>0 && foodpref = '" + foodPreference + "' && hobbies LIKE '%" + hobbies + "%' ";
        } else {
            query = "select userName from roommates where genderpref = '" + gender + "' && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender = '" + genderPreference + "' && foodpref = '" + foodPreference + "' && hobbies LIKE '%" + hobbies + "%' ";
        }


        ResultSet rs = executeQuery.executeUpdateSQL(query);
        while (rs.next()) {
            matches.add(rs.getString("userName"));
        }
        return matches;
    }
}
