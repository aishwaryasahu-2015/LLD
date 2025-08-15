package Elevator;

import java.util.LinkedList;
import java.util.Queue;

public class Elevator {
    Queue<Integer> destinationFloors;
    int floor;
    ElevatorStatus elevatorStatus;
    ElevatorDirection elevatorDirection;

    public Elevator(){
        this.destinationFloors = new LinkedList<>();
        this.floor = 0;
        this.elevatorStatus = ElevatorStatus.IDLE;
        this.elevatorDirection = ElevatorDirection.IDLE;
    }
}
