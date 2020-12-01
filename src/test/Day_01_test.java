package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;
import main.Day_01;

public class Day_01_test extends TestCase {

    main.Day_01 day1 = new Day_01();

    @Test
    public void testPartOne_1() {
        Integer[] input = { 1721, 979, 366, 299, 675, 1456 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 514579;
        int actual = day1.day01PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testPartTwo_1() {
        Integer[] input = { 1721, 979, 366, 299, 675, 1456 };
        ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 241861950;
        int actual = day1.day01PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartOne() {
        ArrayList<Integer> inp = day1.getInputData();
        int expected = 259716;
        int actual = day1.day01PartOne(inp);
        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);
    }

    @Test
    public void testSolutionPartTwo() {
        ArrayList<Integer> inp = day1.getInputData();
        int expected = 120637440;
        int actual = day1.day01PartTwo(inp);

        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);

    }
}
