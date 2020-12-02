package main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day_02
 */
public class Day_02 {

    String inputFile = "input\\input_02.txt";

    public ArrayList<String> getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_02.class.getResourceAsStream(inputFile));
        ArrayList<String> inp = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            inp.add(inputScanner.nextLine());
        }
        inputScanner.close();
        return inp;
    }

    /*
     * 3-4 t: dttt 5-7 l: llmlqmblllh
     */

    public int day02PartOne(ArrayList<String> input) {
        int validPwd = 0;
        for (String str : input) {
            Pattern p = Pattern.compile("(\\d*)-(\\d*) (.): ([a-z]*)");
            Matcher m = p.matcher(str);

            if (m.find()) {
                int min = Integer.parseInt(m.group(1));
                int max = Integer.parseInt(m.group(2));
                char ch = m.group(3).charAt(0);
                String pwd = m.group(4);
                int n = 0;
                for (int i = 0; i < pwd.length(); i++) {
                    char c = pwd.charAt(i);
                    if (c == ch)
                        n++;
                }
                if (n >= min && n <= max) {
                    validPwd++;
                }

            } else {
                System.out.println("NO MATCH");
            }

        }

        return validPwd;
    }

    public int day02PartTwo(ArrayList<String> input) {
        int validPwd = 0;
        for (String str : input) {
            Pattern p = Pattern.compile("(\\d*)-(\\d*) (.): ([a-z]*)");
            Matcher m = p.matcher(str);

            if (m.find()) {
                int min = Integer.parseInt(m.group(1));
                int max = Integer.parseInt(m.group(2));
                char ch = m.group(3).charAt(0);
                String pwd = m.group(4);
                int n = 0;

                if (pwd.charAt(min - 1) == ch)
                    n++;
                if (pwd.charAt(max - 1) == ch)
                    n++;

                if (n == 1)
                    validPwd++;
            } else {
                System.out.println("NO MATCH");
            }

        }

        return validPwd;
    }

    public static void main(String[] args) {
        Day_02 day_02 = new Day_02();
        int answer1, answer2;
        ArrayList<String> inp = day_02.getInputData();

        answer1 = day_02.day02PartOne(inp);

        answer2 = day_02.day02PartTwo(inp);
        System.out.println("\n\nAdvent of code 2020, Day 02\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
