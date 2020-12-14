package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_14
 * 
 * https://adventofcode.com/2020/day/14
 */
public class Day_14 {

    public String inputFile = "input\\input_14.txt";
    ArrayList<String> program = new ArrayList<String>();
   
    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_14.class.getResourceAsStream(inputFile));
        this.program = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            program.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }


    public int day14PartOne() {
        System.out.print(this.program);
        int sum = 0;
        return sum;
    }

    public int day14PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_14 day_14 = new Day_14();
        int answer1, answer2;
        day_14.getInputData();
        answer1 = day_14.day14PartOne();
        
        answer2 = day_14.day14PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 14\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
