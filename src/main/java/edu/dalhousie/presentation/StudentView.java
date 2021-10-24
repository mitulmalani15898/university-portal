package edu.dalhousie.presentation;

import java.util.Scanner;

public class StudentView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getMessage() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }

}
