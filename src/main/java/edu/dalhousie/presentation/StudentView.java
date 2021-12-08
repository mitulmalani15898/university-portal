package edu.dalhousie.presentation;



import java.util.Scanner;

public class StudentView implements IStudentView {
    private static StudentView studentView= null;
    private StudentView(){

    }

    public static StudentView getInstance(){
        if(studentView==null){
            studentView = new StudentView();
        }
        return studentView;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showFormattedMessage(String message, String... args) {
        System.out.format(message, args);
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
