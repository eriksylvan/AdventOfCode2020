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
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_2() {
        String input = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        int expected = 437;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_3() {
        String input = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        int expected = 12240;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_4() {
        String input = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        int expected = 13632;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_5() {
        String input = "(1*2*3)*(1+2+3)";
        int expected = 36;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_6() {
        String input = "(7 * 5 * 6 + (9 * 8 + 3 * 3 + 5) + 7)";
        int expected = 447;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_7() {
        String input = "(7 * 5 * 6 + (9 * 8 + 3 * 3 + 5) + 7) * (6 + 3 * 9) + 6 + 7 + (7 * 5) * 4";
        int expected = 145020;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartOne_8() {
        String input = "(8 + 2 * 7 * 2 * (8 + 9)) + 7 * (4 + 4 + 5 * (8 * 9 * 8 + 4) * (8 + 8 * 5)) * 8";
        long expected = 11518707200L;
        long actual = day_18.calculate(input,false);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);

        // 82+7*2*89+*7+44+5+89*8*4+*88+5***8*"
    }

    @Test
    public void testPartTwo_1() {
        String input = "1 + (2 * 3) + (4 * (5 + 6))";
        long expected = 51L;
        long actual = day_18.calculate(input, true);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_2() {
        String input = "    2 * 3 + (4 * 5)";
        long expected = 46L;
        long actual = day_18.calculate(input, true);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_3() {
        String input = "5 + (8 * 3 + 9 + 3 * 4 * 3)";
        long expected = 1445L;
        long actual = day_18.calculate(input, true);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_4() {
        String input = "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))";
        long expected = 669060L;
        long actual = day_18.calculate(input, true);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_5() {
        String input = "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2";
        long expected = 23340L;
        long actual = day_18.calculate(input, true);
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        day_18.getInputData();
        long expected = 7293529867931L;
        long actual = day_18.day18PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {
        day_18.getInputData();
        long expected = 60807587180737L;
        long actual = day_18.day18PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}
//
