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

    public long day18PartOne() {
        long sum = 0;
        int i =0;
        for (String string : expressions) {
            i++;
            long a = calculate(string);
            sum += a;
        }
        System.out.println(i);
        return sum;
    }

    public long calculate(String exp) {

        String pf = ShuntingYard.postfix(exp);
        long ans = ShuntingYard.calculatePostfix(pf);
        return ans;
    }

    static class ShuntingYard {

        private enum Operator {
            ADD(1), SUBTRACT(1), MULTIPLY(1), DIVIDE(1);

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
                    while ( ! stack.isEmpty() && isHigerPrec(token, stack.peek()))
                    //while (!stack.isEmpty())
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
                    int a = Integer.valueOf(stack.pop());
                    int b = Integer.valueOf(stack.pop());
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
    /*
     * Så länge det finns symboler att läsa: Läs en symbol. Om symbolen är ett tal,
     * lägg till den i slutet av utdatakön. Om symbolen är en funktionssymbol, lägg
     * till den på stacken. Om symbolen är en avskiljare för funktionsargument
     * (vanligtvis ett komma): Hämta operatorer från stacken och lägg till utdatakön
     * tills symbolen högst upp på stacken är en vänsterparentes. Om ingen
     * vänsterparentes hittas så var avskiljaren felplacerad eller så matchar inte
     * uttryckets parenteser varandra. Om symbolen är en operator, o1: Medan det
     * finns en operator, o2, högst upp på stacken och antingen: o1 är associativ
     * eller vänsterassociativ och dess prioritet är lägre än eller lika med o2s
     * prioritet, eller o1 är högerassociativ och dess prioritet är mindre än o2s,
     * hämta o2 från stacken och lägg den på utdatakön lägg o1 på stacken. Om
     * symbolen är en vänsterparentes, lägg den på stacken. Om symbolen är en
     * högerparentes: Tills den översta symbolen på stacken är en vänsterparentes,
     * hämta operatorer från stacken och lägg dem i utdatakön. Hämta
     * vänsterparentesen från stacken, men lägg den inte i utdatakön. Om symbolen
     * högst upp på stacken är en funktionssymbol, lägg den i utdatakön. Om stacken
     * tar slut och ingen vänsterparentes har hittats så matchar inte parenteserna i
     * uttrycket varandra. När alla symboler har lästs in: Medan det finns
     * operatorsymboler på stacken: Om operatorsymbolen högst upp på stacken är en
     * parentes så matchar inte uttryckets parenteser varandra. Lägg operatorn i
     * utdatakön Slut.
     * 
    

    public int calculate(ArrayList<Character> exp) {

        int c = 0;
        while (!exp.isEmpty()) {
            char ch = exp.remove(0);
            switch (ch) {
                case '(':
                    System.out.print("(");
                    c = calculate(exp);

                    break;
                case ')':
                    System.out.print(")");
                    return c;

                case '+':
                    System.out.print("+");
                    c = c + calculate(exp);

                    break;
                case '*':
                    System.out.print("*");
                    c = c * calculate(exp);

                    break;
                default:

                    c = Character.getNumericValue(ch);
                    System.out.print(c);

            }
        }

        return c;
    }
 */
    public int day18PartTwo() {
        int sum = 0;
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
 That's not the right answer; your answer is too low. (You guessed 675399323.) [Return to Day 18]

(You guessed 4970366619.) */