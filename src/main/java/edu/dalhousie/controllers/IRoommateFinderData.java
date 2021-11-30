package edu.dalhousie.controllers;

import edu.dalhousie.models.RoommateFinderObject;

import java.sql.SQLException;
import java.util.List;

public interface IRoommateFinderData {
    void storeData(RoommateFinderObject roommateFinderObject) throws SQLException;
    List<String> retrieveData(RoommateFinderObject roommateFinderObject) throws SQLException;
}
