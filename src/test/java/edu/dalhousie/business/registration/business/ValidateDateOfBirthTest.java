package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateDateOfBirthTest {
    @Test
    public void checkWhetherValidateDateOfBirthExist() {
        assertNotNull(new ValidateDateOfBirth());
    }

    @Test
    public void testDateOfBirth() {
        ValidateDateOfBirth validate = new ValidateDateOfBirth();
        String validDateOfBirth = "08-08-1998";
        boolean isInvalidDateOFBirth = validate.isInvalidDateOfBirth(validDateOfBirth);
        assertTrue(isInvalidDateOFBirth == false);
    }

    @Test
    public void shouldNotContainSlash() {
        ValidateDateOfBirth validate = new ValidateDateOfBirth();
        String invalidDateOfBirth = "08/08/1998";
        boolean isInvalidDateOFBirth = validate.isInvalidDateOfBirth(invalidDateOfBirth);
        assertTrue(isInvalidDateOFBirth == true);
    }

    @Test
    public void shouldNotContainAlphabets() {
        ValidateDateOfBirth validate = new ValidateDateOfBirth();
        String invalidDateOfBirth = "abcdefghi";
        boolean isInvalidDateOFBirth = validate.isInvalidDateOfBirth(invalidDateOfBirth);
        assertTrue(isInvalidDateOFBirth == true);
    }
}
