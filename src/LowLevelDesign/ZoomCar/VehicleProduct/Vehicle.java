package LowLevelDesign.ZoomCar.VehicleProduct;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
public class Vehicle {
    @Setter
    int vehicleId;
    String vehicleNumber;
    @Setter
    VehicleType vehicleType;
    String companyName;
    String modelName;
    Date manufacturingDate;
    Date registrationDate;
    String cc;
    int kmDriven;
    int average;
    int dailyRentalCharge;
    int hourlyRentalCharge;
    int noOfSeats;
    @Setter
    Status status;
}
