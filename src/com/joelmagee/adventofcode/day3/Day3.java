package com.joelmagee.adventofcode.day3;

import com.joelmagee.adventofcode.Day;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Day3 extends Day {

    List<String> binNumbers = new ArrayList<>();

    public Day3() {
        try (Stream<String> lines = Files.lines(Path.of("src/com/joelmagee/adventofcode/day3/input.txt"))) {
            binNumbers = lines.toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void PartA() {
        StringBuilder gammaRate = new StringBuilder();
        StringBuilder epsilonRate = new StringBuilder();
        int length = binNumbers.get(0).length();
        for (int i = 0; i < length; i++) {
            int onesCount = 0;
            int zerosCount = 0;
            for (String binNumber : binNumbers) {
                if (binNumber.charAt(i) == '1') {
                    onesCount++;
                } else if (binNumber.charAt(i) == '0') {
                    zerosCount++;
                }
            }
            if (onesCount > zerosCount) {
                gammaRate.append('1');
                epsilonRate.append('0');
            } else {
                gammaRate.append('0');
                epsilonRate.append('1');
            }
        }
        int gammaRateDecimal = Integer.parseInt(gammaRate.toString(), 2);
        int epsilonRateDecimal = Integer.parseInt(epsilonRate.toString(), 2);
        System.out.printf("Epsilon rate: %s, GammaRate: %s, Result: %s%n", gammaRateDecimal, epsilonRateDecimal, gammaRateDecimal * epsilonRateDecimal);
    }

    @Override
    public void PartB() {
        int length = binNumbers.get(0).length();
        List<String> o2GeneratorRatingNumbers = new ArrayList<>(binNumbers);
        List<String> co2ScrubberRatingNumbers = new ArrayList<>(binNumbers);
        for (int i = 0; i < length; i++) {
            o2GeneratorRatingNumbers = filterBinaryNumbers(o2GeneratorRatingNumbers, i, (onesCount, zerosCount) -> onesCount >= zerosCount);
            co2ScrubberRatingNumbers = filterBinaryNumbers(co2ScrubberRatingNumbers, i, (onesCount, zerosCount) -> onesCount < zerosCount);
        }
        int o2GeneratorRating = Integer.parseInt(o2GeneratorRatingNumbers.get(0), 2);
        int co2ScrubberRating = Integer.parseInt(co2ScrubberRatingNumbers.get(0), 2);
        System.out.printf("result %s%n", o2GeneratorRating * co2ScrubberRating);
        System.out.printf("o2 length: %s, o2 first: %s%n", o2GeneratorRatingNumbers.size(), o2GeneratorRatingNumbers.get(0));
        System.out.printf("co2 length: %s, co2 first: %s%n", co2ScrubberRatingNumbers.size(), co2ScrubberRatingNumbers.get(0));
    }

    private List<String> filterBinaryNumbers(List<String> binNumbers, int i, BiPredicate<Integer, Integer> keepOnesPredicate) {
        if (binNumbers.size() == 1) {
            return binNumbers;
        }
        int onesCount = 0;
        int zerosCount = 0;
        List<String> filterableBinNumbers = new ArrayList<>(binNumbers);
        for (String binNumber : filterableBinNumbers) {
            if (binNumber.charAt(i) == '1') {
                onesCount++;
            } else if (binNumber.charAt(i) == '0') {
                zerosCount++;
            }
        }
        char keepChar = keepOnesPredicate.test(onesCount, zerosCount) ? '1' : '0';
        filterableBinNumbers.removeIf(s -> keepChar != s.charAt(i));
        return filterableBinNumbers;
    }
}
