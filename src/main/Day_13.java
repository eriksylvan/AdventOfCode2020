package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * Day_13 https://adventofcode.com/2020/day/13
 * 
 */
public class Day_13 {

    public String inputFile = "input\\input_13.txt";
    ArrayList<Integer> busID;
    Integer ed;

    public void getInputData() {

        busID = new ArrayList<Integer>();
        Scanner inputScanner;
        inputScanner = new Scanner(Day_13.class.getResourceAsStream(inputFile));

        this.ed = Integer.parseInt(inputScanner.nextLine());

        String s = inputScanner.nextLine();

        for (String id : s.split(",")) {
            if (!id.equals("x"))
                this.busID.add(Integer.parseInt(id));
        }
        inputScanner.close();

    }

    public int day13PartOne() {

        System.out.println(this.ed);
        System.out.print(this.busID);
        System.out.println();

        int minDep = Integer.MAX_VALUE;
        int minId =0;
        
        for (Integer i : busID) {
            int dep = 0;
            while (dep < ed) {
                dep += i;
            }

            if (dep < minDep)
            {
                minDep = dep;
                minId = i;
            }
        }
        System.out.println(minDep + " id: " + minId);
        
        return (minDep - ed) * minId;
    }

    public int day13PartTwo() {
       
        /*
        Get some inspiration for Reddit:
        MissMormie
https://github.com/MissMormie/adventOfCode2020/blob/main/src/main/java/days/Day13_ShuttleSearch.java

        */
        int sum = 0;
        return sum;
    }



    public static void main(String[] args) {
        Day_13 day_13 = new Day_13();
        int answer1, answer2;
        day_13.getInputData();
        answer1 = day_13.day13PartOne();

        answer2 = day_13.day13PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 13\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
