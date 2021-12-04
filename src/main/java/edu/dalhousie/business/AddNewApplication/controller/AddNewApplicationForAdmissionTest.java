package edu.dalhousie.business.AddNewApplication.controller;

import edu.dalhousie.business.AddNewApplication.business.AddNewApplicationForAdmissionBusiness;
import edu.dalhousie.business.AddNewApplication.model.AddNewApplicationFormObject;
import edu.dalhousie.constants.StringConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AddNewApplicationForAdmissionTest {

    @Test
    public void testApplicationApproval() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        AddNewApplicationForAdmissionBusiness addNewApplicationForAdmissionBusiness = new AddNewApplicationForAdmissionBusiness(addNewApplicationFormObject);
        addNewApplicationFormObject.setCourse("macs");
        addNewApplicationFormObject.setEducation("2");
        addNewApplicationFormObject.setUniversity("iit");
        addNewApplicationFormObject.setGpa("8.0");
        addNewApplicationFormObject.setTenthMarks("90");
        addNewApplicationFormObject.setTwelfthMarks("70");
        addNewApplicationFormObject.setIELTS("7.5");
        addNewApplicationFormObject.setGRE("340");
        addNewApplicationFormObject.setResearchPapers("5");
        addNewApplicationFormObject.setWorkExp("4");
        addNewApplicationFormObject.setGMAT("600");
        addNewApplicationFormObject.setGATE("80");

        String result = addNewApplicationForAdmissionBusiness.computeResult();
        assertEquals(StringConstants.kApplicationApproved, result);
    }

    @Test
    public void testApplicationDenial() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        AddNewApplicationForAdmissionBusiness addNewApplicationForAdmissionBusiness = new AddNewApplicationForAdmissionBusiness(addNewApplicationFormObject);
        addNewApplicationFormObject.setCourse("macs");
        addNewApplicationFormObject.setEducation("2");
        addNewApplicationFormObject.setUniversity("iit");
        addNewApplicationFormObject.setGpa("8.0");
        addNewApplicationFormObject.setTenthMarks("90");
        addNewApplicationFormObject.setTwelfthMarks("30");
        addNewApplicationFormObject.setIELTS("7.5");
        addNewApplicationFormObject.setGRE("340");
        addNewApplicationFormObject.setResearchPapers("5");
        addNewApplicationFormObject.setWorkExp("4");
        addNewApplicationFormObject.setGMAT("600");
        addNewApplicationFormObject.setGATE("80");

        String result = addNewApplicationForAdmissionBusiness.computeResult();
        assertEquals(StringConstants.kApplicationDenied, result);
    }


}