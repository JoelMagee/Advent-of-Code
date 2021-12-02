package com.joelmagee.adventofcode.day1;

import com.joelmagee.adventofcode.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Day1 extends Day {

    List<Integer> depthMeasurements = new ArrayList<>();

    public Day1() {
        try (Stream<String> lines = Files.lines(Path.of("src/com/joelmagee/adventofcode/day1/input.txt"))) {
            depthMeasurements = lines.map(Integer::parseInt).toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void PartA() {
        int timesIncreased = 0;
        for (int i = 1; i < depthMeasurements.size(); i++) {
            if (depthMeasurements.get(i) > depthMeasurements.get(i - 1)) {
                timesIncreased++;
            }
        }
        System.out.printf("Times increased: %s%n", timesIncreased);
    }

    @Override
    public void PartB() {
        int timesIncreased = 0;
        for (int i = 3; i < depthMeasurements.size(); i++) {
            if (depthMeasurements.get(i) > depthMeasurements.get(i - 3)) {
                timesIncreased++;
            }
        }
        System.out.printf("Times increased: %s%n", timesIncreased);
    }
}
