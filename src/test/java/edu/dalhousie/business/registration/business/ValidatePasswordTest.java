package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatePasswordTest {
    @Test
    public void checkWhetherValidatePasswordExist() {
        assertNotNull(new ValidatePassword());
    }

    @Test
    public void testPassword() {
        ValidatePassword validate = new ValidatePassword();
        String validPassword = "Mitul@123";
        boolean isInvalidPassword = validate.isInvalidPassword(validPassword);
        assertTrue(isInvalidPassword == false);
    }

    @Test
    public void shouldContainSmallCharacters() {
        ValidatePassword validate = new ValidatePassword();
        String invalidPassword = "MITUL@123";
        boolean isInvalidPassword = validate.isInvalidPassword(invalidPassword);
        assertTrue(isInvalidPassword == true);
    }

    @Test
    public void shouldContainCapitalCharacters() {
        ValidatePassword validate = new ValidatePassword();
        String invalidPassword = "mitul@123";
        boolean isInvalidPassword = validate.isInvalidPassword(invalidPassword);
        assertTrue(isInvalidPassword == true);
    }

    @Test
    public void shouldContainSpecialCharacters() {
        ValidatePassword validate = new ValidatePassword();
        String invalidPassword = "mitul123";
        boolean isInvalidPassword = validate.isInvalidPassword(invalidPassword);
        assertTrue(isInvalidPassword == true);
    }
}
