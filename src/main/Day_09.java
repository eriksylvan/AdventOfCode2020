package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Day_09
 * https://adventofcode.com/2020/day/9
 */
public class Day_09 {

    public String inputFile = "input\\input_09.txt";
    ArrayList<Long> numbers = new ArrayList<Long>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_09.class.getResourceAsStream(inputFile));
        this.numbers = new ArrayList<>();
        while (inputScanner.hasNextLong()) {
            numbers.add(inputScanner.nextLong());
        }
        inputScanner.close();
    }

    private boolean findSum(long sum, List<Long> preamble) {
        Long s = 0l;
        boolean found = false;
        int l = preamble.size();
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                Long a = preamble.get(i);
                Long b = preamble.get(j);
                s = a + b;
                if (s == sum) {
                    found = true;
                    break;
                }

                if (found == true)
                    break;
            }
            if (found == true)
                break;
        }
        return found;
    }

    public long day09PartOne(int n) {
        boolean f = true;
        long s = 0;

        for (int i = n; ((i < this.numbers.size()) && f); i++) {
            s = numbers.get(n + i);
            f = findSum(s, numbers.subList(i, n + i));
        }

        return s;
    }

    public long day09PartTwo(long inv) {
        ArrayList<Long> accNumbers = new ArrayList<Long>();
        long acc = 0;
        boolean found = false;
        for (long n : numbers) {
            acc += n;
            accNumbers.add(acc);
        }
        int l = 0;
        int h = this.numbers.indexOf(inv);
        long sum = 0;

        for (int a = 0; a < h - 1; a++) {
            for (int b = a + 1; b < h; b++) {
                sum = accNumbers.get(b) - (a <= 0 ? 0 : accNumbers.get(a - 1));
                if (sum > inv)
                    break;
                if (sum == inv) {
                    found = true;
                    l = a;
                    h = b;
                    break;
                }
            }

            if (found)
                break;
        }
        long mx = Long.MIN_VALUE;
        long mn = Long.MAX_VALUE;
        for (long v : numbers.subList(l, h + 1)) {
            mx = v > mx ? v : mx;
            mn = v < mn ? v : mn;
        }

        return mx + mn;
    }

    public static void main(String[] args) {

        Day_09 day_09 = new Day_09();
        day_09.getInputData();
        long answer1, answer2;
        answer1 = day_09.day09PartOne(25);
        answer2 = day_09.day09PartTwo(answer1);

        System.out.println("\n\nAdvent of code 2020, Day 09\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2020, Day 09

Solution Part one: 21806024
Solution Part two: 2986195
*/