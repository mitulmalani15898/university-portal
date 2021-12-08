/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.PaymentInformation;

import edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IPaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.model.PaymentDetails;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseException;
import edu.dalhousie.presentation.StudentView;
import static edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsConstant.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowPaymentInformation implements IPaymentInformation{
    private final DatabaseConnection databaseConnection;
    private final PaymentDetailsDAOQueryBuilder paymentDetailsDAOQueryBuilder;
    private final IPaymentStatusDAOQueryBuilder paymentStatusDAOQueryBuilder;
    private final StudentView view;
    UserSession userSession;
    private final int MAXIMUM_CREDITS=9;
    public ShowPaymentInformation(DatabaseConnection databaseConnection,
                                  PaymentDetailsDAOQueryBuilder
                                          paymentDetailsDAOQueryBuilder,
                                  IPaymentStatusDAOQueryBuilder
                                          paymentStatusDAOQueryBuilder){
        this.databaseConnection = databaseConnection;
        this.paymentDetailsDAOQueryBuilder = paymentDetailsDAOQueryBuilder;
        this.paymentStatusDAOQueryBuilder = paymentStatusDAOQueryBuilder;
        this.view = new StudentView();
        userSession = UserSession.getInstance();
    }

    @Override
    public void showFeeDetails() throws Exception {
        int student_id = userSession.getUser().getUserId();
        this.view.showMessage("Enter the term:");
        String term = this.view.getString();
        try{
            final Connection connection =
                    databaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            final ResultSet paymentStatusResultSet =
                    statement.executeQuery(
                            paymentStatusDAOQueryBuilder
                                    .getPaymentStatus(student_id,term));
            String status=null;
            while(paymentStatusResultSet.next()){
                status = paymentStatusResultSet.getString("payment_status");
            }

            if(status==null){
                final ResultSet paymentDetailsResultSet =
                        statement.executeQuery(
                                paymentDetailsDAOQueryBuilder
                                        .selectEnrolledCoursesQuery(student_id));
                final List<PaymentDetails> paymentDetailsArrayList =
                        preparePaymentDetails(paymentDetailsResultSet);
                int labCount = 0;
                int theoryCount = 0;
                this.view.showMessage("\nYou have registered in the following courses:");
                for(PaymentDetails paymentDetails: paymentDetailsArrayList){
                    this.view.showMessage(paymentDetails.getCourseId() + " "
                            + paymentDetails.getCourseName());
                    final String courseType = paymentDetails.getCourseType();
                    if (courseType.equalsIgnoreCase("Theory")) {
                        theoryCount++;
                    }
                    else{
                        labCount++;
                    }
                }
                this.view.showMessage("\nMaximum credits: "+ MAXIMUM_CREDITS);
                this.view.showMessage("Total registered courses: " +
                        paymentDetailsArrayList.size());
                int credits = theoryCount * 3;
                this.view.showMessage("Total credits: " + credits);
                int amount = theoryCount * 1500 + labCount * 500;
                this.view.showMessage("Total payable amount: " + amount);
            }
            else{
                if (status.equalsIgnoreCase("full")){
                    this.view.showMessage("You have already paid the " +
                            "fees for the "+term+ " term");
                }else{
                    this.view.showMessage("You have already opted the " +
                            "emi option for the "+term+ " term");
                }
            }

        }
        catch(SQLException e){
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    private List<PaymentDetails> preparePaymentDetails(ResultSet paymentDetailsResultSet)
            throws SQLException {
        final List<PaymentDetails> paymentDetailsArrayList = new ArrayList<>();
        while(paymentDetailsResultSet.next()){
            final int courseId = paymentDetailsResultSet.getInt(COURSE_ID);
            final int studentId = paymentDetailsResultSet.getInt(STUDENT_ID);
            final String courseName = paymentDetailsResultSet.getString(COURSE_NAME);
            final String courseType = paymentDetailsResultSet.getString(COURSE_TYPE);
            PaymentDetails paymentDetails =
                    new PaymentDetails(courseId,studentId,courseName,courseType);
            paymentDetailsArrayList.add(paymentDetails);
        }
        return paymentDetailsArrayList;
    }
}
