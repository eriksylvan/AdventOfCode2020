package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_06
 */
public class Day_06 {

    public String inputFile = "input\\input_06.txt";
    ArrayList<String> answers = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        this.answers = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            answers.add(inputScanner.nextLine());
        }
        answers.add("");
        inputScanner.close();
        System.out.println(answers);
    }

    public int day06PartOne() {

        int ans = 0;
        Map<Character, Integer> groupAns = new HashMap<Character, Integer>();

        // int groupSize = 0;
        for (String pa : this.answers) {
            // System.out.println(pa);
            if (pa.length() != 0) {
                for (Character ch : pa.toCharArray()) {
                    groupAns.put(ch, 0);
                    // groupSize++;
                }
            } else {
                // New group
                ans += groupAns.size();
                groupAns = new HashMap<Character, Integer>();
            }
        }

        return ans;
    }

    public int day06PartTwo() {
        int ans = 0;
        Map<Character, Integer> groupAns = new HashMap<Character, Integer>();

        int groupSize = 0;
        for (String pa : this.answers) {
            System.out.println(pa);
            if (pa.length() != 0) {
                for (Character ch : pa.toCharArray()) {
                    groupAns.put(ch, groupAns.containsKey(ch) ? groupAns.get(ch) + 1 : 1);

                }
                groupSize++;
            } else {
                // New group
                for (int val : groupAns.values()) {
                    if (val == groupSize)
                        ans++;

                }
                groupAns = new HashMap<Character, Integer>();
                groupSize = 0;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Day_06 Day_06 = new Day_06();
        int answer1, answer2;
        Day_06.getInputData();
        answer1 = Day_06.day06PartOne();

        answer2 = Day_06.day06PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 06\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*
Advent of code 2020, Day 06

Solution Part one: 6742
Solution Part two: 3447
*/
