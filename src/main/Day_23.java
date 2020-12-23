package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Day_23
 */
public class Day_23 {

    public String inputFile = "input\\input_23.txt";
    ArrayList<String> bagRules = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_23.class.getResourceAsStream(inputFile));
        this.bagRules = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            bagRules.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    // Structure of a Node
    static class Cup {
        int number;
        Cup previous;
        Cup next;

        Cup(int nr) {
            this.number = nr;
            this.previous = this;
            this.next = this;
        }

        Cup insertAfter(Cup toInsert) {
            toInsert.next = this.next;
            toInsert.previous = this;
            this.next = toInsert;
            return toInsert;
        }

    }

    public String day23PartOne(String input, int turns) {

        Cup currentCup = null;
        int highest = -1;
        for (Character ch : input.toCharArray()) {
            int nr = Integer.parseInt(ch.toString());
            highest = (nr > highest) ? nr : highest;
            Cup c = new Cup(nr);
            if (currentCup != null) {
                currentCup.insertAfter(c);
            }
            currentCup = c;
        }
        currentCup = currentCup.next;

        for (int i = 1; i <= turns; i++) {

            // PickThree
            Cup pick3 = currentCup.next;
            currentCup.next = pick3.next.next.next; // detach pick
            pick3.previous = null;
            pick3.next.next.next = null;

            int destination = (currentCup.number - 1) == 0 ? highest : currentCup.number - 1;

            Cup c = pick3;
            while (c != null) {
                if (c.number == destination) {
                    destination = (destination - 1) == 0 ? highest : destination - 1;
                    c = pick3;
                } else {
                    c = c.next;
                }
            }

            // go to distination
            c = currentCup;
            while (c.number != destination) {
                c = c.next;
            }

            // insert 3 pick
            pick3.next.next.next = c.next;
            pick3.previous = c;
            c.next = pick3;

            currentCup = currentCup.next;

            // find number 1
            System.out.println("Round: " + i);
            Cup a = currentCup;
            for (int j = 0; j < input.length(); j++) {
                System.out.print(a.number + ",");
                a = a.next;
            }
            System.out.println();

        }

        // find number 1
        Cup c = currentCup;
        while (c.number != 1) {
            c = c.next;
        }
        c=c.next;
        String ans = "";
        for (int j = 0; j < input.length()-1; j++) {
            ans = ans + Integer.toString(c.number);
            c=c.next;
        }
        
        return ans;
    }

    public String day23PartTwo() {
        return "";
    }

    public static void main(String[] args) {
        Day_23 day_23 = new Day_23();
        String answer1, answer2;
        // ArrayList<Integer> inp = day_xx.getInputData();
        answer1 = day_23.day23PartOne("326519478", 100);

        answer2 = day_23.day23PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 23\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*Advent of code 2020, Day 23

Solution Part one: 25368479
Solution Part two:

*/
