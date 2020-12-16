package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Day_14
 * 
 * https://adventofcode.com/2020/day/14
 */
public class Day_14 {

    public String inputFile = "input\\input_14.txt";
    ArrayList<String> program = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_14.class.getResourceAsStream(inputFile));
        this.program = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            program.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    public long day14PartOne() {
        Map<Integer, Long> memory = new HashMap<Integer, Long>();
        long intMask0 = 0;
        long intMask1 = 0;
        for (String row : program) {
            String com = row.split(" = ")[0];
            String val = row.split(" = ")[1];

            if (com.equals("mask")) {
                // Mask
                String mask0 = val.replace('X', '0');

                String mask1 = val.replace('X', '1');
                intMask0 = Long.parseLong(mask0, 2);
                intMask1 = Long.parseLong(mask1, 2);
            } else {

                int mem = Integer.parseInt(com.substring(4).replaceAll("\\]", ""));
                long v = (Integer.parseInt(val) & intMask1) | intMask0;
                memory.put(mem, v);
                /*
                 * Algoritm: Set '0': Replace x with 1 in Mask code = code & Mask
                 * 
                 * 
                 * Set '1' Replace x with 0 in Mask code = code | Mask
                 */
            }
        }
        long sum = 0;
        for (Long i : memory.values()) {
            // System.out.println(i);
            sum += i;

        }
        return sum;
    }

    public long day14PartTwo() {
        Map<Long, Long> memory = new HashMap<Long, Long>();

        String mask = "";
        ArrayList<String> memPos = null;
        for (String row : program) {

            String com = row.split(" = ")[0];
            String val = row.split(" = ")[1];
            if (com.equals("mask")) {
                // MASK
                mask = val;

            } else {
                // MEM
                int mem = Integer.parseInt(com.substring(4).replaceAll("\\]", ""));
                long v = Integer.parseInt(val);
                String memstr = String.format("%36s", Integer.toBinaryString(mem)).replace(' ', '0');
                StringBuilder sb = new StringBuilder(memstr);
                for (int i = 0; i < mask.length(); i++) {
                    if (mask.charAt(i) == 'X')
                        sb.setCharAt(i, 'X');
                    else if (mask.charAt(i) == '1')
                        sb.setCharAt(i, '1');
                }
                memPos = new ArrayList<String>();
                memstr = sb.toString();
                applyFloatingMask(memstr, 0, memPos);
                for (String m : memPos) {
                    long mp = Long.parseLong(m, 2);
                    memory.put(mp, v);
                }
            }
        }
        long sum = 0;
        for (Long i : memory.values()) {
            sum += i;
        }
        return sum;
    }

    private void applyFloatingMask(String mask, int index, ArrayList<String> memPos) {
        if (index == mask.length()) {
            memPos.add(mask);
            return;
        } else {
            if (mask.charAt(index) == 'X') {
                String m1 = mask.replaceFirst("X", "0");
                String m2 = mask.replaceFirst("X", "1");
                applyFloatingMask(m1, index + 1, memPos);
                applyFloatingMask(m2, index + 1, memPos);
            } else
                applyFloatingMask(mask, index + 1, memPos);
        }
        return;
    }

    public static void main(String[] args) {
        Day_14 day_14 = new Day_14();
        long answer1;
        long answer2;
        day_14.getInputData();
        answer1 = day_14.day14PartOne();

        answer2 = day_14.day14PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 14\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2020, Day 14
 * 
 * Solution Part one: 8471403462063 Solution Part two: 2667858637669
 */

// System.out.println("lenght: " + memory.size());
/*
 * int[] masks = new int[32]; for (int n = 0; n < 32; n++) { masks[n] = 1 << n;
 * }
 * 
 * 
 * int x = 100; System.out.println(Integer.toBinaryString(x));
 * Integer.toString(100,8) // prints 144 --octal representation
 * Integer.toString(100,2) // prints 1100100 --binary representation
 * Integer.toString(100,16) //prints 64 --Hex representation
 * 
 * int foo = Integer.parseInt("1001", 2);
 * 
 * int a = 0b01010111; int b = 0b11111111; //a&b result in 0b01010111
 * 
 * 
 * https://drumcoder.co.uk/blog/2010/jan/06/bitmasks-java/
 * 
 * 
 * Algoritm: Set '0': Replace x with 1 in Mask code = code & Mask
 * 
 * Set '1' Replace x with 0 in Mask code = code | Mask
 * 
 * 
 */