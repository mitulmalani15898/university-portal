/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.controllers;

import edu.dalhousie.business.payment.controller.EMIPayment.EMIPaymentPlans;
import edu.dalhousie.business.payment.controller.FullPayment.FullPayment;
import edu.dalhousie.business.payment.controller.PaymentInformation.ShowPaymentInformation;
import edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentDetails.PaymentDetailsQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IPaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.IUpdatePaymentStatusDAOQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.PaymentStatusQueryBuilder;
import edu.dalhousie.business.payment.database.PaymentStatus.UpdatePaymentStatusQueryBuilder;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.presentation.StudentView;

public class FeesPaymentDetailsMenu {
    private final StudentView view;
    private final StudentMainClass studentMenu;
    private final DatabaseConnection databaseConnection;
    private final PaymentDetailsDAOQueryBuilder paymentDetailsDAOQueryBuilder;
    private final IPaymentStatusDAOQueryBuilder iPaymentStatusDAOQueryBuilder;
    private final IUpdatePaymentStatusDAOQueryBuilder iUpdatePaymentStatusDAOQueryBuilder;
    FeesPaymentDetailsMenu(){
        this.view = new StudentView();
        this.studentMenu = new StudentMainClass();
        databaseConnection = DatabaseConnectivity.getInstance();
        this.paymentDetailsDAOQueryBuilder = PaymentDetailsQueryBuilder.getInstance();
        this.iPaymentStatusDAOQueryBuilder = new PaymentStatusQueryBuilder();
        this.iUpdatePaymentStatusDAOQueryBuilder = new UpdatePaymentStatusQueryBuilder();

    }

    protected void showPaymentInformationMenu() throws Exception {
        this.view.showMessage("**************************************");
        this.view.showMessage("\t \t Fees payment Menu \t");
        this.view.showMessage("**************************************");
        while (true) {
            this.view.showMessage("\nHow Would you like to pay the fees ?" +
                    "(1:Show payment details, 2: Full payment, 3: EMI structure, 4: Exit)");
            int choice = this.view.getInt();
            switch (choice) {
                case 1:
                    ShowPaymentInformation showPaymentInformation =
                            new ShowPaymentInformation(databaseConnection,
                                    paymentDetailsDAOQueryBuilder,
                                    iPaymentStatusDAOQueryBuilder);
                    showPaymentInformation.showFeeDetails();
                    break;
                case 2:
                    this.view.showMessage("Full payment");
                    FullPayment fullPayment = new FullPayment(databaseConnection,
                            iUpdatePaymentStatusDAOQueryBuilder);
                    fullPayment.deductTotalAmount();
                    break;
                case 3:
                    this.view.showMessage("EMI");
                    EMIPaymentPlans emiPaymentPlans = new EMIPaymentPlans(
                            databaseConnection,
                            paymentDetailsDAOQueryBuilder,
                            iPaymentStatusDAOQueryBuilder);
                    emiPaymentPlans.showEMIStructure();
                    break;
                case 4:
                    this.studentMenu.displayStudentMenu();
                    break;
                default:
                    break;
            }
        }
    }
}
