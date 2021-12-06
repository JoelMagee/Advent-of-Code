package com.joelmagee.adventofcode.day4;

import com.joelmagee.adventofcode.Day;
import com.joelmagee.adventofcode.utils.BingoCard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Day4 extends Day {

    List<Integer> bingoNumbers = new ArrayList<>();
    List<BingoCard> bingoCards = new ArrayList<>();

    public Day4() {
        try {
            String content = Files.readString(Path.of("src/com/joelmagee/adventofcode/day4/input.txt"));

            Supplier<Stream<String>> streamSupplier = () -> Arrays.stream(content.split("\n\n"));
            bingoNumbers = streamSupplier.get().findFirst().map(x -> Arrays.stream(x.split(",")).map(Integer::parseInt).toList()).get();
            bingoCards = streamSupplier.get().skip(2).filter(x -> !x.isEmpty()).map(BingoCard::new).toList();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void PartA() {
        for (int number : bingoNumbers) {
            for (BingoCard card : bingoCards) {
                card.markCard(number);
                if (card.hasWon()) {
                    System.out.println(card.calculateScore());
                    return;
                }
            }
        }
    }

    @Override
    public void PartB() {
        for (BingoCard card : bingoCards) {
            card.resetMarks();
        }
        int lastWonScore = 0;
        for (int number : bingoNumbers) {
            for (BingoCard card : bingoCards) {
                if (!card.hasWon()) {
                    card.markCard(number);
                    if (card.hasWon()) {
                        lastWonScore = card.calculateScore();
                    }
                }
            }
        }
        System.out.println(lastWonScore);
    }


}
