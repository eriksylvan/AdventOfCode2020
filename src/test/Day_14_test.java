package test;

import junit.framework.TestCase;
import main.Day_14;
import org.junit.Test;

public class Day_14_test extends TestCase {

    Day_14 day_14 = new Day_14();

    @Test
    public void testPartOne_1() {
        day_14.inputFile = "input\\input_14_test.txt";
        day_14.getInputData();
        long expected = 165L;
        long actual = day_14.day14PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }



    @Test
    public void testPartTwo_1() {
        day_14.inputFile = "input\\input_14_test2.txt";
        day_14.getInputData();
        long expected = 208L;
        long actual = day_14.day14PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_14.inputFile = "input\\input_14.txt";
        day_14.getInputData();
        long expected = 8471403462063L;
        long actual = day_14.day14PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {
        day_14.inputFile = "input\\input_14.txt";
        day_14.getInputData();
        long expected = 2667858637669L;
        long actual = day_14.day14PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

