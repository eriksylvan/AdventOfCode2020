package test;

import junit.framework.TestCase;
import main.Day_19;
import org.junit.Test;

public class Day_19_test extends TestCase {

    Day_19 day_19 = new Day_19();

    @Test
    public void testPartOne_1() {
        day_19.inputFile = "input\\input_19_test.txt";
        day_19.getInputData();
        int expected = 2;
        int actual = day_19.day19PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

