package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_07
 */
public class Day_07 {

    public String inputFile = "input\\input_07.txt";
    ArrayList<String> bagRules = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_07.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
        System.out.println(bagRules);
    }

    public int day07PartOne() {
        
        // Split on " bags contain " 
        // regex:
        // (.*) bags contain (.*).
        int sum = 0;
        return sum;
    }

    public int day07PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_07 day_07 = new Day_07();
        int answer1, answer2;
        day_07.getInputData();
        answer1 = day_07.day07PartOne();
        
        answer2 = day_07.day07PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 07\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
