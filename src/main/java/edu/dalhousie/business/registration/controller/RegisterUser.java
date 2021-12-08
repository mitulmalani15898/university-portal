package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.database.ISaveUser;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

public class RegisterUser implements IRegisterUser {
    @Override
    public void saveUserIntoDatabase() {
        IStudentView view = StudentView.getInstance();
        ISaveUser saveUser = RegistrationFactory.getInstance().getSaveUser();
        IUser user = RegistrationFactory.getInstance().getUser();

        view.showMessage(RegistrationConstants.VERIFYING_YOUR_DETAILS);
        if (saveUser.saveUserDetails() == 1) {
            view.showMessage(RegistrationConstants.DETAILS_VERIFIED);
            view.showMessage(RegistrationConstants.YOUR_USERNAME.replace("userName", user.getUsername()));
            view.showMessage(RegistrationConstants.PLEASE_LOGIN);
        } else {
            view.showMessage(RegistrationConstants.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN);
        }
    }
}
