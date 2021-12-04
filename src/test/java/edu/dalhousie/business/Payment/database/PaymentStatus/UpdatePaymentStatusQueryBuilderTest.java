package edu.dalhousie.business.Payment.database.PaymentStatus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdatePaymentStatusQueryBuilderTest {
    @Test
    public void updatePaymentStatus(){
        UpdatePaymentStatusQueryBuilder updatePaymentStatusQueryBuilder
                = new UpdatePaymentStatusQueryBuilder();
        String expectedQuery = updatePaymentStatusQueryBuilder
                .updatePaymentStatus(1,"emi","fall");
        String actualQuery = "INSERT INTO payment(payment_status, student_id, term)" +
                "VALUES('emi' ,1,'fall')";
        assertEquals(expectedQuery,actualQuery);
    }
}
