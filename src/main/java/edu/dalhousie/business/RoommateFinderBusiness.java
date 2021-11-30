package edu.dalhousie.business;

import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.models.RoommateFinderObject;

import java.util.ArrayList;
import java.util.List;

public class RoommateFinderBusiness {

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

    public List<String> filterData(RoommateFinderObject roommateFinderObject, List<String> matches) {
        List<String> filteredMatches = new ArrayList<>();

        if(matches.contains(roommateFinderObject.getUserName())){
            System.out.println(roommateFinderObject.getUserName());
            matches.remove(roommateFinderObject.getUserName());
        }

        if (matches.isEmpty()) {
            filteredMatches.add(StringConstants.kNoBuddies);
        } else {
            for (String match : matches) {
                filteredMatches.add(match);
            }
        }

        return filteredMatches;
    }
}
