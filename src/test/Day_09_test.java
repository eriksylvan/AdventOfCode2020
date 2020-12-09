package test;

import junit.framework.TestCase;
import main.Day_09;
import org.junit.Test;

public class Day_09_test extends TestCase {

    Day_09 day_09 = new Day_09();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_09.day09PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

