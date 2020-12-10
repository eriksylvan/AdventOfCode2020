package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_10
 * https://adventofcode.com/2020/day/10
 */
public class Day_10 {

    public String inputFile = "input\\input_10.txt";
    ArrayList<Integer> adapters = new ArrayList<Integer>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_10.class.getResourceAsStream(inputFile));
        this.adapters = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            this.adapters.add(inputScanner.nextInt());
        }
        inputScanner.close();
        this.adapters.sort(null);
    }

    public int day10PartOne() {
        
        int three = 0;
        int one = 0;

        for (int i = 0; i < adapters.size(); i++) {
            int a;
            if (i == 0) {
                a = adapters.get(i);
            } else {
                a = adapters.get(i) - adapters.get(i - 1);
            }
            if (a == 1)
                one++;
            if (a == 3)
                three++;
        }
        three++; // add three for device
        return one * three;
    }

    public long day10PartTwo() {
        this.adapters.add(this.adapters.get(this.adapters.size()-1)+3); // adding sevice
        this.adapters.add(0);
        this.adapters.sort(null);
        long[] done = new long[this.adapters.size()];
        long ans = connectAdaptor(0, done);
        //printDone(done);
        return ans;
    }

    long connectAdaptor(int c, long[] done) {
        //printDone(done);
        if (done[c]>0)
            return done[c];
        
        long count = 0;
        for (int d = 1; d <= 3; d++) {
            if ((c + d) == adapters.size())
                {
                    done[c] = 1;
                    return 1; // Last adaptor found}
                }
            else if  
                ((c + d) > adapters.size())
                return 0;
            if (adapters.get(c + d) - adapters.get(c) <= 3) {
                count += connectAdaptor(c + d,done);
            }
        }
        done[c] = count;
        return count;
    }

    private void printDone(long[] done) {
        for (long l : done) {
            System.out.print(l+",");
            
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Day_10 day_10 = new Day_10();
        day_10.getInputData();
        int answer1; 
        long answer2;

        answer1 = day_10.day10PartOne();
        answer2 = day_10.day10PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 10\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
Advent of code 2020, Day 10

Solution Part one: 2664
Solution Part two: 148098383347712
*/