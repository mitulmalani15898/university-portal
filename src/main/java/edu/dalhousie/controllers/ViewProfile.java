package edu.dalhousie.controllers;

import edu.dalhousie.database.ExecuteQuery;

import java.sql.*;
import java.util.Scanner;

public class ViewProfile
{
    public static void viewProfile()
    {
        try
        {
            ExecuteQuery executeQuery = new ExecuteQuery();
            String SQL = "SELECT * FROM users";
            ResultSet rs = executeQuery.executeUpdateSQL(SQL);

            System.out.println("Username:");
            System.out.println("Name:");
            System.out.println("Email address:");
            System.out.println("Contact number");
            System.out.println("Date of Birth:");
            System.out.println("Gender:");
            System.out.println("Hobbies:");
            System.out.println("Address:");

            while(rs.next())
            {
                String username = rs.getString("Username");
                String name = rs.getString("Name");
                String email = rs.getString("Email address");
                String contact = rs.getString("Contact number");
                String dob = rs.getString("Date of Birth");
                String gender = rs.getString("Gender");
                String hobbies = rs.getString("Hobbies");
                String address = rs.getString("Address");
                System.out.println("\t\t" + username);
                System.out.println("\t\t" + name);
                System.out.println("\t\t" + email);
                System.out.println("\t\t" + contact);
                System.out.println("\t\t" + dob);
                System.out.println("\t\t" + gender);
                System.out.println("\t\t" + hobbies);
                System.out.println("\t\t" + address);
            }

            /*Scanner update = new Scanner(System.in);
            String username = update.nextLine();
            System.out.println("Do you want to update your details: (Yes, No)");
            System.out.println("Enter your first name:\n");
            System.out.println("Enter your last name:\n");
            System.out.println("Enter your contact number:\n");
            System.out.println("Enter your Password:\n");
            System.out.println("Verify your Password:\n");
            System.out.println("Enter your Date of Birth: (MM-DD-YY)\n");
            System.out.println("Enter your gender: (M - Male, F - Female, O - Other)\n");
            System.out.println("Enter your hobbies:\n");
            System.out.println("Enter your street address:\n");
            System.out.println("Enter your apartment number: (if any)\n");
            System.out.println("Enter your city:\n");
            System.out.println("Enter your province/state:\n");
            System.out.println("Enter your zip code:\n");*/

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

    public void viewProfilePage()
    {
        System.out.println("******************************************************************");
        System.out.println("\t \t \t \t \t \t View Student Profile \t");
        System.out.println("******************************************************************");

        viewProfile();
    }
}