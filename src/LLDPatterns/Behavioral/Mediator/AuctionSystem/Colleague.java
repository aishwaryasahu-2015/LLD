package LLDPatterns.Behavioral.Mediator.AuctionSystem;

public interface Colleague {
    public void placeBid(int bidAmount);
    public void receiveBidNotification(int bidAmount);
    public String getName();
}
