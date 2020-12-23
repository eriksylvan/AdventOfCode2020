package main;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Day_22
 * 
 * https://adventofcode.com/2020/day/22
 */

public class Day_22 {

    Deque<Integer> p1 = new LinkedList<>();
    Deque<Integer> p2 = new LinkedList<>();

    public String inputFile = "input\\input_22.txt";

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_22.class.getResourceAsStream(inputFile));
        Deque<Integer> p = p1;
        inputScanner.nextLine(); // Skip fiste line "Player 1"
        while (inputScanner.hasNextLine()) {
            String str = inputScanner.nextLine();
            if (str.length() > 0) {
                if (str.charAt(0) == 'P') {
                    p = p2; // continue with players 2 deck
                } else {
                    p.add(Integer.parseInt(str));
                }
            }
        }

        inputScanner.close();
    }

    public int day22PartOne() {

        Deque<Integer> player1 = new LinkedList<>(this.p1);
        Deque<Integer> player2 = new LinkedList<>(this.p2);

        System.out.println("P1: " + player1);
        System.out.println("P2: " + player2);

        while (!player1.isEmpty() && !player2.isEmpty()) {
            int p1 = player1.removeFirst();
            int p2 = player2.removeFirst();
            if (p1 > p2) {
                player1.addLast(p1);
                player1.addLast(p2);
            } else {
                player2.addLast(p2);
                player2.addLast(p1);
            }

            // System.out.println("P1: " + player1);
            // System.out.println("P2: " + player2);

        }

        Deque<Integer> winner = new LinkedList<>();
        if (player1.isEmpty()) {
            winner = player2;
        } else {
            winner = player1;
        }

        int s = winner.size();
        int sum = 0;

        for (Integer i : winner) {
            sum += s * i;
            s--;
        }

        return sum;

    }

    public int day22PartTwo() {
        Deque<Integer> player1 = new LinkedList<>(this.p1);
        Deque<Integer> player2 = new LinkedList<>(this.p2);

        System.out.println("P1: " + player1);
        System.out.println("P2: " + player2);

        int w = playRecursiveCombat(player1, player2);
        Deque<Integer> winner = new LinkedList<>();
        if (w == 1) {
            winner = player1;
        } else {
            winner = player2;
        }

        int s = winner.size();
        int sum = 0;

        for (Integer i : winner) {
            sum += s * i;
            s--;
        }

        return sum;

    }

    Deque<Integer> copyDeque(Deque<Integer> q, int n) {
        Deque<Integer> cq = new LinkedList<Integer>(q);
        Deque<Integer> nq = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            nq.addLast(cq.pop());
        }
        return nq;
    }

    private int playRecursiveCombat(Deque<Integer> player1, Deque<Integer> player2) {
        List<String> history = new ArrayList<>();

        while (!player1.isEmpty() && !player2.isEmpty()) {
            String deckState = player1.toString() + player2.toString();
            if (history.contains(deckState))
                return 1;
            history.add(deckState);

            int p1 = player1.removeFirst();
            int p2 = player2.removeFirst();

            /*
             * If both players have at least as many cards remaining in their deck as the
             * value of the card they just drew, the winner of the round is determined by
             * playing a new game of Recursive Combat (see below).
             */
            if (player1.size() >= p1 && player2.size() >= p2) {
                int winner = playRecursiveCombat(copyDeque(player1, p1), copyDeque(player2, p2));
                if (winner == 1) {
                    // Player 1 wins
                    player1.addLast(p1);
                    player1.addLast(p2);
                } else {
                    // Player 2 wins
                    player2.addLast(p2);
                    player2.addLast(p1);
                }

            } else if (p1 > p2) {
                // Player 1 wins
                player1.addLast(p1);
                player1.addLast(p2);

            } else if (p2 > p1) {
                // Player 2 wins
                player2.addLast(p2);
                player2.addLast(p1);

            } else {
                // Nt valid place to end up
            }

            // System.out.println("P1: " + player1);
            // System.out.println("P2: " + player2);

        }

        int winner = 0;
        if (player1.isEmpty()) {
            winner = 2;
        } else {
            winner = 1;
        }

        return winner;
    }

    public static void main(String[] args) {
        Day_22 day_22 = new Day_22();
        int answer1, answer2;
        day_22.getInputData();
        answer1 = day_22.day22PartOne();
        answer2 = day_22.day22PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 22\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2020, Day 22
 * 
 * Solution Part one: 34664 Solution Part two: 32018
 * 
 */