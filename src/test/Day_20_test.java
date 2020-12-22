package test;

import junit.framework.TestCase;
import main.Day_20;
import org.junit.Test;

public class Day_20_test extends TestCase {

    Day_20 day_20 = new Day_20();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_20.day20PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

