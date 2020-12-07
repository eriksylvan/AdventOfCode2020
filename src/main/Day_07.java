package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_07
 */
public class Day_07 {

    public String inputFile = "input\\input_07.txt";
    ArrayList<String> bagRules = new ArrayList<String>();
    Map<String, List<BagContent<String, Integer>>> colorMap = new HashMap<String, List<BagContent<String, Integer>>>();

    public class BagContent<T1, T2> {
        public final T1 color;
        public final T2 number;

        private BagContent(T1 t1, T2 t2) {
            this.color = t1;
            this.number = t2;
        }
    }

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_07.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
        // System.out.println(bagRules);
    }

    public int day07PartOne() {
        int count = 0;
        int found = 0;
        for (String str : this.bagRules)
        {
            
            String[] cr = str.split(" bags contain ");

            String color = cr[0];
            List<BagContent<String, Integer>> bagContentList = new ArrayList<BagContent<String, Integer>>();

            if (cr[1].startsWith("no", 0)) {
                System.out.println(color + ": No other bags inside");

            } else {
                String[] contains = cr[1].split(", ");
                //System.out.println(color + ": " + contains.length);

                for (String s : contains) {
                    String[] containSplit = s.split(" ");
                    Integer n = Integer.parseInt(containSplit[0]);
                    String col = containSplit[1] + " " + containSplit[2];
                    //System.out.println(n + " : " + col);

                    bagContentList.add(new BagContent<String, Integer>(col, n));
                }
               
            }
             this.colorMap.put(color, bagContentList);
            //System.out.println("------");
        }

        for (String c : colorMap.keySet()) {
            count++;
            //System.out.println(c);
            if (containsShinyGold(c)) {
                System.out.println(c +  " kan innehålla ShinyGold. ");
                found++;
            }
        }

        System.out.print("Count: "+ count);
        return found;
    }

    private boolean containsShinyGold(String c) {
        boolean contains = false;
        for (BagContent<String, Integer> child : colorMap.get(c)) {
            if (child.color.equals("shiny gold")) {
                contains = true;
                break;
            } else {
                contains = containsShinyGold(child.color);
                if (contains)
                    break;
            }
        }
        return contains;
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
