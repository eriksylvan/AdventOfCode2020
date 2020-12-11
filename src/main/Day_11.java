package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_11
 */
public class Day_11 {

    public String inputFile = "input\\input_11.txt";
    ArrayList<String> bagRules = new ArrayList<String>();
   
    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_11.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }


    public int day11PartOne() {
        int sum = 0;
        return sum;
    }

    public int day11PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_11 day_11 = new Day_11();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_11.getInputData();
        answer1 = day_11.day11PartOne();
        
        answer2 = day_11.day11PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 11\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
