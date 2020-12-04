package test;

import junit.framework.TestCase;
import main.Day_04;
import org.junit.Test;

public class Day_04_test extends TestCase {

    main.Day_04 day_04 = new Day_04();

    @Test
    public void testPartOne_1() {
        
        day_04.inputFile = "input\\input_04_test1.txt";
        day_04.getInputData();    
         int expected = 2;
        int actual = day_04.day04PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
}

