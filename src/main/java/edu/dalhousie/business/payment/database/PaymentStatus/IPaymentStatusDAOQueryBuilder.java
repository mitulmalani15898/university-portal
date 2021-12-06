package edu.dalhousie.business.payment.database.PaymentStatus;

public interface IPaymentStatusDAOQueryBuilder {
    String getPaymentStatus(int id, String term);
}
