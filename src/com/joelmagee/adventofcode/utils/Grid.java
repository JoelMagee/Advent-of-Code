package com.joelmagee.adventofcode.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Grid {

    private int[][] values;

    public Grid(String input) {
        String[] rows = input.split("\n");
        size = rows.length;
        values = new int[size][size];
        for (int i = 0; i < size; i++) {
            IntStream a = Arrays.stream(rows[i].split(" ")).filter(x -> !x.isEmpty()).mapToInt(Integer::parseInt);
            values[i] = a.toArray();
        }
    }

    protected int size;

    public int[][] getValues() {
        return values;
    }
}
