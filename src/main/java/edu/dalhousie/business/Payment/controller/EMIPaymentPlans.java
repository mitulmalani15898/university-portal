package edu.dalhousie.business.Payment.controller;

import edu.dalhousie.presentation.StudentView;

public class EMIPaymentPlans {
    private final StudentView view;
    public EMIPaymentPlans(){
        this.view = new StudentView();
    }

    public static double calculateMonthlyPayment(
            int principalAmount, int termInYears, double interestRate) {

        interestRate /= 100.0;

        double monthlyRate = interestRate / 3.0;

        int termInMonths = termInYears * 3;

        double monthlyPayment =
                (principalAmount*monthlyRate) /
                        (1-Math.pow(1+monthlyRate, -termInMonths));

        return monthlyPayment;
    }
    public void showEMIStructure(){
        this.view.showMessage("How many installments would you like to opt with ?" +
                "(in months: 3, 6)");
        int months = this.view.getInt();
        double roi;
        if(months==3){
             roi = 10;
        }else{
            roi = 15;
        }
        double monthlyPayment = calculateMonthlyPayment(5500,months,roi);
        double totalPayed = 0;
        int month = 0;
        double loanAmountRemaining = 0;
        System.out.printf("%9s      %9s     %9s     %9s\n",
                "monthlypayment", "interestRate", "loanAmount", "loanAmountRemaining");
        while(totalPayed <= 5500){
            totalPayed = totalPayed + monthlyPayment;
            double totalLoanAmount =  5500 + roi;
            loanAmountRemaining = totalLoanAmount - totalPayed;
            System.out.printf("%9s      %10s     %15s     %22s\n",
                    month,roi,totalLoanAmount,loanAmountRemaining);
            month ++;
        }

    }
}
