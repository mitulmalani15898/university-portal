package edu.dalhousie.business.Tender.model;

import java.util.Date;

public class Auctioneer {
    private String name;
    private int bid;
    private int maximumBid;
    private int increment;

    public String getName() {
        return name;
    }

    public int getBid() {
        return bid;
    }

    public int getMaximumBid() {
        return maximumBid;
    }

    public int getIncrement() {
        return increment;
    }

    public Date getBidTime() {
        return bidTime;
    }

    private Date bidTime;

    public int bid() {
        this.bid += this.increment;
        System.out.println(String.format("%s's bid is now at %d", this.name, this.bid));
        return bid;
    }

    public Auctioneer(String name, int bid, int maximumBid, int increment) {
        this.name = name;
        this.bid = bid;
        this.maximumBid = maximumBid;
        this.increment = increment;
        this.bidTime = new Date();
    }
}
