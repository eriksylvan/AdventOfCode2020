package test;

import junit.framework.TestCase;
import main.Day_08;
import org.junit.Test;

public class Day_08_test extends TestCase {

    Day_08 day_08 = new Day_08();

    @Test
    public void testPartOne_1() {
        day_08.inputFile = "input\\input_08_test.txt";
        day_08.getInputData();
        int expected = 5;
        int actual = day_08.day08PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_08.getInputData();
        int expected = 1548;
        int actual = day_08.day08PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

