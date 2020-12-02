package test;

import junit.framework.TestCase;
import main.Day_02;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class Day_02_test extends TestCase {

    main.Day_02 day_02 = new Day_02();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));
        String[] input =
        {"1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"};
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 2;
        int actual = day_02.day02PartOne(indata);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));
        String[] input =
        {"1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"};
        ArrayList<String> indata = new ArrayList<String>(Arrays.asList(input));

        int expected = 1;
        int actual = day_02.day02PartTwo(indata);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        ArrayList<String> inp = day_02.getInputData();
        int expected = 586;
        int actual = day_02.day02PartTwo(inp);

        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);

    }

    @Test
    public void testSolutionPartTwo() {
        ArrayList<String> inp = day_02.getInputData();
        int expected = 352;
        int actual = day_02.day02PartTwo(inp);

        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);

    }

}

