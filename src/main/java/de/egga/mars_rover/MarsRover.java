package de.egga.mars_rover;

public class MarsRover {

    private Point position;
    private Direction facing;

    public MarsRover(Point startingPoint, Direction facing) {
        this.position = startingPoint;
        this.facing = facing;
    }

    public MarsRover receiveCommand(char command) {
        if (command == 'f') {
            moveForwards();
        } else if (command == 'b') {
            moveBackwards();
        } else if (command == 'r') {
            turnRight();
        } else if (command == 'l') {
            turnLeft();
        }

        return this;
    }

    private void turnRight() {
        this.facing = facing.getRightHandSide();
    }

    private void turnLeft() {
        this.facing = facing.getLeftHandSide();
    }

    private void moveForwards() {
        Direction direction = this.facing;
        position = position.getNeighbor(direction);
    }
    private void moveBackwards() {
        Direction direction = facing.getOpposite();
        position = position.getNeighbor(direction);
    }

    public Point getPosition() {
        return position;
    }
}
