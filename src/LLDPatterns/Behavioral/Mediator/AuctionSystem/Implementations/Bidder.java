package LLDPatterns.Behavioral.Mediator.AuctionSystem.Implementations;

import LLDPatterns.Behavioral.Mediator.AuctionSystem.AuctionMediator;
import LLDPatterns.Behavioral.Mediator.AuctionSystem.Colleague;
import lombok.Getter;

public class Bidder implements Colleague {
    @Getter
    private String name;
    public AuctionMediator auctionMediator;

    public Bidder(String bidderName, AuctionMediator auctionMediator){
        this.name = bidderName;
        this.auctionMediator = auctionMediator;
        auctionMediator.addBidder(this);
    }

    public void placeBid(int bidAmount) {
        this.auctionMediator.placeBid(this, bidAmount);
    }

    public void receiveBidNotification(int bidAmount) {
        System.out.println("Bidder: " + this.name + " got notification for new bid amount" + bidAmount + " on item." );
    }
}
