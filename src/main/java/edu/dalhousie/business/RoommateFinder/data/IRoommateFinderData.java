package edu.dalhousie.business.RoommateFinder.data;

import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObject;

import java.sql.SQLException;
import java.util.List;

public interface IRoommateFinderData {
    void storeData(RoommateFinderObject roommateFinderObject) throws SQLException;
    List<String> retrieveData(RoommateFinderObject roommateFinderObject) throws SQLException;
}
