package edu.dalhousie.business.facilitybooking.businesss;

import edu.dalhousie.business.facilitybooking.business.ValidateFacilityBooking;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ValidateFacilityBookingTest {
    @Test
    public void checkWhetherValidateBookingExist() {
        assertNotNull(new ValidateFacilityBooking());
    }
}
