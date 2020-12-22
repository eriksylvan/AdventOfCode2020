package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



/**
 * Day_19
 */
public class Day_19 {

    public String inputFile = "input\\input_19.txt";
    TreeMap<Integer, String> rules = new TreeMap<Integer, String>();
    List<String> message = new ArrayList<String>();

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_19.class.getResourceAsStream(inputFile));

        // Read rules,
        while (inputScanner.hasNextLine()) {
            String str = inputScanner.nextLine();
            str = str.replace("\"", "").strip();
            if (str.length() == 0) // empty line
                break;
            String[] r = str.split(": ");
            rules.put(Integer.parseInt(r[0]), r[1]);
            //Map<Integer, String> sortedMap = new TreeMap<Integer, String>(rules);
        }
        // read message
        while (inputScanner.hasNextLine()) {
            String str = inputScanner.nextLine();
            message.add(str);
        }
        inputScanner.close();
    }

    public int day19PartOne() {
        System.out.println("1");

        while (rules.size() > 1) {
            replaceRule();
            System.out.println("#" + rules.size());

        }
        System.out.println("2");
        removeBlanks();
        System.out.println("3");

        Set<String> ruleSet = new HashSet<>(Arrays.asList(rules.get(0).split("\\|")));
        Set<String> messageSet = new HashSet<>(message);
        Set<String> result = new HashSet<>(ruleSet);
        result.retainAll(messageSet);

        System.out.println("Result:");
        for (String string : result) {
            System.out.println(string);
        }
        int sum = result.size();

        return sum;
    }

    private void replaceRule() {
        Integer key = rules.size() - 1;
        // System.out.println("Size: " + rules.size());
        // System.out.println("removing :" + key);
        String irule = rules.get(key);
        rules.remove(key);
        // printRules();
        // System.out.println("Size: " + rules.size());
        // replace with index
        // System.out.println(irule);
        // System.out.println("Key to replace: " + key);
        // System.out.println("Rules to replace with: " + irule);

        for (Map.Entry<Integer, String> r : rules.entrySet()) {

            int i = 0;
            String oldRule = r.getValue();
            String newRule = "";
            Set<String> newRules = new HashSet<String>();
            for (String ruleToReplace : irule.split("\\|")) {
                for (String oldRuleSplitted : oldRule.split("\\|")) {
                    newRule = oldRuleSplitted.replaceAll(key.toString(), ruleToReplace.strip()).strip();
                    newRules.add(newRule);
                }

            }
            newRule = "";
            for (String n : newRules) {
                newRule = newRule + "|" + n;
            }

            newRule = newRule.substring(1);
            rules.put(r.getKey(), newRule);

        }
        // int a = 0;
    }

    private void removeBlanks() {
        for (Map.Entry<Integer, String> entry : rules.entrySet()) {
            entry.setValue(entry.getValue().replaceAll(" ", ""));
        }
    }

    private void printRules() {
        for (Map.Entry<Integer, String> entry : rules.entrySet())
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        System.out.println("----------------");
    }

    public int day19PartTwo() {
        int sum = 0;
        return sum;
    }

    public static void main(String[] args) {
        Day_19 day_19 = new Day_19();
        int answer1, answer2;
        day_19.getInputData();
        answer1 = day_19.day19PartOne();

        answer2 = day_19.day19PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 19\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
