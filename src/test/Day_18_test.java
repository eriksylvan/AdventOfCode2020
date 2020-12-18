package test;

import junit.framework.TestCase;
import main.Day_18;
import org.junit.Test;

public class Day_18_test extends TestCase {

    Day_18 day_18 = new Day_18();

    @Test
    public void testPartOne_1() {
        String input = "2 * 3 + (4 * 5)";
        int expected = 26;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_2() {
        String input = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        int expected = 437;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_3() {
        String input = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        int expected = 12240;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_4() {
        String input = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        int expected = 13632;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_5() {
        String input = "(1*2*3)*(1+2+3)";
        int expected = 36;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_6() {
        String input = "(7 * 5 * 6 + (9 * 8 + 3 * 3 + 5) + 7)";
        int expected = 447;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_7() {
        String input = "(7 * 5 * 6 + (9 * 8 + 3 * 3 + 5) + 7) * (6 + 3 * 9) + 6 + 7 + (7 * 5) * 4";
        int expected = 145020;
        long actual = day_18.calculate(input);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}
//
