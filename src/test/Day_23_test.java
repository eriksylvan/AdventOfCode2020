package test;

import junit.framework.TestCase;
import main.Day_23;
import org.junit.Test;

public class Day_23_test extends TestCase {

    Day_23 day_23 = new Day_23();

    @Test
    public void testPartOne_1() {
        String expected = "92658374";
        String actual = day_23.day23PartOne("389125467", 10);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_2() {
        String expected = "67384529";
        String actual = day_23.day23PartOne("389125467", 100);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        String expected = "25368479";
        String actual = day_23.day23PartOne("326519478", 100);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}

