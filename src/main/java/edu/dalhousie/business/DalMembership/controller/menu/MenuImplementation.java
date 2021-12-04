package edu.dalhousie.business.DalMembership.controller.menu;
import edu.dalhousie.business.DalMembership.controller.balance.Balance;
import edu.dalhousie.business.DalMembership.controller.services.Services;
import edu.dalhousie.business.DalMembership.controller.subscription.SubscriptionImplementation;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.util.Scanner;

public class MenuImplementation implements IMenu{
    public static MainMenu menu = new Menu();
    public final static Scanner input = new Scanner(System.in);
    private final DatabaseConnection databaseConnection;
    UserSession userSession;
    public MenuImplementation(){
        userSession = UserSession.getInstance();
        this.databaseConnection = DatabaseConnectivity.getInstance();
    }
    @Override
    public void start() {
        menu.start();
        try{
            while(true){
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        try{
                            Balance balance = new Balance();
                            balance.showExistingBalance(databaseConnection);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            System.out.println("Enter the amount you want to recharge with:");
                            double amount = input.nextInt();
                            Balance balance = new Balance();
                            balance.rechargeBalance(databaseConnection,amount);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                            Services services = new Services();
                            services.getListOfServices();
                        break;
                    case 4:
                        SubscriptionImplementation subscriptionImplementation
                                = new SubscriptionImplementation();
                        System.out.println("Enter choice:");
                        String Choice = input.next();
                        System.out.println("Enter duration:");
                        double Duration = input.nextDouble();
                        subscriptionImplementation.subscribe(
                                Choice,Duration,
                                userSession.getUser(),databaseConnection);
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
