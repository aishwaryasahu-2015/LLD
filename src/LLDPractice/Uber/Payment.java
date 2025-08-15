package LLDPractice.Uber;

import LLDPractice.Uber.Enum.PaymentStatus;

public abstract class Payment {
    int amount;
    PaymentStatus paymentStatus;
    public abstract void makePayment(int amount);
}
