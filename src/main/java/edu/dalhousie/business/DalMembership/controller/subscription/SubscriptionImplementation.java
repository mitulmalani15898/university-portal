package edu.dalhousie.business.DalMembership.controller.subscription;

import edu.dalhousie.business.DalMembership.controller.subscription.handler.BronzeHandler;
import edu.dalhousie.business.DalMembership.controller.subscription.handler.Handler;
import edu.dalhousie.business.DalMembership.database.balance.updateBalance.UpdateBalanceQueryBuilder;
import edu.dalhousie.business.DalMembership.database.subscription.UpdateSubscriptionQueryBuilder;
import edu.dalhousie.controllers.User;
import edu.dalhousie.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.function.BiPredicate;

public class SubscriptionImplementation implements ISubscriptionImplmentation{
    private Subscription subscription = null;
    private Handler handler = new BronzeHandler();
    UpdateSubscriptionQueryBuilder updateSubscriptionQueryBuilder;
    UpdateBalanceQueryBuilder updateBalanceQueryBuilder;
    public SubscriptionImplementation(){
        this.updateSubscriptionQueryBuilder = new UpdateSubscriptionQueryBuilder();
        this.updateBalanceQueryBuilder = new UpdateBalanceQueryBuilder();
    }
    @Override
    public Subscription subscribe(String choice, Double duration,
                                  User user,
                                  DatabaseConnection databaseConnection) throws Exception {
        if (choice.isEmpty() || duration == 0 || user == null) {
            throw new NullPointerException("values can't be null");
        }

        subscription = subscriptionFactory(choice);

        BiPredicate<Double, Double> eligibility = subscription.isEligibleToSubscribe();

        if (!eligibility.test(duration, user.getBalance())) {
            throw new Exception("account balance is low, refill the same " +
                    "in order to subscribe the plan");
        }

        subscription.initializeSubscription();
        user.setBalance(user.getBalance() - subscription.getMonthlyCharges());
        user.setCurrentSubscription(subscription);

        final Connection connection =
                databaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
        statement.executeUpdate(this.updateSubscriptionQueryBuilder
                .updateSubscriptionQuery(
                        user.getUserId(),
                        user.getCurrentSubscription().subscriptionName
                ));
        statement.executeUpdate(this.updateBalanceQueryBuilder
                .rechargeBalanceQuery(
                        user.getUserId(),
                        user.getCurrentSubscription().getTotalAmount()
                ));
        return subscription;
    }

    private Subscription subscriptionFactory(String choice) throws Exception {
        return handler.processRequest(choice);
    }
}
