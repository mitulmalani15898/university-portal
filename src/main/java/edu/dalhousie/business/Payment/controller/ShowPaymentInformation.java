/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.Payment.controller;

import edu.dalhousie.business.Payment.database.PaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.Payment.model.PaymentDetails;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseException;
import edu.dalhousie.presentation.StudentView;
import static edu.dalhousie.business.Payment.database.PaymentDetailsConstant.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ShowPaymentInformation {
    private final DatabaseConnection databaseConnection;
    private final PaymentDetailsDAOQueryBuilder feesCourseQueryBuilder;
    private final StudentView view;
    private final int MAXIMUM_CREDITS=9;
    public ShowPaymentInformation(DatabaseConnection databaseConnection,
                                  PaymentDetailsDAOQueryBuilder feesCourseQueryBuilder){
        this.databaseConnection = databaseConnection;
        this.feesCourseQueryBuilder = feesCourseQueryBuilder;
        this.view = new StudentView();
    }

    public void showFeeDetails() throws Exception {
        this.view.showMessage("Enter the student id:");
        int student_id = this.view.getInt();
        try{
            final Connection connection =
                    databaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            final ResultSet paymentDetailsResultSet =
                    statement.executeQuery(
                            feesCourseQueryBuilder.selectEnrolledCoursesQuery(student_id));
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
            this.view.showMessage("Total registered courses: " + paymentDetailsArrayList.size());
            int credits = theoryCount * 3;
            this.view.showMessage("Total credits: " + credits);
            int amount = theoryCount * 1500 + labCount * 500;
            this.view.showMessage("Total payable amount: " + amount);
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
