package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUsernameTest {
    @Test
    public void checkWhetherCreateUsernameExist() {
        assertNotNull(new CreateUsername());
    }

    @Test
    public void testCreateUsername() {
        CreateUsername createUsername = new CreateUsername();
        String firstName = "mitul", lastName = "malani";
        String expectedUsername = firstName + "." + lastName;
        String username = createUsername.createUsernameFromName(firstName, lastName);
        assertEquals(username, expectedUsername);
    }

    @Test
    public void testLengthOfUsername() {
        CreateUsername createUsername = new CreateUsername();
        String firstName = "mitul", lastName = "malani";
        int expectedUsernameLength = firstName.length() + lastName.length() + 1;
        String username = createUsername.createUsernameFromName(firstName, lastName);
        assertEquals(expectedUsernameLength, username.length());
    }

    @Test
    public void shouldContainDotInUsername() {
        CreateUsername createUsername = new CreateUsername();
        String firstName = "mitul", lastName = "malani";
        String username = createUsername.createUsernameFromName(firstName, lastName);
        assertTrue(username.contains("."));
    }

    @Test
    public void shouldNotContainCapitalLetters() {
        CreateUsername createUsername = new CreateUsername();
        String firstName = "MITUL", lastName = "MALANI";
        String expectedUsername = "mitul.malani";
        String username = createUsername.createUsernameFromName(firstName, lastName);
        assertFalse(username.contains("MITUL"));
        assertFalse(username.contains("MALANI"));
        assertEquals(username, expectedUsername);
    }
}
