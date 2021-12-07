package edu.dalhousie.business.viewprofile.business;

public class UserType implements IUserType {
        public boolean isStudent(String typeOfLogIn) {
            return typeOfLogIn.equals("student");
        }
}
