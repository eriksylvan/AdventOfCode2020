package test;

import junit.framework.TestCase;
import main.Day_07;
import org.junit.Test;


public class Day_07_test extends TestCase {

    Day_07 day_07 = new Day_07();

    @Test
    public void testPartOne_1() {
        day_07.inputFile = "input\\input_07_test.txt";
        day_07.getInputData();

        int expected = 4;
        int actual = day_07.day07PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_07.getInputData();

        int expected = 233;
        int actual = day_07.day07PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
 
    }


}

