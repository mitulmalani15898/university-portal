package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.IUserType;
import edu.dalhousie.business.registration.business.IUsername;
import edu.dalhousie.business.registration.business.IValidatePassword;
import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.database.ISaveUser;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentViewFactory;
import edu.dalhousie.utilities.Hashing;
import edu.dalhousie.utilities.PrintHeading;

public class Registration implements IRegistration {
    public void renderRegistrationForm() {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        IValidatePassword validatePassword = RegistrationFactory.getInstance().getValidatePassword();
        IUser user = RegistrationFactory.getInstance().getUser();

        String password = "", confirmPassword = "", gender = "";

        view.showMessage(RegistrationConstants.ENTER_FIRST_NAME);
        user.setFirstName(view.getString());

        view.showMessage(RegistrationConstants.ENTER_LAST_NAME);
        user.setLastName(view.getString());

        view.showMessage(RegistrationConstants.ENTER_EMAIL);
        user.setEmail(view.getString());

        view.showMessage(RegistrationConstants.ENTER_CONTACT_NUMBER);
        user.setContactNumber(view.getString());

        view.showMessage(RegistrationConstants.ENTER_PASSWORD);
        password = view.getString();
        while (!password.isEmpty() && validatePassword.isInvalidPassword(password)) {
            view.showMessage(RegistrationConstants.ENTER_PASSWORD);
            password = view.getString();
        }
        user.setPassword(password);

        view.showMessage(RegistrationConstants.ENTER_CONFIRM_PASSWORD);
        confirmPassword = view.getString();
        while (!confirmPassword.equals(password)) {
            view.showMessage(RegistrationConstants.VALID_CONFIRM_PASSWORD);
            confirmPassword = view.getString();
        }
        user.setConfirmPassword(confirmPassword);
        user.setPassword(Hashing.doPasswordHashing(password));

        view.showMessage(RegistrationConstants.ENTER_DOB);
        user.setDateOfBirth(view.getString());

        view.showMessage(RegistrationConstants.ENTER_GENDER);
        gender = RegistrationConstants.genders.get(view.getString());
        user.setGender(gender);

        view.showMessage(RegistrationConstants.ENTER_STREET_ADDRESS);
        user.setStreetAddress(view.getString());

        view.showMessage(RegistrationConstants.ENTER_APARTMENT_NUMBER);
        user.setApartmentNumber(view.getString());

        view.showMessage(RegistrationConstants.ENTER_CITY);
        user.setCity(view.getString());

        view.showMessage(RegistrationConstants.ENTER_PROVINCE);
        user.setProvince(view.getString());

        view.showMessage(RegistrationConstants.ENTER_ZIPCODE);
        user.setZipcode(view.getString());
    }

    @Override
    public void registerUser(String typeOfUser) {
        IStudentView view = StudentViewFactory.getInstance().getStudentView();
        ISaveUser saveUser = RegistrationFactory.getInstance().getSaveUser();
        IUsername username = RegistrationFactory.getInstance().getUsername();
        IUser user = RegistrationFactory.getInstance().getUser();
        IUserType userType = RegistrationFactory.getInstance().getUserType();

        boolean isStudent = userType.isStudent(typeOfUser);

        String title = isStudent ? RegistrationConstants.REGISTER_AS_A_STUDENT : RegistrationConstants.REGISTER_AS_A_FACULTY;
        PrintHeading.printHeadingForTheScreen(title, 38);

        renderRegistrationForm();
        user.setUsername(username.createUsername(user.getFirstName(), user.getLastName()));
        user.setTypeOfUser(isStudent ? RegistrationConstants.STUDENT : RegistrationConstants.FACULTY);

        view.showMessage(RegistrationConstants.VERIFYING_YOUR_DETAILS);
        if (saveUser.saveUserDetails() == 1) {
            view.showMessage(RegistrationConstants.DETAILS_VERIFIED);
            view.showMessage(RegistrationConstants.YOUR_USERNAME.replace("username", user.getUsername()));
            view.showMessage(RegistrationConstants.PLEASE_LOGIN);
        } else {
            view.showMessage(RegistrationConstants.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN);
        }
    }
}
