package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_08
 */
public class Day_08 {

    String inputFile = "input\\input_08.txt";

    public ArrayList<Integer> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_08.class.getResourceAsStream(inputFile));
        ArrayList<Integer> inp = new ArrayList<>();
        while (inputScanner.hasNextInt()) {
            inp.add(inputScanner.nextInt());
        }
        inputScanner.close();
        return inp;
    }

    public int day08PartOne() {
        int sum = 0;
        return sum;
    }

    public int day08PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_08 day_08 = new Day_08();
        int answer1, answer2;
        //ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_08.day08PartOne();
        
        answer2 = day_08.day08PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day XX\n");    
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
