package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.*;
import edu.dalhousie.business.registration.database.ISaveUser;
import edu.dalhousie.business.registration.database.SaveUser;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.business.registration.model.User;

public class RegistrationFactory {
    private static RegistrationFactory registrationFactory = null;

    IRegistration registration;
    IValidatePassword validatePassword;
    ISaveUser saveUser;
    IUser user;
    IUsername username;
    IUserType userType;

    public RegistrationFactory() {
        registration = new Registration();
        validatePassword = new ValidatePassword();
        saveUser = new SaveUser();
        user = new User();
        username = new Username();
        userType = new UserType();
    }

    public static RegistrationFactory getInstance() {
        if (registrationFactory == null) {
            registrationFactory = new RegistrationFactory();
        }
        return registrationFactory;
    }

    public IRegistration getRegistration() {
        return registration;
    }

    public IValidatePassword getValidatePassword() {
        return validatePassword;
    }

    public ISaveUser getSaveUser() {
        return saveUser;
    }

    public IUser getUser() {
        return user;
    }

    public IUsername getUsername() {
        return username;
    }

    public IUserType getUserType() {
        return userType;
    }
}
