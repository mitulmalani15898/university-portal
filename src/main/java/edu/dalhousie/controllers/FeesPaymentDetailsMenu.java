/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.controllers;

import edu.dalhousie.business.Payment.controller.EMIPaymentPlans;
import edu.dalhousie.business.Payment.controller.FullPayment;
import edu.dalhousie.business.Payment.controller.ShowPaymentInformation;
import edu.dalhousie.business.Payment.database.PaymentDetailsDAOQueryBuilder;
import edu.dalhousie.business.Payment.database.PaymentDetailsQueryBuilder;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.presentation.StudentView;

public class FeesPaymentDetailsMenu {
    private final StudentView view;
    private final StudentMainClass studentMenu;
    private final FullPayment fullPayment;
    private final EMIPaymentPlans emiPaymentPlans;
    private final DatabaseConnection databaseConnection;
    private final PaymentDetailsDAOQueryBuilder feesCourseQueryBuilder;

    FeesPaymentDetailsMenu(){
        this.emiPaymentPlans = new EMIPaymentPlans();
        this.view = new StudentView();
        this.studentMenu = new StudentMainClass();
        this.fullPayment = new FullPayment();
        databaseConnection = DatabaseConnectivity.getInstance();
        this.feesCourseQueryBuilder = PaymentDetailsQueryBuilder.getInstance();
    }

    void showPaymentInformationMenu() throws Exception {
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
                                    feesCourseQueryBuilder);
                    showPaymentInformation.showFeeDetails();
                    break;
                case 2:
                    this.view.showMessage("Full payment");
                    this.fullPayment.deductTotalAmount();
                    break;
                case 3:
                    this.view.showMessage("EMI");
                    this.emiPaymentPlans.showEMIStructure();
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
