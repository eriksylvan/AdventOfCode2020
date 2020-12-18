package main;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * Day_16
 */
public class Day_16 {

    public String inputFile = "input\\input_16.txt";
    ArrayList<FieldRule> rules = new ArrayList<FieldRule>();
    ArrayList<Integer> myTicket = new ArrayList<Integer>();
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
                myTicket.add(Integer.parseInt(string));
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

    public long day16PartTwo() {

        List<int[]> invalidTickets = new ArrayList<int[]>();
        for (int[] nt : nerbyTickets) {
            for (int i : nt) {
                boolean invaid = true;
                for (FieldRule fr : rules) {
                    if (fr.check(i))
                        invaid = false;
                }
                if (invaid)
                    invalidTickets.add(nt);
            }
        }
        for (int[] is : invalidTickets) {
            nerbyTickets.remove(is);
        }

        // Init okCount and fill with zeros,
        // Number of valid, ok, positions for every rule
        Map<String, Integer> okCount = new HashMap<String, Integer>();
        for (FieldRule r : this.rules) {
            okCount.put(r.name, 0);
        }

        // för all regler/fält
        for (FieldRule r : this.rules) {
            // för alla positioner (20 st)
            for (int i = 0; i < myTicket.size(); i++) {
                boolean ok = true; // true if rule is fulfilled for all tickets
                // för alla biljetter
                if (ok) {
                    for (int[] t : nerbyTickets) {
                        if (ok) {
                            // kolla om regeln gäller detta fält
                            if (!r.check(t[i])) {
                                ok = false;
                            }
                        }
                    }
                    if (ok)
                        okCount.put(r.name, okCount.get(r.name) + 1); // increase by one
                }
            }
        }
        for (Entry<String, Integer> e : okCount.entrySet()) {
            System.out.println("rule:" + e.getKey() + " -> " + e.getValue());
        }

        Map<String, Integer> sortedOkCount = okCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int index = 0;
        List<Integer> ans = new ArrayList<Integer>();
        for (Entry<String, Integer> e : sortedOkCount.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
            String str = e.getKey().toString();
            if (str.length() >= 9) {
                if (str.substring(0, 9).equals("departure")) {
                    ans.add(myTicket.get(index));
                    System.out.println(index);
                }
            }
            index++;
        }
        System.out.println(ans);
        long e = 1;
        for (Integer i : ans) {
            e = e * i;
        }

        return e;
    }

    public static void main(String[] args) {
        Day_16 day_16 = new Day_16();
        int answer1;
        long answer2;

        day_16.getInputData();
        answer1 = day_16.day16PartOne();

        answer2 = day_16.day16PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 16\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*
That's not the right answer; 
your answer is too low. If you're stuck, 
make sure you're using the full input data; 
there are also some general tips on the about page, 
or you can ask for hints on the subreddit. 
Please wait one minute before trying again. 
(You guessed 627528901543.) [Return to Day 16]
*/