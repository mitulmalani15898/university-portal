/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.FullPayment;

import edu.dalhousie.business.payment.database.PaymentStatus.IUpdatePaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.UpdatePaymentStatusQueryBuilder;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.presentation.IStudentView;
import edu.dalhousie.presentation.StudentView;

import java.sql.Connection;
import java.sql.Statement;

public class FullPayment implements IFullPayment{
    private final IStudentView view;
    private final DatabaseConnection databaseConnection;
    UserSession userSession;
    IUpdatePaymentStatusDAOQueryBuilder iUpdatePaymentStatusDAOQueryBuilder;
    public FullPayment(DatabaseConnection databaseConnection,
                       IUpdatePaymentStatusDAOQueryBuilder
                               iUpdatePaymentStatusDAOQueryBuilder){
        this.view = StudentView.getInstance();
        userSession = UserSession.getInstance();
        this.databaseConnection = databaseConnection;
        this.iUpdatePaymentStatusDAOQueryBuilder = new UpdatePaymentStatusQueryBuilder();
    }

    @Override
    public void deductTotalAmount() throws Exception {
        int student_id = userSession.getUser().getUserId();
        this.view.showMessage("Enter the term:");
        String term = this.view.getString();
        this.view.showMessage("The amount will be deducted shortly.....");
        final Connection connection =
                databaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(
                        iUpdatePaymentStatusDAOQueryBuilder
                                .updatePaymentStatus(student_id,"full",term));
        this.view.showMessage("Your balance is 0 CAD");
    }
}
