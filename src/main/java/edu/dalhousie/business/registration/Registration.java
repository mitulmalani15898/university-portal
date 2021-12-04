package edu.dalhousie.business.registration;

import edu.dalhousie.controllers.WelcomeClass;
import edu.dalhousie.database.RegistrationApi;
import edu.dalhousie.models.RegistrationModel;
import edu.dalhousie.presentation.RegistrationView;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

public class Registration {
    StudentView view;
    WelcomeClass welcome;
    RegistrationModel registrationModel;
    RegistrationView registrationView;
    RegistrationApi registrationApi;

    public Registration() {
        view = new StudentView();
        welcome = new WelcomeClass();
        registrationModel = new RegistrationModel();
        registrationView = new RegistrationView();
        registrationApi = new RegistrationApi();
    }

    private String createUsername(String firstName, String lastName) {
        return firstName + "." + lastName;
    }

    public void registerUser(String typeOfRegistration) throws Exception {
        int userChoice;
        boolean isStudent = typeOfRegistration.equals("student");

        String title = isStudent ? "Register as a student" : "Register as a faculty";

        Utility.printHeadingForTheScreen(title, 38);

        registrationView.renderRegistrationForm(registrationModel);
        registrationModel.setUsername(createUsername(registrationModel.getFirstName(), registrationModel.getLastName()));
        registrationModel.setTypeOfUser(isStudent ? "student" : "faculty");

        view.showMessage("\nVerifying your details...");
        int result = registrationApi.saveUserDetails(registrationModel);
        System.out.println("result: " + result);
        if (result == 1) {
            view.showMessage("Details verified...\n");
            view.showMessage("Your username is \"" + registrationModel.getUsername() + "\".");
            view.showMessage("\nPlease login using your username and password to access your portal.\n");
        } else {
            view.showMessage("Something went wrong, please try again...\n");
        }

        view.showMessage("Press '0' to go back");
        userChoice = view.getInt();
        if (userChoice == 0) {
            welcome.displayWelcomeScreen();
        }
    }
}
