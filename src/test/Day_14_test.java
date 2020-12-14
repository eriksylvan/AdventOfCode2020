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
        int expected = 9999;
        int actual = day_14.day14PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

