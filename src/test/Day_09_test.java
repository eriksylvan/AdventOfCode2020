package test;

import junit.framework.TestCase;
import main.Day_09;
import org.junit.Test;

public class Day_09_test extends TestCase {

    Day_09 day_09 = new Day_09();

    @Test
    public void testPartOne_1() {
        day_09.inputFile = "input\\input_09_test.txt";
        day_09.getInputData();
        long expected = 127l;
        long actual = day_09.day09PartOne(5);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        day_09.inputFile = "input\\input_09_test.txt";
        day_09.getInputData();
        long expected = 62l;
        long actual = day_09.day09PartTwo(127);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testSolutionOne_1() {
        day_09.getInputData();
        long expected = 21806024L;
        long actual = day_09.day09PartOne(25);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionTwo_1() {
        day_09.getInputData();
        long expected = 2986195L;
        long actual = day_09.day09PartTwo(21806024L);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

