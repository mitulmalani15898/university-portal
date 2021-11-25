package edu.dalhousie.business.Tender.controller;

import edu.dalhousie.business.Tender.model.Bidder;

import java.util.Collection;

public interface ITender {
    public abstract void setTenderEvent(String tenderEvent);
    public abstract void addNewBidders(Collection<Bidder> bidders);
    public abstract Bidder startTender() throws Exception;
}
