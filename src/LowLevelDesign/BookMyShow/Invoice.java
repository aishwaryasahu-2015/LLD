package LowLevelDesign.BookMyShow;

import LowLevelDesign.BookMyShow.Enums.PaymentStatus;
import LowLevelDesign.BookMyShow.Users.Customer;

public class Invoice {
    int invoiceId;
    double amount;
    Customer user;
    Show show;
    PaymentStatus paymentStatus;
}
