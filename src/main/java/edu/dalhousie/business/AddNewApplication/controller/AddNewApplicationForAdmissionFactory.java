package edu.dalhousie.business.AddNewApplication.controller;

import edu.dalhousie.business.AddNewApplication.constants.StringConstants;

import java.sql.SQLException;

public class AddNewApplicationForAdmissionFactory {

    public static IAddNewApplicationForAdmission createAddNewApplicationForAdmission(String addNewApplicationForAdmission) throws SQLException {

        IAddNewApplicationForAdmission newApplicationForAdmission = null;

        if (addNewApplicationForAdmission == null) {
            return null;
        } else if (addNewApplicationForAdmission.equals(StringConstants.kAddNewApplication)) {
            newApplicationForAdmission = new AddNewApplicationForAdmission();
        }

        return newApplicationForAdmission;

    }
}
