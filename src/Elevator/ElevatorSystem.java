package Elevator;

import java.util.*;

public class ElevatorSystem {
    List<Elevator> elevatorList;
    int totalElevator;
    int requestCount;

    public ElevatorSystem(int elevatorCount){
        this.totalElevator = elevatorCount;
        this.requestCount = 0;
        this.elevatorList = new ArrayList<>();
        for(int i=0;i<totalElevator; i++){
            Elevator elevator = new Elevator();
            this.elevatorList.add(elevator);
        }
    }

    public void step(){
        for(Elevator curElevator: elevatorList){
//            if(curElevator.elevatorDirection == ElevatorDirection.UP){
//                curElevator.floor++;
//            }else if(curElevator.elevatorDirection == ElevatorDirection.DOWN){
//                curElevator.floor--;
//            }else{
                if(curElevator.destinationFloors.isEmpty())
                    continue;
                int curElevatorDestFloor = curElevator.destinationFloors.peek();
                if(curElevatorDestFloor - curElevator.floor == 0){
                    curElevator.destinationFloors.poll();
                    if(curElevator.destinationFloors.isEmpty()){
                        curElevator.elevatorStatus = ElevatorStatus.IDLE;
                        curElevator.elevatorDirection = ElevatorDirection.IDLE;
                        continue;
                    }
                    curElevatorDestFloor = curElevator.destinationFloors.peek();
                }

                if(curElevatorDestFloor - curElevator.floor> 0){
                    curElevator.elevatorStatus = ElevatorStatus.MOVING;
                    curElevator.elevatorDirection = ElevatorDirection.UP;
                    curElevator.floor++;
                }else if(curElevatorDestFloor - curElevator.floor < 0) {
                    curElevator.elevatorStatus = ElevatorStatus.MOVING;
                    curElevator.elevatorDirection = ElevatorDirection.DOWN;
                    curElevator.floor--;
                }
        }

        for(int i=0;i<totalElevator;i++){
            Elevator elevator = this.elevatorList.get(i);
            if(!elevator.destinationFloors.isEmpty())
                System.out.println("Target Floor: " + elevator.destinationFloors.peek());
            System.out.println("elevatorNumber: " + i);
            System.out.println("elevatorStatus: " + elevatorList.get(i).elevatorStatus);
            System.out.println("elevatorDirection: " + elevatorList.get(i).elevatorDirection);
            System.out.println("currentFloor: " + elevatorList.get(i).floor);
            System.out.println("--------------------");
        }
    }

    public void requestElevator(int destFloor){
        Elevator requestedElevator = this.elevatorList.get(this.requestCount%this.totalElevator);
        requestedElevator.destinationFloors.add(destFloor);
        System.out.println("elevatorNumber" + this.requestCount%this.totalElevator);
        System.out.println("destFloor " + destFloor);
        System.out.println("--------------------");
        this.requestCount++;
    }
}
