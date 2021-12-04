package edu.dalhousie.business.Tender.controller.Tender;

import edu.dalhousie.business.Tender.model.Auctioneer;

import java.util.Collection;

public interface ITender {
    void setTenderEvent(String tenderEvent);
    void addNewAuctioneers(Collection<Auctioneer> bidders);
    Auctioneer startTender() throws Exception;
}
