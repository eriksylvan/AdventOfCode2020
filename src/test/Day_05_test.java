package test;

import junit.framework.TestCase;
import main.Day_05;
import org.junit.Test;

public class Day_05_test extends TestCase {

    Day_05 day_05 = new Day_05();

    @Test
    public void testPartOne_1() {
        assertEquals(357, day_05.seatId("FBFBBFFRLR"));
        assertEquals(567, day_05.seatId("BFFFBBFRRR"));
        assertEquals(119, day_05.seatId("FFFBBBFRRR"));
        assertEquals(820, day_05.seatId("BBFFBBFRLL"));
    }

    @Test
    public void testSolutionPartOne() {

        day_05.getInputData();
        int expected = 801;
        int actual = day_05.day05PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {

        day_05.getInputData();
        int expected = 597;
        int actual = day_05.day05PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}