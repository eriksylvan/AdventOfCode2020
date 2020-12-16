package test;

import junit.framework.TestCase;
import main.Day_16;
import org.junit.Test;

public class Day_16_test extends TestCase {

    Day_16 day_16 = new Day_16();

    @Test
    public void testPartOne_1() {
        day_16.inputFile = "input\\input_16_test.txt";
        day_16.getInputData();
        
        int expected = 71;
        int actual = day_16.day16PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_16.getInputData();
        int expected = 28873;
        int actual = day_16.day16PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

