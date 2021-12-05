package edu.dalhousie.business.RoommateFinder.business;

import edu.dalhousie.business.RoommateFinder.model.RoommateFinderObjectModel;

import java.util.List;

public interface IFilterRoommates {
    public List<String> filterData(RoommateFinderObjectModel roommateFinderObject, List<String> matches);
}
