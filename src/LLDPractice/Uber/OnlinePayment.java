package LLDPractice.Uber;

import LLDPractice.Uber.Enum.PaymentStatus;

public class OnlinePayment extends Payment{
    @Override
    public void makePayment(int amount) {
        this.paymentStatus = PaymentStatus.PAID;
        System.out.println("Payment completed online");
    }
}
