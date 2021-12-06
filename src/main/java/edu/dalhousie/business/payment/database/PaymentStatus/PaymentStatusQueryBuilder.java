package edu.dalhousie.business.payment.database.PaymentStatus;

import static edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusConstant.*;

public class PaymentStatusQueryBuilder implements IPaymentStatusDAOQueryBuilder{
    @Override
    public String getPaymentStatus(int id, String term) {
        return "SELECT "+  PAYMENT_STATUS +"\n" +
                " FROM "+PAYMENT_TABLE+ "\n" +
                " WHERE "+ STUDENT_ID + " = " + id +
                " and term ="+ "'"+ term + "'";
    }
}
