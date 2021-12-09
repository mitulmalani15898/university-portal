package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidateEmailTest {
    @Test
    public void checkWhetherValidateEmailExist() {
        assertNotNull(new ValidateEmail());
    }

    @Test
    public void testEmail() {
        ValidateEmail validate = new ValidateEmail();
        String validEmail = "mitul@gmail.com";
        boolean isInvalidEmail = validate.isInvalidEmail(validEmail);
        assertTrue(isInvalidEmail == false);
    }

    @Test
    public void emailShouldNotBeEmpty() {
        ValidateEmail validate = new ValidateEmail();
        String validEmail = "";
        boolean isInvalidEmail = validate.isInvalidEmail(validEmail);
        assertTrue(isInvalidEmail == true);
    }

    @Test
    public void shouldContainDotAndAtSymbol() {
        ValidateEmail validate = new ValidateEmail();
        String validEmail = "mitulgmailcom";
        boolean isInvalidEmail = validate.isInvalidEmail(validEmail);
        assertTrue(isInvalidEmail == true);
    }
}
