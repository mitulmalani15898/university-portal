package edu.dalhousie.business.Tender.model;

import java.util.Date;

public class Bidder {
    private String name;
    private int bid;
    private int originalBid;
    private int maxBid;
    private int increment;

    public String getName() {
        return name;
    }

    public int getBid() {
        return bid;
    }
    public void setOriginalBid(int originalBid) {
        this.originalBid = originalBid;
    }

    public int getOriginalBid() {
        return originalBid;
    }

    public int getMaxBid() {
        return maxBid;
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

    public Bidder(String name, int bid, int maxBid, int increment) {
        this.name = name;
        this.bid = bid;
        this.maxBid = maxBid;
        this.increment = increment;
        this.bidTime = new Date();
    }
}
