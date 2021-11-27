package edu.dalhousie.utilities;

import edu.dalhousie.presentation.StudentView;

public class Utility {
    StudentView view = new StudentView();

    private String starSeparator = new String(new char[100]).replace("\0", "*");

    public void printHeadingForTheScreen(String title, int leftPadding) {
        String spaceCharacters = new String(new char[leftPadding]).replace("\0", " ");

        view.showMessage("\n" + starSeparator);
        view.showMessage(spaceCharacters + title.toUpperCase());
        view.showMessage(starSeparator + "\n");
    }
}
