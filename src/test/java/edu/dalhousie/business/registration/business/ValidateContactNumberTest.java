package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateContactNumberTest {
    @Test
    public void checkWhetherValidateContactNumberExist() {
        assertNotNull(new ValidateContactNumberTest());
    }

    @Test
    public void testContactNumber() {
        ValidateContactNumber validate = new ValidateContactNumber();
        String validContactNumber = "1234567890";
        boolean isInvalidContactNumber = validate.isInvalidContactNumber(validContactNumber);
        assertTrue(isInvalidContactNumber == false);
    }

    @Test
    public void shouldHaveTenDigits() {
        ValidateContactNumber validate = new ValidateContactNumber();
        String invalidContactNumber = "123";
        boolean isInvalidContactNumber = validate.isInvalidContactNumber(invalidContactNumber);
        assertTrue(isInvalidContactNumber == true);
    }

    @Test
    public void shouldNotContainCharacters() {
        ValidateContactNumber validate = new ValidateContactNumber();
        String invalidContactNumber = "123AWS";
        boolean isInvalidContactNumber = validate.isInvalidContactNumber(invalidContactNumber);
        assertTrue(isInvalidContactNumber == true);
    }
}
