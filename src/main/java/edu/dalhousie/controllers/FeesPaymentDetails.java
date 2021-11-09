package edu.dalhousie.controllers;

import edu.dalhousie.presentation.StudentView;

public class FeesPaymentDetails {
    private StudentView view;
    FeesPaymentDetails(){
        System.out.println("You are inside fees payment module");
        this.view = new StudentView();
    }

    void showPaymentInformation(){
        this.view.showMessage("**************************************");
        this.view.showMessage("\t \t Fees payment details \t ");
        this.view.showMessage("**************************************");
    }
}
