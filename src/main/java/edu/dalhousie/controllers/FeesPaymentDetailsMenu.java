package edu.dalhousie.controllers;

import edu.dalhousie.business.FullPayment;
import edu.dalhousie.presentation.StudentView;

import java.util.Arrays;
import java.util.List;

public class FeesPaymentDetailsMenu {
    private final StudentView view;
    private final StudentMainClass studentMenu;
    private final  FullPayment fullPayment;
    private final List<String> courses = Arrays.asList("1. Communication Computer Science Idea",
            "2. Advanced Topics in Software Development");
    FeesPaymentDetailsMenu(){
        this.view = new StudentView();
        this.studentMenu = new StudentMainClass();
        this.fullPayment = new FullPayment();
    }

    void showPaymentInformation(){
        this.view.showMessage("**************************************");
        this.view.showMessage("\t \t Fees payment details \t");
        this.view.showMessage("**************************************");

        this.view.showMessage("\nYou have registered in the following courses:");
        for(String course: courses){
            this.view.showMessage(course);
        }

        this.view.showMessage("\nMaximum credits: 9");
        this.view.showMessage("Total registered courses: " + courses.size());
        int credits = courses.size() * 3;
        this.view.showMessage("Total credits: " + credits);
        this.view.showMessage("Total payable amount: " + credits *1000);
        int amount = credits *1000;
        this.view.showMessage("\nWould you like to pay the fees ?" +
                "(1: Full payment, 2: EMI structure, 3: Exit)");
        int choice = this.view.getInt();
        switch(choice){
            case 1: this.view.showMessage("Full payment");
                    this.fullPayment.deductTotalAmount(amount);
                    break;
            case 2: this.view.showMessage("EMI");
                    break;
            case 3: this.studentMenu.displayStudentMenu();
                break;
            default: break;
        }
    }
}
