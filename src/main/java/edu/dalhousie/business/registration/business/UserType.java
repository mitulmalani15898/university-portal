package edu.dalhousie.business.registration.business;

public class UserType implements IUserType {
    public boolean isStudent(String typeOfUser) {
        return typeOfUser.equals("student");
    }
}
