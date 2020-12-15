package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Day_15
 */
public class Day_15 {

    public String inputFile = "input\\input_15.txt";
    ArrayList<String> bagRules = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_15.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    public int day15PartOne(int[] input, int endTurn) {
        HashMap<Integer, Integer[]> game = new HashMap<Integer, Integer[]>();
        // Hash map: game = SpokenNumber -> {lastTurn, age}
        int nr = 0, newnr = 0;

        int l = input.length;
        for (int t = 1; t <= l; t++) {
            game.put(input[t - 1], new Integer[] { t, 0 });
        }
        nr = input[l - 1];
        for (int t = l + 1; t <= endTurn; t++) {
            newnr = game.get(nr)[1];
            // if new number add to list with age 0
            if (game.containsKey(newnr)) {
                game.get(newnr)[1] = t - game.get(newnr)[0];
                game.get(newnr)[0] = t;
            } else {
                game.put(newnr, new Integer[] { t, 0 });
            }
            nr = newnr;
            // System.out.println("Turn: " + t + " -> " + newnr);
        }
        return newnr;
    }

    public int day15PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_15 day_15 = new Day_15();
        int answer1, answer2;
        // ArrayList<Integer> inp = day_15.getInputData();
        int inp[] = { 0, 1, 5, 10, 3, 12, 19 };
        answer1 = day_15.day15PartOne(inp, 2020);

        answer2 = day_15.day15PartOne(inp, 30000000);
        System.out.println("\n\nAdvent of code 2020, Day 15\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2020, Day 15
 * 
 * Solution Part one: 1373 Solution Part two: 112458
 */
