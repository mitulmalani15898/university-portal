package edu.dalhousie.presentation;

import java.util.Scanner;

public class StudentView {

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        return input;
    }

    public String getString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

}
