package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_20
 */
public class Day_20 {

    public String inputFile = "input\\input_20.txt";
    ArrayList<String> tiles = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_20.class.getResourceAsStream(inputFile));
        this.tiles = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            tiles.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    public int day20PartOne() {
        Map<Integer, Integer[]> tileMap = new HashMap<>();
        int tileNo = 0;
        for (String string : tiles) {
            if (string.length() > 0) {
                if (string.substring(0, 4).equals("Tile")) {
                    tileNo = Integer.parseInt(string.substring(5, 9));
                    System.out.println(tileNo);
                    tileMap.put(tileNo, null);
                }
            }
        }
        System.out.println("Antal bilder: "+tileMap.size());
        int sum = 0;
        return sum;
    }

    public int day20PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_20 day_20 = new Day_20();
        int answer1, answer2;
        day_20.getInputData();

        answer1 = day_20.day20PartOne();

        answer2 = day_20.day20PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 20\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
