package edu.dalhousie.business.tender.model;

import java.util.Date;

public class Auctioneer {
    private String name;
    private int bidAmount;
    private int maximumAmount;
    private int increment;
    private Date timeOfPlacingABid;


    public String getName() {
        return name;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }

    public int getIncrement() {
        return increment;
    }

    public Date getTimeOfPlacingABid() {
        return timeOfPlacingABid;
    }



    public int bid() {
        this.bidAmount = this.bidAmount + this.increment;
        System.out.println(String.format("%s's amount is now at %d", this.name, this.bidAmount));
        return bidAmount;
    }

    public Auctioneer(String name, int bid, int maximumAmount, int increment) {
        this.name = name;
        this.bidAmount = bid;
        this.maximumAmount = maximumAmount;
        this.increment = increment;
        this.timeOfPlacingABid = new Date();
    }
}
