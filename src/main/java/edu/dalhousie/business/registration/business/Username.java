package edu.dalhousie.business.registration.business;

public class Username implements IUsername {
    @Override
    public String createUsername(String firstName, String lastName) {
        return firstName + "." + lastName;
    }
}
