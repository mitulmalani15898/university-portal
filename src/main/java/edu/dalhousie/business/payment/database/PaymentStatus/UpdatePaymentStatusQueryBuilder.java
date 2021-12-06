package edu.dalhousie.business.payment.database.PaymentStatus;

import static edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusConstant.*;

public class UpdatePaymentStatusQueryBuilder implements IUpdatePaymentStatusDAOQueryBuilder{
    @Override
    public String updatePaymentStatus(int id, String status, String term) {
        return "INSERT INTO "+ PAYMENT_TABLE +
                "(payment_status, student_id, term)"+
                "VALUES(" + "'" +status+"' "+ ","+ id +","+"'"+term+"'"+")";
    }
}
