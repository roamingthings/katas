package de.egga;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
    SOUTH, NORTH, EAST, WEST;

    private static Map<Direction, Direction> opposites = new HashMap<>();
    private static Map<Direction, Direction> rightHandSides = new HashMap<>();
    private static Map<Direction, Direction> leftHandSides = new HashMap<>();

    static {
        registerOpposites();
        registerRightHandSides();
        registerLeftHandSides();
    }

    public Direction getOpposite() {
        return getMapping(opposites, "Opposite");
    }

    public Direction getRightHandSide() {
        return getMapping(rightHandSides, "right hand side");
    }

    public Direction getLeftHandSide() {
        return getMapping(leftHandSides, "left hand side");
    }


    private Direction getMapping(Map<Direction, Direction> map, String description) {
        if (map.containsKey(this)) {
            return map.get(this);
        } else {
            throw new RuntimeException("Your direction seems to have no " + description);
        }
    }

    private static void registerOpposites() {
        opposites.put(NORTH, SOUTH);
        opposites.put(EAST, WEST);
        opposites.put(SOUTH, NORTH);
        opposites.put(WEST, EAST);
    }

    private static void registerRightHandSides() {
        rightHandSides.put(NORTH, EAST);
        rightHandSides.put(EAST, SOUTH);
        rightHandSides.put(SOUTH, WEST);
        rightHandSides.put(WEST, NORTH);
    }

    private static void registerLeftHandSides() {
        leftHandSides.put(NORTH, WEST);
        leftHandSides.put(EAST, NORTH);
        leftHandSides.put(SOUTH, EAST);
        leftHandSides.put(WEST, SOUTH);
    }
}
