package edu.dalhousie.presentation;

public interface IStudentView {
    void showMessage(String message);
    void showFormattedMessage(String message, String... args);
    int getInt();
    String getString();
}
