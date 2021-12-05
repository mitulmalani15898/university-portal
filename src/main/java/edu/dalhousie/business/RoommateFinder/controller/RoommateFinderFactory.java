package edu.dalhousie.business.RoommateFinder.controller;

import edu.dalhousie.business.AddNewApplication.constants.StringConstants;

public class RoommateFinderFactory {

    public static IRoommateFinder getRoommateFinder(String roommateFinder) {

        IRoommateFinder roommate = null;

        if(roommateFinder == null) {
            return null;
        } else if (roommateFinder == StringConstants.kRoommateFinder) {
            roommate = new RoommateFinder();
        }

        return roommate;

    }
}
