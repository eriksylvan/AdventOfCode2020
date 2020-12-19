package main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

/**
 * Day_18
 */
public class Day_18 {

    public String inputFile = "input\\input_18.txt";
    ArrayList<String> expressions = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_18.class.getResourceAsStream(inputFile));
        this.expressions = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            expressions.add(inputScanner.nextLine());
        }
        inputScanner.close();
    }

    public long calculate(String exp) {

        String pf = ShuntingYard.postfix(exp);
        long ans = ShuntingYard.calculatePostfix(pf);
        return ans;
    }

    static class ShuntingYard {

        private enum Operator {
            ADD(1), SUBTRACT(1), MULTIPLY(2), DIVIDE(1);

            final int precedence;

            Operator(int p) {
                precedence = p;
            }
        }

        private static Map<Character, Operator> ops = new HashMap<Character, Operator>() {
            {
                put('+', Operator.ADD);
                put('-', Operator.SUBTRACT);
                put('*', Operator.MULTIPLY);
                put('/', Operator.DIVIDE);
            }
        };

        private static boolean isHigerPrec(Character op, Character sub) {
            return (ops.containsKey(sub) && ops.get(sub).precedence <= ops.get(op).precedence);
        }

        public static String postfix(String infix) {
            infix = infix.replace(" ", "");
            StringBuilder output = new StringBuilder();
            Deque<Character> stack = new LinkedList<>();

            for (Character token : infix.toCharArray()) {
                // operator
                if (ops.containsKey(token)) {
                    // while ( ! stack.isEmpty() && isHigerPrec(token, stack.peek()))
                    while (!stack.isEmpty() && ops.containsKey(stack.peek()))
                        output.append(stack.pop());
                    stack.push(token);

                    // left parenthesis
                } else if (token.equals('(')) {
                    stack.push(token);

                    // right parenthesis
                } else if (token.equals(')')) {
                    while (!stack.peek().equals('('))
                        output.append(stack.pop());
                    stack.pop();

                    // digit
                } else {
                    output.append(token);
                }
            }

            while (!stack.isEmpty())
                output.append(stack.pop());

            return output.toString();
        }

        public static long calculatePostfix(String postfix) {

            long returnValue = 0;

            Stack<String> stack = new Stack<String>();

            for (Character token : postfix.toCharArray()) {
                if (!ops.containsKey(token)) {
                    stack.push(token.toString());
                } else {
                    long a = Long.valueOf(stack.pop());
                    long b = Long.valueOf(stack.pop());
                    switch (ops.get(token)) {
                        case ADD:
                            stack.push(String.valueOf(a + b));
                            break;
                        case SUBTRACT:
                            stack.push(String.valueOf(b - a));
                            break;
                        case MULTIPLY:
                            stack.push(String.valueOf(a * b));
                            break;
                        case DIVIDE:
                            stack.push(String.valueOf(b / a));
                            break;
                    }
                }
            }

            returnValue = Long.valueOf(stack.pop());

            return returnValue;

        }

    }

    public long day18PartOne() {
        long sum = 0;
        int i = 0;
        for (String string : expressions) {
            i++;
            long a = calculate(string);
            sum += a;
            System.out.println(i + ": " + a);
        }

        return sum;
    }

    public long day18PartTwo() {

        long sum = 0;
        int i = 0;
        for (String string : expressions) {
            i++;
            long a = calculate(string);
            sum += a;
            System.out.println(i + ": " + a);
        }

        return sum;

    }

    public static void main(String[] args) {
        Day_18 day_18 = new Day_18();
        day_18.getInputData();
        long answer1, answer2;
        answer1 = day_18.day18PartOne();

        answer2 = day_18.day18PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 18\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * 
 * https://www.geeksforgeeks.org/expression-tree/
 * 
 */

/*
 * That's not the right answer; your answer is too low. (You guessed 675399323.)
 * [Return to Day 18]
 * 
 * (You guessed 4970366619.)
 */