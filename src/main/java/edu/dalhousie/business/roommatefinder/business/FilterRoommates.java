package edu.dalhousie.business.roommatefinder.business;

import edu.dalhousie.business.roommatefinder.constants.StringConstants;
import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;
import edu.dalhousie.controllers.UserSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterRoommates implements IFilterRoommates {
    UserSession userSession;

    public FilterRoommates() {
        userSession = UserSession.getInstance();
    }

    public List<String> filterData(RoommateFinderObjectModel roommateFinderObject, List<String> matches) {
        List<String> filteredMatches = new ArrayList<>();

        if(matches.contains(userSession.getUser().getUserName())){
            matches.removeAll(Arrays.asList(userSession.getUser().getUserName()));
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
