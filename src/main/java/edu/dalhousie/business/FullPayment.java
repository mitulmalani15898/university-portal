package edu.dalhousie.business;

import edu.dalhousie.presentation.StudentView;

public class FullPayment {
    private final StudentView view;
    public FullPayment(){
        this.view = new StudentView();
    }
    public void deductTotalAmount(int Amount){
        this.view.showMessage("The amount will be deducted shortly.....");
        this.view.showMessage("Your balance is 0 CAD");
    }
}
