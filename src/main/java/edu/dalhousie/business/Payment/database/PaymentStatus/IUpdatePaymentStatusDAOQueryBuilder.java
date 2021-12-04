package edu.dalhousie.business.Payment.database.PaymentStatus;

public interface IUpdatePaymentStatusDAOQueryBuilder {
    String updatePaymentStatus(int id, String status, String term);
}
