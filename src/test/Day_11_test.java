package test;

import junit.framework.TestCase;
import main.Day_11;
import org.junit.Test;

public class Day_11_test extends TestCase {

    Day_11 day_11 = new Day_11();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_11.day11PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

