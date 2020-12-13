package test;

import junit.framework.TestCase;
import main.Day_13;
import org.junit.Test;

public class Day_13_test extends TestCase {

    Day_13 day_13 = new Day_13();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_13.day13PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

