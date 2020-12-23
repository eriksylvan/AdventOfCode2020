package test;

import junit.framework.TestCase;
import main.Day_22;
import org.junit.Test;

public class Day_22_test extends TestCase {

    Day_22 day_22 = new Day_22();

    @Test
    public void testPartOne_1() {
        day_22.inputFile = "input\\input_22_test.txt";
        day_22.getInputData();

        int expected = 306;
        int actual = day_22.day22PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        day_22.inputFile = "input\\input_22_test.txt";
        day_22.getInputData();

        int expected = 291;
        int actual = day_22.day22PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        day_22.inputFile = "input\\input_22_test2.txt";
        day_22.getInputData();

        int expected = 105;
        int actual = day_22.day22PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    
    @Test
    public void testSolutionPartOne() {
        day_22.getInputData();

        int expected = 34664;
        int actual = day_22.day22PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    
    @Test
    public void testSolutionPartTwo() {
        day_22.getInputData();

        int expected = 32018;
        int actual = day_22.day22PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

