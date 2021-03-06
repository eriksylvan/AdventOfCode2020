package test;

import junit.framework.TestCase;
import main.Day_10;
import org.junit.Test;

public class Day_10_test extends TestCase {

    Day_10 day_10 = new Day_10();

    @Test
    public void testPartOne_1() {
        day_10.inputFile = "input\\input_10_test1.txt";
        day_10.getInputData();
        int expected = 35;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    
    @Test
    public void testPartOne_2() {
        day_10.inputFile = "input\\input_10_test2.txt";
        day_10.getInputData();
        int expected = 220;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        day_10.inputFile = "input\\input_10_test1.txt";
        day_10.getInputData();
        long expected = 8L;
        long actual = day_10.day10PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        day_10.inputFile = "input\\input_10_test2.txt";
        day_10.getInputData();
        long expected = 19208L;
        long actual = day_10.day10PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_10.inputFile = "input\\input_10.txt";
        day_10.getInputData();
        int expected = 2664;
        int actual = day_10.day10PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testSolutionParTwo() {

        day_10.getInputData();
        long expected = 148098383347712L;
        long actual = day_10.day10PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}

