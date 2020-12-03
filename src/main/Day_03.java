package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_03
 */
public class Day_03 {

    public String inputFile = "input\\input_03.txt";
    public ArrayList<String> treeMap;

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_02.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        this.treeMap = inp;
        inputScanner.close();
        return inp;
    }

    public int day03PartOne() {
        
        return slopeHits(3, 1);
    }

    private int slopeHits(int r, int d) {
        int w = treeMap.get(0).length();
        int l = treeMap.size();
        int col = 0;
        int hits = 0;
        for (int row=0; row <l;row+=d)
        {
            if (treeMap.get(row).charAt(col)=='#')
                hits++;
            col = (col+r)%w;
        }
        
        return hits;
    }

    public long day03PartTwo() {
        long hits;
        hits = slopeHits(1, 1);
        hits *= slopeHits(3, 1);
        hits *= slopeHits(5, 1);
        hits *= slopeHits(7, 1);
        hits *= slopeHits(1, 2);
        
        return hits;
    }

    public static void main(String[] args) {
        Day_03 day_03 = new Day_03();
        int answer1; 
        long answer2;
        day_03.getInputData();
        answer1 = day_03.day03PartOne();
        
        answer2 = day_03.day03PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 03\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}



/*

Advent of code 2020, Day 03

Solution Part one: 200
Solution Part two: 3737923200

*/