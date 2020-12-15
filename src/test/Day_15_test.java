package test;

import junit.framework.TestCase;
import main.Day_15;
import org.junit.Test;

public class Day_15_test extends TestCase {

    Day_15 day_15 = new Day_15();

    @Test
    public void testPartOne_1() {
        int inp[] = {0,3,6};
        int expected = 436;
        int actual = day_15.day15PartOne(inp, 2020);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_2() {
        int inp[] = {1,3,2};
        int expected = 1;
        int actual = day_15.day15PartOne(inp, 2020);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    public void testPartOne_3() {
        int inp[] = {3,1,2};
        int expected = 1836;
        int actual = day_15.day15PartOne(inp, 2020);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }    
    
    @Test
    public void testPartTwo_1() {
        int inp[] = {0,3,6};
        int expected = 175594;
        int actual = day_15.day15PartOne(inp, 30000000);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        int inp[] = {0,1,5,10,3,12,19};
        int expected = 1373;
        int actual = day_15.day15PartOne(inp, 2020);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {
        int inp[] = {0,1,5,10,3,12,19};
        int expected = 112458;
        int actual = day_15.day15PartOne(inp, 30000000);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

