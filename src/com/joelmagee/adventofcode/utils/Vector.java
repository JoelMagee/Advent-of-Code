package com.joelmagee.adventofcode.utils;

public class Vector {

    public Direction getDirection() {
        return direction;
    }

    public int getMagnitude() {
        return magnitude;
    }

    private Direction direction;
    private int magnitude;

    Vector(Direction direction, int magnitude) {
        this.direction = direction;
        this.magnitude = magnitude;
    }

    public static Vector fromString(String input) {
        var tokens = input.split(" ");
        return new Vector(Direction.valueOf(tokens[0]), Integer.parseInt(tokens[1]));
    }

}
