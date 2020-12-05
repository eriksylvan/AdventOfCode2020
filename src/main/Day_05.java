package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Day_05
 */
public class Day_05 {

    String inputFile = "input\\input_05.txt";
    ArrayList<String> seatsBinary = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        this.seatsBinary = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            seatsBinary.add(inputScanner.nextLine());
        }
        inputScanner.close();

    }

    public int seatId(String seat) {
        String row = seat.substring(0, 7);
        String col = seat.substring(7, 10);
        row = row.replace('F', '0').replace('B', '1');
        col = col.replace('L', '0').replace('R', '1');

        int rowDec = Integer.parseInt(row, 2);
        int colDec = Integer.parseInt(col, 2);
        int seatID = rowDec * 8 + colDec;
        return seatID;
    }

    public int day05PartOne() {
        int maxSeatID = -1;
        for (String seat : this.seatsBinary) {
            int seatID = seatId(seat);
            maxSeatID = (seatID > maxSeatID) ? seatID : maxSeatID;
        }

        return maxSeatID;
    }

    public int day05PartTwo() {

        List<Integer> occupied = new ArrayList<Integer>();
        for (String seat : this.seatsBinary) {
            occupied.add(seatId(seat));
        }
        occupied.sort(null);
        int i = occupied.get(0);
        for (int s : occupied) {
            if (i != s)
                return i;
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Day_05 day_05 = new Day_05();
        int answer1, answer2;
        day_05.getInputData();
        answer1 = day_05.day05PartOne();
        // System.out.println(day_05.seatsBinary);
        answer2 = day_05.day05PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 05\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
