/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.FullPayment;

import edu.dalhousie.business.payment.database.PaymentStatus.IUpdatePaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.UpdatePaymentStatusQueryBuilder;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.Connection;
import java.sql.Statement;

public class FullPayment implements IFullPayment{
    private final ICommonPrinting view;
    private final IDatabaseConnection IDatabaseConnection;
    UserSession userSession;
    IUpdatePaymentStatusDAOQueryBuilder iUpdatePaymentStatusDAOQueryBuilder;
    public FullPayment(IDatabaseConnection IDatabaseConnection,
                       IUpdatePaymentStatusDAOQueryBuilder
                               iUpdatePaymentStatusDAOQueryBuilder){
        this.view = CommonPrinting.getInstance();
        userSession = UserSession.getInstance();
        this.IDatabaseConnection = IDatabaseConnection;
        this.iUpdatePaymentStatusDAOQueryBuilder = iUpdatePaymentStatusDAOQueryBuilder;
    }

    @Override
    public void deductTotalAmount() throws Exception {
        int student_id = userSession.getUser().getUserId();
        this.view.showMessage("Enter the term:");
        String term = this.view.getString();
        this.view.showMessage("The amount will be deducted shortly.....");
        final Connection connection =
                IDatabaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(
                        iUpdatePaymentStatusDAOQueryBuilder
                                .updatePaymentStatus(student_id,"full",term));
        this.view.showMessage("Your balance is 0 CAD");
    }
}
