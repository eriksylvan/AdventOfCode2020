package main;

import java.util.ArrayList;
import java.util.Scanner;


import java.io.Console;
import java.lang.System;

/**
 * Day_11
 */
public class Day_11 {

    public String inputFile = "input\\input_11.txt";
    ArrayList<String> seatMap = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_11.class.getResourceAsStream(inputFile));
        this.seatMap = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String seats = inputScanner.nextLine();
            seatMap.add('.' + seats + '.');
        }

        addEmptyRows(seatMap);

        inputScanner.close();
    }

    private void addEmptyRows(ArrayList<String> m) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < m.get(0).length(); i++) {
            s.append(".");
        }
        String floor = s.toString();
        m.add(0, floor);
        m.add(floor);
    }

    public int day11PartOne() {
        boolean nextTurn = true;
        int turn = 1;
        int rows = this.seatMap.size();
        int columns = this.seatMap.get(0).length();
        while (nextTurn) {
            //printTurn(turn, seatMap);
            // make a turn
            char[] p = new char[8];
            char current = '.';
            ArrayList<String> uppdatedSeatMap = new ArrayList<String>();
            // Find surounding seat status
            for (int ro = 1; ro < rows - 1; ro++) {
                StringBuilder uppdatedSeatRow = new StringBuilder();
                for (int co = 1; co < columns - 1; co++) {
                    p[0] = this.seatMap.get(ro - 1).charAt(co - 1);
                    p[1] = this.seatMap.get(ro - 1).charAt(co);
                    p[2] = this.seatMap.get(ro - 1).charAt(co + 1);

                    p[3] = this.seatMap.get(ro).charAt(co - 1);
                    current = this.seatMap.get(ro).charAt(co); // Place under evaluation
                    p[4] = this.seatMap.get(ro).charAt(co + 1);

                    p[5] = this.seatMap.get(ro + 1).charAt(co - 1);
                    p[6] = this.seatMap.get(ro + 1).charAt(co);
                    p[7] = this.seatMap.get(ro + 1).charAt(co + 1);

                    char upd = current;
                    switch (current) {
                        case 'L':
                            // If a seat is empty (L) and there are no occupied seats adjacent to it, the
                            // seat becomes occupied.
                            if (noNeighbours(p))
                                upd = '#';
                            break;
                        case '#':
                            if (fourNeighbours(p))
                                upd = 'L'; // If a seat is occupied (#) and four or more seats adjacent to it are also
                                           // occupied, the seat becomes empty.

                            break;
                        case '.':
                            // Otherwise, the seat's state does not change.
                            break;

                        default:
                            break;
                    }
                    uppdatedSeatRow.append(upd);
                }
                uppdatedSeatMap.add('.' + uppdatedSeatRow.toString() + '.');
            }
            addEmptyRows(uppdatedSeatMap);
            //printTurn(turn, uppdatedSeatMap);
            boolean equal = true; // Assume equal until oposit is prooven
            int i = 0;
            while (equal && i < seatMap.size()) {
                equal = seatMap.get(i).equals(uppdatedSeatMap.get(i));
                i++;
            }

            seatMap = uppdatedSeatMap;
            nextTurn = !equal;
            turn ++;

        }
        int count=0;
        for (String row : seatMap) {
            for (char ch : row.toCharArray()) {
                count += (ch=='#'?1:0);
            }
        }

        return count;
    }

    private boolean noNeighbours(char[] p) {
        int count = 0;
        for (char c : p)
            count += (c == '#' ? 1 : 0);
        return count == 0;
    }


    private boolean fourNeighbours(char[] p) {
        int count = 0;
        for (char c : p)
            count += (c == '#' ? 1 : 0);
        return count >= 4;
    }

    private void printTurn(int turn, ArrayList<String> map) {
        System.out.println("\n\nTURN #: " + turn + "\n__________");
        for (String row : map) {
            System.out.println(row);
        }
    }

    public int day11PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_11 day_11 = new Day_11();
        int answer1, answer2;
        day_11.getInputData();
        answer1 = day_11.day11PartOne();

        answer2 = day_11.day11PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 11\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2020, Day 11

Solution Part one: 2093
Solution Part two: 0
*/