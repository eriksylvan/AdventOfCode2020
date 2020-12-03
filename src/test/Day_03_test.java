package test;

import junit.framework.TestCase;
import main.Day_03;
import org.junit.Test;

public class Day_03_test extends TestCase {

    main.Day_03 day_03 = new Day_03();

    @Test
    public void testPartOne_1() {
        day_03.inputFile = "input\\input_03_test1.txt";
        day_03.getInputData();
        int expected = 7;
        int actual = day_03.day03PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
        day_03.inputFile = "input\\input_03_test1.txt";
        day_03.getInputData();
        long expected = 336;
        long actual = day_03.day03PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testSolutionPartOne() {
        day_03.getInputData();
        int expected = 200;
        int actual = day_03.day03PartOne();

        assertEquals("expected: " + expected + " actual: " + actual, actual, expected);


        
    }
    @Test
    public void testSolutionPartTwo() {
        day_03.getInputData();
        long expected = 3737923200L;
        long actual = day_03.day03PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }



}

