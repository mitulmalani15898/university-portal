package edu.dalhousie.business.viewprofile.controller;

import edu.dalhousie.presentation.IStudentView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewProfileTest {

    IStudentView viewMock = Mockito.mock(IStudentView.class);
    ViewProfile viewProfile = new ViewProfile();

    @BeforeEach
    public void init() throws  Exception {
        FieldSetter viewField = new FieldSetter(viewProfile, ViewProfile.class.getDeclaredField("view"));
        viewField.set(viewMock);
    }

    @Test
    public void testViewAndUpdateProile() {
        Mockito.when(viewMock.getString()).thenReturn("no");
        assertEquals(true, viewProfile.displayAndEditProfile());
    }
}
