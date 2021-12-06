package edu.dalhousie.business.payment.controller.EMIPayment;

import edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IPaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IUpdatePaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.UpdatePaymentStatusQueryBuilder;
import edu.dalhousie.business.payment.model.PaymentDetails;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.presentation.StudentView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsConstant.*;
import static edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsConstant.COURSE_TYPE;

public class EMIPaymentPlans implements IEMIPaymentPlans {
    private final StudentView view;
    private final DatabaseConnection databaseConnection;
    private final PaymentDetailsDAOQueryBuilder paymentDetailsDAOQueryBuilder;
    private final IPaymentStatusDAOQueryBuilder paymentStatusDAOQueryBuilder;
    private final IUpdatePaymentStatusDAOQueryBuilder iUpdatePaymentStatusDAOQueryBuilder;
    UserSession userSession;
    public EMIPaymentPlans(DatabaseConnection databaseConnection,
                           PaymentDetailsDAOQueryBuilder
                                   paymentDetailsDAOQueryBuilder,
                           IPaymentStatusDAOQueryBuilder iPaymentStatusDAOQueryBuilder){
        this.view = new StudentView();
        this.databaseConnection = databaseConnection;
        this.paymentDetailsDAOQueryBuilder = paymentDetailsDAOQueryBuilder;
        this.paymentStatusDAOQueryBuilder = new PaymentStatusQueryBuilder();
        this.iUpdatePaymentStatusDAOQueryBuilder = new UpdatePaymentStatusQueryBuilder();
        userSession = UserSession.getInstance();
    }

    private static double calculateEMI(
            int principalAmount, double termInYears, double interestRate) {

        interestRate = interestRate / 100.0;

        double monthlyRate = interestRate / 12.0;

        double termInMonths = termInYears * 12;

        double EMI =
                (principalAmount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        return EMI;
    }

    @Override
    public void showEMIStructure() throws Exception {
        int student_id = userSession.getUser().getUserId();
        this.view.showMessage("Enter the term:");
        String term = this.view.getString();
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
        if(status!=null){
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

            int credits = theoryCount * 3;
            this.view.showMessage("Total credits: " + credits);
            int amount = theoryCount * 1500 + labCount * 500;
            this.view.showMessage("How many installments would you like to opt with ?" +
                    "(in months: 3, 6)");
            float months = (float) this.view.getInt();
            double rateOfInterest = months == 3 ? 10: 15;
            months = months/12;
            double monthlyPayment = calculateEMI(amount,months,rateOfInterest);
            double totalPayed = 0;
            int month = 0;
            System.out.printf("%9s      %9s     %9s\n",
                    "Month", "Interest Rate", "Monthly payments");
            while(totalPayed <= amount){
                totalPayed = totalPayed + monthlyPayment;
                System.out.printf("%9s      %8s     %14s  \n",
                        month,rateOfInterest,Math.round(totalPayed * 100.0)/ 100.0);
                month ++;
            }
            this.view.showMessage("Would you like to pay with the selected plan ?");
            String answer = this.view.getString();
            if(answer.equalsIgnoreCase("y")){
                statement.executeUpdate(
                        iUpdatePaymentStatusDAOQueryBuilder
                                .updatePaymentStatus(student_id,"emi",term));
            }

        }else{
            if (status.equalsIgnoreCase("full")){
                this.view.showMessage("You have already paid the " +
                        "fees for the "+term+ " term");
            }else{
                this.view.showMessage("You have already opted the " +
                        "emi option for the "+term+ " term");
            }
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
