package test;

import junit.framework.TestCase;
import main.Day_06;
import org.junit.Test;

public class Day_06_test extends TestCase {

    Day_06 day_06 = new Day_06();

    @Test
    public void testPartOne_1() {
        

        day_06.inputFile = "input\\input_06_test.txt";
        day_06.getInputData();
        int expected = 11;
        int actual = day_06.day06PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        day_06.inputFile = "input\\input_06_test.txt";
        day_06.getInputData();
        int expected = 6;
        int actual = day_06.day06PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {

        day_06.getInputData();
        int expected = 6742;
        int actual = day_06.day06PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {

        day_06.getInputData();
        int expected = 3447;
        int actual = day_06.day06PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

