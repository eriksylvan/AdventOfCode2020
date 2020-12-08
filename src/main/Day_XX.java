package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_XX
 */
public class Day_XX {

    public String inputFile = "input\\input_XX.txt";
    ArrayList<String> bagRules = new ArrayList<String>();
   
    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_XX.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }


    public int dayXXPartOne() {
        int sum = 0;
        return sum;
    }

    public int dayXXPartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_XX day_xx = new Day_XX();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_xx.dayXXPartOne();
        
        answer2 = day_xx.dayXXPartTwo();
        System.out.println("\n\nAdvent of code 2020, Day XX\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
