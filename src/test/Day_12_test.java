package test;

import junit.framework.TestCase;
import main.Day_12;
import org.junit.Test;

public class Day_12_test extends TestCase {

    Day_12 day_12 = new Day_12();

    @Test
    public void testPartOne_1() {
         String[] input  = { "F10", "N3", "F7", "R90", "F11" };

        day_12.getInputData(input);
        int expected = 25;
        int actual = day_12.day12PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testPartTwo_1() {
         String[] input  = { "F10", "N3", "F7", "R90", "F11" };

        day_12.getInputData(input);
        int expected = 286;
        int actual = day_12.day12PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        String[] input  = { "L90", "F1"};

        day_12.getInputData(input);
        int expected = 11;
        int actual = day_12.day12PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    
    @Test
    public void testSolutionPartOne() {
        day_12.getInputData();
        int expected = 439;
        int actual = day_12.day12PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
       
    @Test
    public void testSolutionPartTwo() {
        day_12.getInputData();
        int expected = 12385;
        int actual = day_12.day12PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}
