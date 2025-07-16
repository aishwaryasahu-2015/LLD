package LowLevelDesign.Uber.RideManagement;

import LowLevelDesign.Uber.Coordinates;

public class RideRequest {
    Coordinates source;
    Coordinates destination;
    RiderInfo riderInfo;
    RideStatus status;

    public RideRequest(Coordinates source, Coordinates destination, RiderInfo riderInfo){
        this.source = source;
        this.destination = destination;
        this.riderInfo = riderInfo;
        this.status = RideStatus.REQUESTED;
    }
}
