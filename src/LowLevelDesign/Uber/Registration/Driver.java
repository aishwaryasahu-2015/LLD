package LowLevelDesign.Uber.Registration;

import LowLevelDesign.Uber.RideManagement.RideRequest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Driver extends User {
    String drivingLicenceNumber;
    String aadhaarNumber;
    String pan;
    BankDetails bankDetails;
    public Queue<RideRequest> rideRequestList;

    public Driver(String name, String phoneNumber){
        super(name, phoneNumber);
        this.rideRequestList = new LinkedList<>();
    }

    public void validateUser(){
        //validate phone number;
        //ask to submit ids :
        Scanner sc = new Scanner(System.in);

        System.out.print("Provide Driving Licence: ");
        this.drivingLicenceNumber = sc.next();
//
//        System.out.print("Provide Aadhaar: ");
//        this.aadhaarNumber = sc.next();
//
//        System.out.print("Provide pan number: ");
//        this.pan = sc.next();
//
//        System.out.println("Provide bank details");
//        System.out.print("Bank Account Number: ");
//        String accountNumber = sc.next();
//
//        System.out.print("Bank ifsc code: ");
//        String ifscCode = sc.next();
//
//        this.bankDetails = new BankDetails(accountNumber, ifscCode);
//write some validation logic to be implemented later
    }
}
