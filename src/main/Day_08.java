package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Day_08
 */
public class Day_08 {

    public String inputFile = "input\\input_08.txt";
    List<Instruction> bootCode = new ArrayList<Instruction>();

    public class Instruction {
        public final String op;
        public final int arg;
        public int visited;

        private Instruction(String operation, int argument) {
            this.op = operation;
            this.arg = argument;
            this.visited = 0;
        }

        @Override
        public String toString() { 
            return String.format(op + "\t" + Integer.toString(arg));
        }
    }

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_08.class.getResourceAsStream(inputFile));
        while (inputScanner.hasNextLine()) {
            String op = inputScanner.next();
            int arg = inputScanner.nextInt();
            bootCode.add(new Instruction(op, arg));
        }
        inputScanner.close();
    }

    public int day08PartOne() {
        int nextPos = 0;
        int accumulator = 0;
        boolean infiniteLoop = false;


        while (!infiniteLoop){
            Instruction instr = this.bootCode.get(nextPos);
            if (instr.visited==1){
                infiniteLoop = true;
                break;
            }
            
            switch (instr.op) {
                case "nop": // No operation
                    nextPos ++;
                    break;
                case "acc": // Accumulator
                    accumulator+=instr.arg;
                    nextPos ++;
                    
                    break;
                case "jmp": // Jump
                    nextPos += instr.arg;
                    
                    break;
    
                default:
                    break;
            }
            instr.visited++;        
        }

        return accumulator;
    }

    public int day08PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_08 day_08 = new Day_08();
        int answer1, answer2;
        day_08.getInputData();
        answer1 = day_08.day08PartOne();

        answer2 = day_08.day08PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 08\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
