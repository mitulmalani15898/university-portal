package edu.dalhousie.business.RoommateFinder.data;

import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IRoommateFinderData {
    void storeData(RoommateFinderObjectModel roommateFinderObject) throws SQLException;
    List<String> retrieveData(RoommateFinderObjectModel roommateFinderObject) throws SQLException;
}
