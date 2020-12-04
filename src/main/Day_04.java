package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.jvm.hotspot.tools.jcore.ByteCodeRewriter;

/**
 * Day_04
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
            if (validPassport(passPort)) {
                int ibyr = Integer.parseInt(passPort.get("byr"));
                boolean byr = (ibyr>=1920 && ibyr<=2002 );
                int iiyr = Integer.parseInt(passPort.get("iyr"));
                int ieyr = Integer.parseInt(passPort.get("eyr"));
                Pattern p = Pattern.compile("(\\d*)(cm|in)");
                Matcher m = p.matcher(passPort.get("hgt"));
                int hgt_val = Integer.parseInt(m.group(1));
                int max_unit = Integer.parseInt(m.group(2));
                boolean hcl = Pattern.compile("^#[abcdef1234567890]{6}$")
                    .matcher(passPort.get("hcl"))
                    .matches();
                boolean ecl = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$")
                    .matcher(passPort.get("ecl"))
                    .matches();
                boolean pid = Pattern.compile("^[\d]{9}$")
                    .matcher(passPort.get("pid"))
                    .matches();


            }
        }

/*
        Pattern p = Pattern.compile("(\\d*)-(\\d*) (.): ([a-z]*)");
            Matcher m = p.matcher(str);
        return validCount;
        byr (Birth Year) - four digits; at least 1920 and at most 2002.
iyr (Issue Year) - four digits; at least 2010 and at most 2020.
eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
hgt (Height) - a number followed by either cm or in:
If cm, the number must be at least 150 and at most 193.
If in, the number must be at least 59 and at most 76.
hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
pid (Passport ID) - a nine-digit number, including leading zeroes.
cid (Country ID) - ignored, missing or not.

*/
int sum = 0;
        return sum;
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
