package LLDPatterns.Behavioral.Mediator.AuctionSystem;

public interface AuctionMediator {
    public void addBidder(Colleague bidder);
    public void placeBid(Colleague bidder, int bidAmount);
}
