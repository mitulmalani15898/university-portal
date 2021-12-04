package edu.dalhousie.business.DalMembership.controller.subscription;

import edu.dalhousie.business.DalMembership.model.Services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiPredicate;

public abstract class Subscription implements ISubscription{
    protected double totalAmount = 0;
    public String subscriptionName;
    public String note;
    private final Set<Services> servicesList = new HashSet<>();

    public abstract BiPredicate<Double, Double> isEligibleToSubscribe() throws Exception;
    public abstract void initializeSubscription();
    public abstract double calculateCharges();
    public abstract Double getMonthlyCharges();

    @Override
    public double calculatePercentage(double obtained, double total) {
        return obtained * total / 100;
    }

    @Override
    public double calculateDiscount(Double charge, Double duration) {
        if (duration >= 3) {
            double discount = calculatePercentage(15, (charge * duration));
            System.out.println("Discount applied : " + discount + " CAD");
            return discount;
        }
        return 0;
    }

    @Override
    public double applyDiscount(double subscriptionAmount, double discount) {
        return subscriptionAmount - discount;
    }

    protected void addServices(Collection<Services> services) {
        services.stream().forEach(service -> servicesList.add(service));
    }

    public Set<Services> getServicesList() {
        return servicesList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public abstract void setTotalAmount(double amount);

}
