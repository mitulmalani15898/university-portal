package edu.dalhousie.business.viewprofile.controller;

import edu.dalhousie.business.registration.business.ValidatePassword;
import edu.dalhousie.business.viewprofile.constants.ViewProfileConstants;
import edu.dalhousie.business.viewprofile.database.IUpdateProfileConnection;
import edu.dalhousie.business.viewprofile.database.IViewProfileConnection;
import edu.dalhousie.business.viewprofile.model.IViewProfileModel;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.Hashing;
import edu.dalhousie.utilities.PrintHeading;

public class ViewProfile implements IViewProfile {
    Hashing performHashing;
    ValidatePassword validatePassword;
    IStudentView view = StudentViewFactory.getInstance().getStudentView();
    IViewProfileModel viewProfileModel = ViewProfileFactory.initialize().getViewProfileModel();
    IViewProfileConnection viewProfileConnection = ViewProfileFactory.initialize().getViewProfileConnection();
    IUpdateProfileConnection updateProfileConnection = ViewProfileFactory.initialize().getUpdateProfileConnection();

    public ViewProfile() {
        performHashing = new Hashing();
        validatePassword = new ValidatePassword();
    }

    public void displayAndEditProfile() {
        try {
            viewProfileConnection.executeViewTable();

            view.showMessage(ViewProfileConstants.updateOption);
            String choice = view.getString();
            if (choice.equalsIgnoreCase("Yes")) {

                view.showMessage(ViewProfileConstants.enterFirstName);
                viewProfileModel.setFirstName(view.getString());
                updateProfileConnection.executeUpdateProfile("first_name", viewProfileModel.getFirstName());

                view.showMessage(ViewProfileConstants.enterLastName);
                viewProfileModel.setLastName(view.getString());
                updateProfileConnection.executeUpdateProfile("last_name", viewProfileModel.getFirstName());

                view.showMessage(ViewProfileConstants.enterContactNumber);
                viewProfileModel.setContactNumber(view.getString());
                updateProfileConnection.executeUpdateProfile("contact_number", viewProfileModel.getContactNumber());

                view.showMessage(ViewProfileConstants.enterPassword);
                String password = view.getString();

                if (!password.equalsIgnoreCase("No")) {
                    while (!password.isEmpty() && validatePassword.isInvalidPassword(password)) {
                        view.showMessage(ViewProfileConstants.enterPassword);
                        password = view.getString();
                    }
                }

                view.showMessage(ViewProfileConstants.enterVerifyPassword);
                String verifyPassword = view.getString();

                while (!verifyPassword.equals(password)) {
                    view.showMessage(ViewProfileConstants.enterVerifyPasswordAgain);
                    verifyPassword = view.getString();
                }

                if (!password.equalsIgnoreCase("No") && !verifyPassword.equalsIgnoreCase("No")) {
                    String hashed_password = performHashing.doPasswordHashing(password);
                    updateProfileConnection.executeUpdateProfile("password", hashed_password);
                }

                view.showMessage(ViewProfileConstants.enterDateOfBirth);
                viewProfileModel.setDateOfBirth(view.getString());
                updateProfileConnection.executeUpdateProfile("dob", viewProfileModel.getDateOfBirth());

                view.showMessage(ViewProfileConstants.enterGender);
                viewProfileModel.setGender(view.getString());
                updateProfileConnection.executeUpdateProfile("gender", viewProfileModel.getGender());

                view.showMessage(ViewProfileConstants.enterAddress);
                viewProfileModel.setStreetAddress(view.getString());
                updateProfileConnection.executeUpdateProfile("address", viewProfileModel.getStreetAddress());

                view.showMessage(ViewProfileConstants.enterApartmentNumber);
                viewProfileModel.setApartmentNumber(view.getString());
                updateProfileConnection.executeUpdateProfile("apartment_number", viewProfileModel.getApartmentNumber());

                view.showMessage(ViewProfileConstants.enterCity);
                viewProfileModel.setCity(view.getString());
                updateProfileConnection.executeUpdateProfile("city", viewProfileModel.getCity());

                view.showMessage(ViewProfileConstants.enterProvince);
                viewProfileModel.setProvince(view.getString());
                updateProfileConnection.executeUpdateProfile("province", viewProfileModel.getProvince());

                view.showMessage(ViewProfileConstants.enterZipCode);
                viewProfileModel.setZipcode(view.getString());
                updateProfileConnection.executeUpdateProfile("zip_code", viewProfileModel.getZipcode());

                view.showMessage(ViewProfileConstants.updating);
                view.showMessage(ViewProfileConstants.updated);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewProfilePage(String typeOfLogIn) {
        boolean isStudent = typeOfLogIn.equals("student");
        String title = isStudent ? "View Student Profile" : "View Faculty Profile";
        PrintHeading.printHeadingForTheScreen(title, 38);
        displayAndEditProfile();
    }

}
