package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_13
 * https://adventofcode.com/2020/day/13
 * 
 */
public class Day_13 {

    public String inputFile = "input\\input_13.txt";
    ArrayList<String> bagRules = new ArrayList<String>();
   
    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_13.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }


    public int day13PartOne() {
        int sum = 0;
        return sum;
    }

    public int day13PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_13 day_13 = new Day_13();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_13.getInputData();
        answer1 = day_13.day13PartOne();
        
        answer2 = day_13.day13PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 13\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
