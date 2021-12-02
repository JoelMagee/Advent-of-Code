package com.joelmagee.adventofcode.day2;

import com.joelmagee.adventofcode.Day;
import com.joelmagee.adventofcode.utils.Direction;
import com.joelmagee.adventofcode.utils.Vector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day2 extends Day {

    List<Vector> vectors = new ArrayList<>();

    public Day2() {
        try (Stream<String> lines = Files.lines(Path.of("src/com/joelmagee/adventofcode/day2/input.txt"))) {
            vectors = lines.map(Vector::fromString).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void PartA() {
        int horizontalPosition = 0;
        int depth = 0;
        for (Vector vector : vectors) {
            int magnitude = vector.getMagnitude();
            Direction direction = vector.getDirection();
            switch (direction) {
                case up -> depth -= magnitude;
                case down -> depth += magnitude;
                case forward -> horizontalPosition += magnitude;
            }
        }
        System.out.printf("Horizontal position: %s, Depth: %s, Result: %s%n", horizontalPosition, depth, horizontalPosition * depth);
    }

    @Override
    public void PartB() {
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;
        for (Vector vector : vectors) {
            int magnitude = vector.getMagnitude();
            Direction direction = vector.getDirection();
            switch (direction) {
                case up -> aim -= magnitude;
                case down -> aim += magnitude;
                case forward -> {
                    horizontalPosition += magnitude;
                    depth += aim * magnitude;
                }
            }
        }
        System.out.printf("Horizontal position: %s, Depth: %s, Aim: %s, Result: %s%n", horizontalPosition, depth, aim, horizontalPosition * depth);
    }
}
