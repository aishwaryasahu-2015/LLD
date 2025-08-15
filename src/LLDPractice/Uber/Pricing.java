package LLDPractice.Uber;

public class Pricing {
    private int baseFare;
    private int perKmPrice;

    public Pricing(int baseFare, int perKmPrice){
        this.baseFare = baseFare;
        this.perKmPrice = perKmPrice;
    }

    public int getBaseFare(){
        return baseFare;
    }

    public int getPerKmPrice(){
        return perKmPrice;
    }
}
