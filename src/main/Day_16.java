package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Day_16
 */
public class Day_16 {

    public String inputFile = "input\\input_16.txt";
    ArrayList<FieldRule> rules = new ArrayList<FieldRule>();
    ArrayList<String> myTicket = new ArrayList<String>();
    ArrayList<int[]> nerbyTickets = new ArrayList<int[]>();

    private static class FieldRule {
        public String name;
        public List<Integer> min = new ArrayList<Integer>();
        public List<Integer> max = new ArrayList<Integer>();

        FieldRule(String fieldName) {
            this.name = fieldName;

        }

        public void addRule(int min, int max) {
            this.min.add(min);
            this.max.add(max);
        }

        public boolean check(int val) {
            boolean c = false;
            int i = 0;
            while (i < this.min.size() && !c) {
                if (val >= this.min.get(i) && val <= this.max.get(i))
                    c = true;
                i++;
            }
            return c;
        }

    }

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_15.class.getResourceAsStream(inputFile));
        ArrayList<String> input = new ArrayList<String>();
        if (inputScanner.hasNextLine()) {
            String nextLine = inputScanner.nextLine();
            // input.add(nextLine);
            while (!nextLine.isEmpty()) {
                String field = nextLine.split(":")[0];
                String[] ranges = nextLine.split(":")[1].split(" or ");
                System.out.print(field + "-> ");
                FieldRule f = new FieldRule(field);
                this.rules.add(f);

                for (String string : ranges) {
                    System.out.print(string + ", ");
                    int mn = Integer.parseInt(string.strip().split("-")[0]);
                    int mx = Integer.parseInt(string.strip().split("-")[1]);
                    f.addRule(mn, mx);
                }
                System.out.println();
                nextLine = inputScanner.nextLine();

            }
            // your ticket:
            nextLine = inputScanner.nextLine();
            System.out.println(nextLine);
            nextLine = inputScanner.nextLine();
            String[] tick = nextLine.split(",");
            for (String string : tick) {
                System.out.print(string + "-");
            }
            System.out.println();
            nextLine = inputScanner.nextLine();
            // nearby tickets:
            nextLine = inputScanner.nextLine();
            System.out.println(nextLine);
            while (inputScanner.hasNextLine()) {
                nextLine = inputScanner.nextLine();
                // nerbyTickets.add(nextLine.split(","));
                int[] values = Arrays.stream(nextLine.split(",")).mapToInt(Integer::parseInt).toArray();
                nerbyTickets.add(values);
            }
            for (int[] i : nerbyTickets) {
                System.out.print("T:");
                for (int i2 : i) {
                    System.out.print(i2 + "-");
                }
                System.out.println();

            }

        } else {
            System.out.println("No rows found in file");
        }
        inputScanner.close();
        // System.out.println(input);
    }

    public int day16PartOne() {
        int invalidSum = 0;
        for (int[] nt : nerbyTickets) {
           
            for (int i : nt) {
                boolean invaid = true;
                for (FieldRule fr : rules) {
                    if (fr.check(i))
                        invaid = false;
                }
                if (invaid)
                    invalidSum += i;

            }

        }
        return invalidSum;
    }

    public int day16PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_16 day_16 = new Day_16();
        int answer1, answer2;

        day_16.getInputData();
        answer1 = day_16.day16PartOne();

        answer2 = day_16.day16PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 16\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
