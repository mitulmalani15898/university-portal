package edu.dalhousie.business.registration.business;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePassword {
    public boolean isInvalidPassword(String password) {
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }
}
