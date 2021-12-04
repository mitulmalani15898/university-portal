package edu.dalhousie.business.AddNewApplication.data;

import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormObject;

import java.sql.SQLException;

public interface IAddNewApplicationForAdmissionData {
    public void storeData(AddNewApplicationFormObject newApplication) throws SQLException;
    public void storeScore(AddNewApplicationFormObject newApplicationFormObject) throws SQLException;
}
