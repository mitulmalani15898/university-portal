package edu.dalhousie.business.viewprofile;

import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.database.ExecuteQuery;
import edu.dalhousie.models.LogInModel;
import edu.dalhousie.models.ViewProfileModel;
import edu.dalhousie.presentation.StudentView;
import edu.dalhousie.utilities.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ViewProfile
{
    StudentView view;
    StudentMainClass studentMenu;
    LogIn login;
    LogInModel loginModel;
    ExecuteQuery executeQuery;
    ViewProfileModel viewProfileModel;

    public ViewProfile() {
        view = new StudentView();
        studentMenu = new StudentMainClass();
        login = new LogIn();
        loginModel = new LogInModel();
        executeQuery = new ExecuteQuery();
        viewProfileModel = new ViewProfileModel();
        viewProfileModel.setUserID(loginModel.getUserName());
        //viewProfileModel.setUserID("mitul.malani");
    }

    public void displayProfile()
    {
        try
        {
            String SQL_View = String.format("SELECT * FROM users WHERE user_name = '%s'", viewProfileModel.getUserID());
            ResultSet rs_view = executeQuery.executeUpdateSQL(SQL_View);

            while(rs_view.next()) {
                viewProfileModel.setUsername(rs_view.getString("user_name"));
                viewProfileModel.setFirstName(rs_view.getString("first_name"));
                viewProfileModel.setLastName(rs_view.getString("last_name"));
                viewProfileModel.setEmail(rs_view.getString("email_address"));
                viewProfileModel.setContactNumber(rs_view.getString("contact_number"));
                viewProfileModel.setDateOfBirth(rs_view.getString("dob"));
                viewProfileModel.setGender(rs_view.getString("gender"));
                viewProfileModel.setStreetAddress(rs_view.getString("address"));
                viewProfileModel.setApartmentNumber(rs_view.getString("apartment_number"));
                viewProfileModel.setCity(rs_view.getString("city"));
                viewProfileModel.setProvince(rs_view.getString("province"));
                viewProfileModel.setZipcode(rs_view.getString("zip_code"));
            }

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
                executeUpdateTable("first_name",firstName);

                view.showMessage("Enter your last name:");
                String lastName = view.getString();
                executeUpdateTable("last_name",lastName);

                view.showMessage("Enter your contact number:");
                String contactNumber = view.getString();
                executeUpdateTable("contact_number",contactNumber);

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
                    String hashed_password = login.doPasswordHashing(password);
                    executeUpdateTable("password",hashed_password);
                }

                view.showMessage("Enter your Date of Birth: (MM-DD-YY)");
                String dob = view.getString();
                executeUpdateTable("dob",dob);

                view.showMessage("Enter your gender: (M - Male, F - Female, O - Other)");
                String gender = view.getString();
                executeUpdateTable("gender",gender);

                view.showMessage("Enter your address:");
                String address = view.getString();
                executeUpdateTable("address",address);

                view.showMessage("Enter your apartment number: (if any)");
                String apartmentNumber = view.getString();
                executeUpdateTable("apartment_number",apartmentNumber);

                view.showMessage("Enter your city:");
                String city = view.getString();
                executeUpdateTable("city",city);

                view.showMessage("Enter your province/state:");
                String province = view.getString();
                executeUpdateTable("province",province);

                view.showMessage("Enter your zip code:");
                String zipCode = view.getString();
                executeUpdateTable("zip_code",zipCode);

                view.showMessage("\nUpdating your details...\n");
                view.showMessage("Details updated...\n");

                view.showMessage("Press '0' to go back");
                int userChoice = view.getInt();
                if (userChoice == 0) {
                    //return to main menu
                    studentMenu.displayStudentMenu();
                }
            }
            else if(choice.equalsIgnoreCase("No"))
            {
                //return to main menu
                studentMenu.displayStudentMenu();
            }
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

    public void executeUpdateTable(String column_name, String update_value)
    {
        if (!update_value.equalsIgnoreCase("No")) {
            String SQL_Update = String.format("UPDATE user SET %s = '%s' WHERE username = '%s'", column_name, update_value, viewProfileModel.getUserID());
            try {
                executeQuery.executeSQL(SQL_Update);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void viewProfilePage(String typeOfLogIn)
    {
        boolean isStudent = typeOfLogIn.equals("student");
        String title = isStudent ? "View Student Profile" : "View Faculty Profile";
        Utility.printHeadingForTheScreen(title, 38);
        displayProfile();
    }
}
