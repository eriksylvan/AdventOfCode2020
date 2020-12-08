package test;

import junit.framework.TestCase;
import main.Day_08;
import org.junit.Test;

public class Day_08_test extends TestCase {

    Day_08 day_08 = new Day_08();

    @Test
    public void testPartOne_1() {
        //Integer[] input = { +1, -2, +3, +1 };
        //ArrayList<Integer> indata = new ArrayList<Integer>(Arrays.asList(input));

        int expected = 9999;
        int actual = day_08.day08PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

