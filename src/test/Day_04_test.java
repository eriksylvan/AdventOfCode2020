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

    @Test
    public void testPartTwo_1() {
        
        day_04.inputFile = "input\\input_04_test1.txt";
        day_04.getInputData();    
         int expected = 2;
        int actual = day_04.day04PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_invalid() {
        
        day_04.inputFile = "input\\input_04_test_invalid.txt";
        day_04.getInputData();    
         int expected = 0;
        int actual = day_04.day04PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }   
    
    @Test
    public void testPartTwo_valid() {
        
        day_04.inputFile = "input\\input_04_test_valid.txt";
        day_04.getInputData();    
         int expected = 4;
        int actual = day_04.day04PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartOne() {
        
        day_04.getInputData();    
        int expected = 204;
        int actual = day_04.day04PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testSolutionPartTwo() {
        
        day_04.getInputData();    
        int expected = 179;
        int actual = day_04.day04PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

}


