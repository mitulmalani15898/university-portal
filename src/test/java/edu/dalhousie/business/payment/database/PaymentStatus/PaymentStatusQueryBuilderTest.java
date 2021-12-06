package edu.dalhousie.business.payment.database.PaymentStatus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentStatusQueryBuilderTest {
    @Test
    public void getPaymentStatus(){
        PaymentStatusQueryBuilder paymentStatusQueryBuilder
                = new PaymentStatusQueryBuilder();
        String expectedQuery =
                paymentStatusQueryBuilder.getPaymentStatus(1,"fall");
        String actualQuery = "SELECT payment_status\n" +
                " FROM payment\n" +
                " WHERE student_id = 1 and term ='fall'";
        assertEquals(expectedQuery,actualQuery);
    }
}
