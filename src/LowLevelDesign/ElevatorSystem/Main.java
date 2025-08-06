package LowLevelDesign.ElevatorSystem;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(1);

        system.handleExternalRequest(3, Direction.DOWN); // [3] down
        system.handleInternalRequest(0, 2); // [6] DOWN
        system.handleExternalRequest(1, Direction.UP); // [3,6,1] -> [1,3,6]
        system.handleInternalRequest(0, 5); // [1,3,5,6]

        for (int i = 0; i < 20; i++) {
            system.step();
        }
    }
}

enum Direction {
    UP, DOWN, IDLE
}

enum DoorStatus {
    OPEN, CLOSED
}

abstract class Request {
    int floor;
    Direction direction;
}

class ExternalRequest extends Request {
    ExternalRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
}

class InternalRequest extends Request {
    InternalRequest(int floor) {
        this.floor = floor;
    }
}

class Elevator {
    private final int id;
    private int currentFloor;
    private Direction direction;
    private DoorStatus doorStatus;
    private final TreeSet<Integer> requestSet;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.doorStatus = DoorStatus.CLOSED;
        this.requestSet = new TreeSet<>();
    }

    public int getId() {
        return id;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void addRequest(Request req) {
        requestSet.add(req.floor);
        updateDirection();
    }

    private void updateDirection() {
        if (requestSet.isEmpty()) {
            direction = Direction.IDLE;
            return;
        }

        if (direction == Direction.IDLE) {
            direction = currentFloor < requestSet.first() ? Direction.UP : Direction.DOWN;
        }
    }

    public void move() {
        if (direction == Direction.IDLE) return;

        if (direction == Direction.UP) {
            Integer nextStop = requestSet.ceiling(currentFloor + 1);
            if (nextStop != null) {
                currentFloor++;
            } else {
                direction = Direction.DOWN;
                return;
            }
        } else if (direction == Direction.DOWN) {
            Integer nextStop = requestSet.floor(currentFloor - 1);
            if (nextStop != null) {
                currentFloor--;
            } else {
                direction = Direction.UP;
                return;
            }
        }

        if (requestSet.contains(currentFloor)) {
            requestSet.remove(currentFloor);
            openDoor();
        }

        if (requestSet.isEmpty()) {
            direction = Direction.IDLE;
        }
    }

    private void openDoor() {
        doorStatus = DoorStatus.OPEN;
        System.out.println("Elevator " + id + " stopped at floor " + currentFloor);
        try {
            Thread.sleep(500); // simulate door open
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        doorStatus = DoorStatus.CLOSED;
    }

    public boolean isIdle() {
        return direction == Direction.IDLE;
    }
}

class ElevatorSystem {
    private final List<Elevator> elevators;

    public ElevatorSystem(int numElevators) {
        elevators = new ArrayList<>();
        for (int i = 0; i < numElevators; i++) {
            elevators.add(new Elevator(i));
        }
    }

    public void handleExternalRequest(int floor, Direction direction) {
        Elevator bestElevator = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.isIdle() || elevator.getDirection() == direction) {
                int distance = Math.abs(elevator.getCurrentFloor() - floor);
                if (distance < minDistance) {
                    minDistance = distance;
                    bestElevator = elevator;
                }
            }
        }

        if (bestElevator != null) {
            bestElevator.addRequest(new ExternalRequest(floor, direction));
        } else {
            elevators.get(0).addRequest(new ExternalRequest(floor, direction));
        }
    }

    public void handleInternalRequest(int elevatorId, int destinationFloor) {
        elevators.get(elevatorId).addRequest(new InternalRequest(destinationFloor));
    }

    public void step() {
        for (Elevator elevator : elevators) {
            elevator.move();
        }
    }
}


