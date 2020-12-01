package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Day_01 https://adventofcode.com/2020/day/1
 */
public class Day_01 {

    String inputFile = "input/input_01.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        System.out.println("1__getInputData");
        inputScanner = new Scanner(Day_01.class.getResourceAsStream(inputFile));
        System.out.println("2__getInputData");
        ArrayList<Integer> inp = new ArrayList<>();
        System.out.println("3__getInputData");
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        System.out.println("4__getInputData");
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
                    System.out.println("Value: " + a + " + " + b);
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
        /*
         * Set<Integer> usedFrequencies = new HashSet<Integer>();
         * usedFrequencies.add(0); int sum = 0;
         * 
         * while (true) { for (int f : fr) { sum += f; Set<Integer> ff = new
         * HashSet<Integer>(); ff.add(sum); if (usedFrequencies.containsAll(ff)) {
         * return sum; } usedFrequencies.add(sum); } }
         */
        int sum = 0;
        return sum;
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
 * Advent of code 2020, Day 1 Solution Part one: 497 Solution Part two: 558
 */