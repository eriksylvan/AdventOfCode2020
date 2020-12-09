package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_09
 */
public class Day_09 {

    public String inputFile = "input\\input_09.txt";
    ArrayList<String> bagRules = new ArrayList<String>();
   
    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_09.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }


    public int day09PartOne() {
        int sum = 0;
        return sum;
    }

    public int day09PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_09 day_09 = new Day_09();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_09.day09PartOne();
        
        answer2 = day_09.day09PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 09\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
