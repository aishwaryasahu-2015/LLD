package LowLevelDesign.ZoomCar;

public enum ReservationStatus {
    SCHEDULED, //when all the steps are done
    IN_PROGRESS, // when start the process but kept it is the middle
    COMPLETED, // when the reservation completed, vehicle submitted after service
    CANCELLED; // success reservation cancelled.
}
