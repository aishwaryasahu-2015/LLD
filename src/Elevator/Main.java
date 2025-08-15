package Elevator;

public class Main {
    public static void main(String[] args){
        ElevatorSystem elevatorSystem = new ElevatorSystem(3);

        // Request elevator to floor 4
        elevatorSystem.requestElevator(4);
        elevatorSystem.step();
        elevatorSystem.step();


        elevatorSystem.requestElevator(6);
        for (int i = 0; i < 5; i++) {
            elevatorSystem.step();
        }

         //Request elevator to floor 2
        elevatorSystem.requestElevator(2);
        for (int i = 0; i < 6; i++) {
            elevatorSystem.step();
        }
    }
}
