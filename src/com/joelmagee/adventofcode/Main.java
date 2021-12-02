package com.joelmagee.adventofcode;

import com.joelmagee.adventofcode.day1.Day1;
import com.joelmagee.adventofcode.day2.Day2;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Day> days = List.of(new Day1(), new Day2());
        days.forEach(day -> {
            System.out.println(day.getClass().getSimpleName());
            day.PartA();
            day.PartB();
            System.out.println();
        });
    }
}
