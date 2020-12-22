package test;

import junit.framework.TestCase;
import main.Day_21;
import org.junit.Test;

public class Day_21_test extends TestCase {

    Day_21 day_21 = new Day_21();

    

    @Test
    public void testPartOne_1() {
    
        day_21.inputFile = "input\\input_21_test.txt";
        day_21.getInputData();
        
        int expected = 5    ;
        int actual = day_21.day21PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    @Test
    public void testPartTwo_1() {
    
        day_21.inputFile = "input\\input_21_test.txt";
        day_21.getInputData();
        
        String expected = "mxmxvkd,sqjhc,fvjkl";
        String actual = day_21.day21PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }

    
    @Test
    public void testSolutionPartOne() {
        day_21.getInputData();
        int expected = 2282;
        int actual = day_21.day21PartOne();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }


    @Test
    public void testSolutionPartTwo() {
    
        day_21.getInputData();
        
        String expected = "vrzkz,zjsh,hphcb,mbdksj,vzzxl,ctmzsr,rkzqs,zmhnj";
        String actual = day_21.day21PartTwo();
        assertEquals("expected: " + expected + " actual: " + actual, expected, actual);
    }
    
}

