package edu.dalhousie.presentation;

public class StudentViewFactory {
    private static StudentViewFactory studentViewFactory = null;

    IStudentView studentView;

    public StudentViewFactory() {
        studentView = new StudentView();
    }

    public static StudentViewFactory getInstance() {
        if (studentViewFactory == null) {
            studentViewFactory = new StudentViewFactory();
        }
        return studentViewFactory;
    }

    public IStudentView getStudentView() {
        return studentView;
    }
}
