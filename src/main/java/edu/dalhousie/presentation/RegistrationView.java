package edu.dalhousie.presentation;

import edu.dalhousie.models.RegistrationModel;

public class RegistrationView {
    StudentView view = new StudentView();

    public void renderRegistrationForm(RegistrationModel registrationModel) {
        System.out.print("Enter your first name: ");
        registrationModel.setFirstName(view.getString());

        System.out.print("Enter your last name: ");
        registrationModel.setLastName(view.getString());

        System.out.print("Enter your email address: ");
        registrationModel.setEmail(view.getString());

        System.out.print("Enter your contact number: ");
        registrationModel.setContactNumber(view.getString());

        System.out.print("Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ");
        registrationModel.setPassword(view.getString());

        System.out.print("Verify your Password: ");
        registrationModel.setConfirmPassword(view.getString());

        System.out.print("Enter your Date of Birth: (MM-DD-YYYY): ");
        registrationModel.setDateOfBirth(view.getString());

        System.out.print("Enter your gender (1: Male, 2: Female, 3: Other): ");
        registrationModel.setGender(view.getString());

        System.out.print("Enter your street address: ");
        registrationModel.setStreetAddress(view.getString());

        System.out.print("Enter your apartment number (if any): ");
        registrationModel.setApartmentNumber(view.getString());

        System.out.print("Enter your city: ");
        registrationModel.setCity(view.getString());

        System.out.print("Enter your province/state: ");
        registrationModel.setProvince(view.getString());

        System.out.print("Enter your zip code: ");
        registrationModel.setZipcode(view.getString());
    }
}
