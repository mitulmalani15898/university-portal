package edu.dalhousie.business.viewprofile.controller;

import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.Hashing;
import edu.dalhousie.business.viewprofile.model.ViewProfileModel;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.PrintHeading;
import edu.dalhousie.business.viewprofile.database.ViewProfileConnection;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewProfile
{
    StudentView view;
    StudentMainClass studentMenu;
    Hashing performHashing;
    ViewProfileModel viewProfileModel;
    ViewProfileConnection viewProfileConnection;
    private DatabaseConnection databaseConnection;

    public ViewProfile() {
        this.databaseConnection = DatabaseConnectivity.getInstance();
        view = new StudentView();
        studentMenu = new StudentMainClass();
        performHashing = new Hashing();
        viewProfileConnection = new ViewProfileConnection();
        viewProfileModel = new ViewProfileModel();
        //viewProfileModel.setUserID(userDetails.getUserName());
        //viewProfileModel.setUserID("mitul.malani");
    }

    public void displayProfile()
    {
        try
        {
            viewProfileConnection.executeViewTable();

            view.showMessage("Username:\t\t\t" + viewProfileModel.getUsername());
            view.showMessage("First name:\t\t\t" + viewProfileModel.getFirstName());
            view.showMessage("Last name:\t\t\t" + viewProfileModel.getLastName());
            view.showMessage("Email address:\t\t" + viewProfileModel.getEmail());
            view.showMessage("Contact number:\t\t" + viewProfileModel.getContactNumber());
            view.showMessage("Date of Birth:\t\t" + viewProfileModel.getDateOfBirth());
            view.showMessage("Gender:\t\t\t\t" + viewProfileModel.getGender());
            view.showMessage("Address:\t\t\t" + viewProfileModel.getStreetAddress());
            view.showMessage("Apartment number:\t" + viewProfileModel.getApartmentNumber());
            view.showMessage("City:\t\t\t\t" + viewProfileModel.getCity());
            view.showMessage("Province:\t\t\t" + viewProfileModel.getProvince());
            view.showMessage("Zip code:\t\t\t" + viewProfileModel.getZipcode());

            view.showMessage("Do you want to update your details: (Yes, No)");
            String choice = view.getString();
            if(choice.equalsIgnoreCase("Yes")) {

                view.showMessage("Enter your first name:");
                String firstName = view.getString();
                viewProfileConnection.executeUpdateTable("first_name",firstName);

                view.showMessage("Enter your last name:");
                String lastName = view.getString();
                viewProfileConnection.executeUpdateTable("last_name",lastName);

                view.showMessage("Enter your contact number:");
                String contactNumber = view.getString();
                viewProfileConnection.executeUpdateTable("contact_number",contactNumber);

                view.showMessage("Enter your Password (Must include uppercase, lowercase letters along with numeric and special characters):");
                String password = view.getString();

                if(!password.equalsIgnoreCase("No"))
                {
                    while (!password.isEmpty() && isInvalidPassword(password))
                    {
                        view.showMessage("Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ");
                        password = view.getString();
                    }
                }

                view.showMessage("Verify your Password:");
                String verifyPassword = view.getString();

                while (!verifyPassword.equals(password))
                {
                    view.showMessage("Verify your Password (confirm password should be match with password): ");
                    verifyPassword = view.getString();
                }

                if(!password.equalsIgnoreCase("No") && !verifyPassword.equalsIgnoreCase("No"))
                {
                    String hashed_password = performHashing.doPasswordHashing(password);
                    viewProfileConnection.executeUpdateTable("password",hashed_password);
                }

                view.showMessage("Enter your Date of Birth: (MM-DD-YY)");
                String dob = view.getString();
                viewProfileConnection.executeUpdateTable("dob",dob);

                view.showMessage("Enter your gender: (M - Male, F - Female, O - Other)");
                String gender = view.getString();
                viewProfileConnection.executeUpdateTable("gender",gender);

                view.showMessage("Enter your address:");
                String address = view.getString();
                viewProfileConnection.executeUpdateTable("address",address);

                view.showMessage("Enter your apartment number: (if any)");
                String apartmentNumber = view.getString();
                viewProfileConnection.executeUpdateTable("apartment_number",apartmentNumber);

                view.showMessage("Enter your city:");
                String city = view.getString();
                viewProfileConnection.executeUpdateTable("city",city);

                view.showMessage("Enter your province/state:");
                String province = view.getString();
                viewProfileConnection.executeUpdateTable("province",province);

                view.showMessage("Enter your zip code:");
                String zipCode = view.getString();
                viewProfileConnection.executeUpdateTable("zip_code",zipCode);

                view.showMessage("\nUpdating your details...\n");
                view.showMessage("Details updated...\n");

                /*view.showMessage("Press '0' to go back");
                int userChoice = view.getInt();
                if (userChoice == 0) {
                    studentMenu.displayStudentMenu();
                }*/
            }
            /*else if(choice.equalsIgnoreCase("No"))
            {
                studentMenu.displayStudentMenu();
            }*/
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public boolean isInvalidPassword(String password) {
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);
        return !matcher.matches();
    }

    public void viewProfilePage(String typeOfLogIn)
    {
        boolean isStudent = typeOfLogIn.equals("student");
        String title = isStudent ? "View Student Profile" : "View Faculty Profile";
        PrintHeading.printHeadingForTheScreen(title, 38);
        displayProfile();
    }

    public static void main(String[] args)
    {
        ViewProfile vp = new ViewProfile();
        vp.viewProfilePage("student");
    }
}
