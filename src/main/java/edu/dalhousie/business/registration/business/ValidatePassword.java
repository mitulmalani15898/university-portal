package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword implements IValidatePassword {
    @Override
    public boolean isInvalidPassword(String password) {
        Pattern pattern = Pattern.compile(RegistrationConstants.passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
}
