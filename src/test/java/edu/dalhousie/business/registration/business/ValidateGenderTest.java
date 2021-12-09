package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateGenderTest {
    @Test
    public void checkWhetherValidateGenderExist() {
        assertNotNull(new ValidateGender());
    }

    @Test
    public void testGender() {
        ValidateGender validate = new ValidateGender();
        String validEmail = "1";
        boolean isInvalidEmail = validate.isInvalidGender(validEmail);
        assertTrue(isInvalidEmail == false);
    }

    @Test
    public void shouldBeFromGivenListOnly() {
        ValidateGender validate = new ValidateGender();
        String validEmail = "2";
        boolean isInvalidEmail = validate.isInvalidGender(validEmail);
        assertEquals(isInvalidEmail, false);
    }

    @Test
    public void shouldNotContainAlphabates() {
        ValidateGender validate = new ValidateGender();
        String invalidEmail = "abcd";
        boolean isInvalidEmail = validate.isInvalidGender(invalidEmail);
        assertEquals(isInvalidEmail, true);
    }
}
