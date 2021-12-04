package edu.dalhousie.business.Tender.controller.Tender;

import edu.dalhousie.business.Tender.controller.BiddingComparator;
import edu.dalhousie.business.Tender.database.ITenderWinnerDAOQueryBuilder;
import edu.dalhousie.business.Tender.database.TenderWinnerQueryBuilder;
import edu.dalhousie.business.Tender.model.Auctioneer;
import edu.dalhousie.database.DatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class Tender extends AbstractTender {

    private static ITenderWinnerDAOQueryBuilder iTenderWinnerDAOQueryBuilder;
    private static DatabaseConnection databaseConnection;
    @Override
    public Auctioneer findBestBidder() {
        Set<Auctioneer> activeAuctioneers = new HashSet<>(bidders);
        System.out.println("Starting auction for : "+ this.tenderEvent);
        while (activeAuctioneers.size() > 1) {
            Auctioneer lowestAuctioneer = null;

            for (Auctioneer bidder : bidders) {

                if (!activeAuctioneers.contains(bidder)) {
                    continue;
                }

                int nextBid = bidder.getBid() + bidder.getIncrement();

                if (bidder.getMaximumBid() < nextBid) {
                    activeAuctioneers.remove(bidder);
                    continue;
                }

                if (lowestAuctioneer == null ||
                        (nextBid < lowestAuctioneer.getBid() + lowestAuctioneer.getIncrement())) {
                    lowestAuctioneer = bidder;
                }
            }

            if (lowestAuctioneer != null) {
                lowestAuctioneer.bid();
            }
        }
        return Collections.max(bidders, new BiddingComparator());
    }

    public void getTenderData() throws Exception {
        iTenderWinnerDAOQueryBuilder = new TenderWinnerQueryBuilder();
        databaseConnection = DatabaseConnectivity.getInstance();
        System.out.println("Enter the event name:");
        String eventName = sc.nextLine();
        setTenderEvent(eventName);
        List Auctioneers = new ArrayList<>();
        System.out.println("Enter the number of bidders:");
        int size = sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter Auctioneer name:");
            String auctioneerName = sc.next();
            System.out.println("Enter bidding amount:");
            int biddingAmount = sc.nextInt();
            System.out.println("Enter maximum bidding amount:");
            int maximumBiddingAmount = sc.nextInt();
            System.out.println("Enter incremental amount:");
            int incrementalValueForEachRound = sc.nextInt();
            Auctioneers.add(new Auctioneer(auctioneerName,
                    biddingAmount,maximumBiddingAmount,incrementalValueForEachRound));
        }
        addNewAuctioneers(Auctioneers);
        Auctioneer winner = startTender();
        String winnerName = winner.getName();
        final Connection connection =
                databaseConnection.getDatabaseConnection();
        final Statement statement =
                connection.createStatement();
                statement.executeQuery(
                        iTenderWinnerDAOQueryBuilder
                                .updateWinner(winnerName));
    }
}
