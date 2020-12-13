package test;

import junit.framework.TestCase;
import main.Day_11;
import org.junit.Test;

public class Day_11_test extends TestCase {

    Day_11 day_11 = new Day_11();

    @Test
    public void testPartOne_1() {
        day_11.inputFile = "input\\input_11_test.txt";
        day_11.getInputData();
        int expected = 37;
        int actual = day_11.day11PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

