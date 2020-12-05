package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Day_04
 * https://adventofcode.com/2020/day/4
 */

public class Day_04 {

    protected ArrayList<String> pass;
    protected ArrayList<HashMap<String, String>> passPorts = new ArrayList<HashMap<String, String>>();

    public String inputFile = "input\\input_04.txt";

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_04.class.getResourceAsStream(inputFile));
        this.pass = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            pass.add(inputScanner.nextLine());
        }
        pass.add("");
        inputScanner.close();
        buildPassDB();
    }

    private boolean validPassport(HashMap<String, String> passPort) {
        String keys[] = { "byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid" };
        boolean valid = true;
        for (String key : keys) {
            valid = (valid && passPort.containsKey(key));
        }
        return valid;
    }

    private void buildPassDB() {
        HashMap<String, String> passPort = new HashMap<String, String>();
        for (String row : this.pass) {
            if (row.length() == 0) {
                passPorts.add(passPort);
                passPort = new HashMap<String, String>();
            } else {
                String item[] = row.split(",");
                for (String i : item) {
                    String pis[] = i.split(" ");
                    for (String pi : pis) {
                        String pikv[] = pi.split(":");
                        passPort.put(pikv[0], pikv[1]);
                    }
                }
            }
        }
    }

    public int day04PartOne() {
        int validCount = 0;
        for (HashMap<String, String> passPort : this.passPorts) {
            // Check passport valid
            if (validPassport(passPort)) {
                validCount++;
            }
        }

        return validCount;
    }

    public int day04PartTwo() {
        int validCount = 0;
        for (HashMap<String, String> passPort : this.passPorts) {
            // Check passport valid
            boolean byr = false, iyr = false, eyr = false, hgt = false, hcl = false, ecl = false, pid = false;
            if (validPassport(passPort)) {
                int ibyr = Integer.parseInt(passPort.get("byr"));
                byr = (ibyr >= 1920 && ibyr <= 2002);
                int iiyr = Integer.parseInt(passPort.get("iyr"));
                iyr = (iiyr >= 2010 && iiyr <= 2020);
                int ieyr = Integer.parseInt(passPort.get("eyr"));
                eyr = (ieyr >= 2020 && ieyr <= 2030);
                String hgt_str = passPort.get("hgt");
                Pattern p = Pattern.compile("^(\\d*)(cm|in)$");
                Matcher m = p.matcher(passPort.get("hgt"));
                if (m.matches()) {
                    int hgt_val = Integer.parseInt(m.group(1));
                    String hgt_unit = m.group(2);
                    switch (hgt_unit) {
                        case "cm":
                            if (hgt_val >= 150 && hgt_val <= 193)
                                hgt = true;
                            break;
                        case "in":
                            if (hgt_val >= 59 && hgt_val <= 76)
                                hgt = true;
                            break;
                        default:
                            hgt = false;
                            break;
                    }
                } else {
                    hgt = false;
                }

                hcl = Pattern.compile("^#[abcdef1234567890]{6}$").matcher(passPort.get("hcl")).matches();
                ecl = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$").matcher(passPort.get("ecl")).matches();
                pid = Pattern.compile("^[\\d]{9}$").matcher(passPort.get("pid")).matches();
            }
            if (byr && iyr && eyr && hgt && hcl && ecl && pid)
                validCount++;

        }
        return validCount;
    }

    public static void main(String[] args) {
        Day_04 day_04 = new Day_04();
        int answer1, answer2;
        day_04.getInputData();
        System.out.println(day_04.pass);
        answer1 = day_04.day04PartOne();

        answer2 = day_04.day04PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 04\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}


/*

Advent of code 2020, Day 04

Solution Part one: 204
Solution Part two: 179
*/
