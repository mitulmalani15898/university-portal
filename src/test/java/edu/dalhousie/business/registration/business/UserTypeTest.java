package edu.dalhousie.business.registration.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTypeTest {
    @Test
    public void checkWhetherUserTypeExist() {
        assertNotNull(new UserType());
    }

    @Test
    public void shouldBeTrueIfStudent() {
        UserType userType = new UserType();
        String student = "student";
        boolean isStudent = userType.isStudent(student);
        assertEquals(isStudent, true);
    }

    @Test
    public void shouldBeFalseIfNotStudent() {
        UserType userType = new UserType();
        String student = "faculty";
        boolean isStudent = userType.isStudent(student);
        assertEquals(isStudent, false);
    }
}
