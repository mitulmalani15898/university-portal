package edu.dalhousie.business;

import edu.dalhousie.models.RoommateFinderObject;

import java.util.ArrayList;
import java.util.List;

public class RoommateFinderBusiness {

    public List<String> filterData(RoommateFinderObject roommateFinderObject, List<String> matches) {
        List<String> filteredMatches = new ArrayList<>();

        if(matches.contains(roommateFinderObject.getUserName())){
            System.out.println(roommateFinderObject.getUserName());
            matches.remove(roommateFinderObject.getUserName());
        }

        for(String match: matches) {
            filteredMatches.add(match);
        }
        return filteredMatches;
    }
}
