package edu.dalhousie.business.registration.business;

public class CreateUsername implements ICreateUsername {
    @Override
    public String createUsernameFromName(String firstName, String lastName) {
        return firstName + "." + lastName;
    }
}
