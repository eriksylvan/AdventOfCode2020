package test;

import junit.framework.TestCase;
import main.Day_13;
import org.junit.Test;

public class Day_13_test extends TestCase {

    Day_13 day_13 = new Day_13();

    @Test
    public void testPartOne_1() {
        day_13.inputFile = "input\\input_13_test.txt";
        day_13.getInputData();
        int expected = 295;
        int actual = day_13.day13PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testPartTwo_1() {
        day_13.inputFile = "input\\input_13_test.txt";
        day_13.getInputData();
        int expected = 1068788;
        int actual = day_13.day13PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_13.getInputData();
        int expected = 8063;
        int actual = day_13.day13PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

