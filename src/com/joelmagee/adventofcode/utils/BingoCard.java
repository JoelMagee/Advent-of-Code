package com.joelmagee.adventofcode.utils;

public class BingoCard extends Grid {

    private boolean[][] marks;
    private int lastMarkedValue;

    public BingoCard(String input) {
        super(input);
        marks = new boolean[size][size];
    }

    public int calculateScore() {
        int unmarkedSum = 0;
        for (int row = 0; row < marks.length; row++) {
            for (int col = 0; col < marks[row].length; col++) {
                if (!marks[row][col]) {
                    unmarkedSum += getValues()[row][col];
                }
            }
        }
        return unmarkedSum * lastMarkedValue;
    }


    public void markCard(int number) {
        int[][] values = getValues();
        for (int row = 0; row < values.length; row++) {
            for (int col = 0; col < values[row].length; col++) {
                if (values[row][col] == number) {
                    marks[row][col] = true;
                    lastMarkedValue = number;
                    return;
                }
            }
        }
    }

    public boolean hasWon() {
        for (int row = 0; row < marks.length; row++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int col = 0; col < marks[row].length; col++) {
                if (!marks[row][col]) {
                    rowWin = false;
                }
                if (!marks[col][row]) {
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                return true;
            }
        }
        return false;
    }

    public void resetMarks() {
        marks = new boolean[size][size];
    }

}
