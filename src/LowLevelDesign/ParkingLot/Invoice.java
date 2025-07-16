package LowLevelDesign.ParkingLot;

public class Invoice {
    double payable;
    PaymentStatus paymentStatus;

    public Invoice(double payable){
        this.payable = payable;
        this.paymentStatus = PaymentStatus.UNPAID;
    }

    public void logPayment(){
        this.paymentStatus = PaymentStatus.PAID;
    }
}
