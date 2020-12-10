package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_01 https://adventofcode.com/2020/day/1
 */
public class Day_01 {

    public String inputFile = "input\\input_01.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_01.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day01PartOne(ArrayList<Integer> fr) {
        int p = 0;
        boolean found = false;

        int l = fr.size();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int a = fr.get(i);
                int b = fr.get(j);
                if (a + b == 2020) {
                    // System.out.println("Value: " + a + " + " + b);
                    p = a * b;
                    found = true;
                    break;
                }
            }
            if (found == true)
                break;
        }
        return p;
    }

    public int day01PartTwo(ArrayList<Integer> fr) {
        int p = 0;
        boolean found = false;

        int l = fr.size();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    int a = fr.get(i);
                    int b = fr.get(j);
                    int c = fr.get(k);

                    if (a + b + c == 2020) {
                        System.out.println("Value: " + a + " + " + b + " + " + c);
                        p = a * b * c;
                        found = true;
                        break;
                    }
                }
                if (found == true)
                break;
            }
            if (found == true)
                break;
        }
        return p;
    }

    public static void main(String[] args) {
        System.out.println("Advent of code 2020, Day 1\n");
        Day_01 day_01 = new Day_01();
        int answer1, answer2;
        ArrayList<Integer> inp = day_01.getInputData();
        answer1 = day_01.day01PartOne(inp);
        System.out.println("Solution Part one: " + answer1);
        answer2 = day_01.day01PartTwo(inp);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Value: 138 + 1882
Solution Part one: 259716
Value: 272 + 308 + 1440
Solution Part two: 120637440
*/