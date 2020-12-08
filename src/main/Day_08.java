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
    List<Instruction> bootCode2 = new ArrayList<Instruction>();

    public class Instruction {
        public String op;
        public int arg;
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
            bootCode2.add(new Instruction(op, arg));
        }
        inputScanner.close();
    }

    public int day08PartOne() {
        int nextPos = 0;
        int accumulator = 0;
        boolean infiniteLoop = false;

        while (!infiniteLoop) {
            Instruction instr = this.bootCode.get(nextPos);
            if (instr.visited == 1) {
                infiniteLoop = true;
                break;
            }

            switch (instr.op) {
                case "nop": // No operation
                    nextPos++;
                    break;
                case "acc": // Accumulator
                    accumulator += instr.arg;
                    nextPos++;

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

    private int runProgram(List<Instruction> prog) throws Exception {
        int nextPos = 0;
        int accumulator = 0;
        int[] visited = new int[prog.size()];
        boolean infiniteLoop = false;
        while (!infiniteLoop) {
            
            Instruction instr = prog.get(nextPos);
            int currentPos = nextPos;
            if (visited[nextPos] == 1) {
                infiniteLoop = true;
                throw new Exception("Infinite loop. Accumulator: " + Integer.toString(accumulator));
            }
            visited[nextPos]++;
            switch (instr.op) {
                case "nop": // No operation
                    nextPos++;
                    break;
                case "acc": // Accumulator
                    accumulator += instr.arg;
                    nextPos++;

                    break;
                case "jmp": // Jump
                    nextPos += instr.arg;

                    break;

                default:
                    break;
            }
            if ((nextPos==prog.size()) && (currentPos==prog.size()-1))
                break; // Last instruction found
            instr.visited++;
            
        }

        return accumulator;
    }

    public int day08PartTwo() {
        int accumulator = 0;
        for (int i = 0; i<this.bootCode2.size();i++)
        {
            if (this.bootCode2.get(i).op.equals("nop"))
            {
                this.bootCode2.get(i).op = "jmp";
                try {
                    return runProgram(this.bootCode2);
                   
                } catch (Exception e) {
                    //TODO: handle exception
                }
                this.bootCode2.get(i).op = "nop";
                 
            }
            if (this.bootCode2.get(i).op.equals("jmp"))
            {
                this.bootCode2.get(i).op = "nop";
                try {
                    return runProgram(this.bootCode2);
                    
                } catch (Exception e) {
                    //TODO: handle exception
                }
                this.bootCode2.get(i).op = "jmp";                 
            }
        }
        return -1;
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


/*abstract
Advent of code 2020, Day 08

Solution Part one: 1548
Solution Part two: 1375

*/