package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Day_12 https://adventofcode.com/2020/day/12
 */
public class Day_12 {

    public String inputFile = "input\\input_12.txt";
    private ArrayList<String> instructions;

    public void getInputData() {
        getInputData(null);
    }

    public void getInputData(String[] input) {

        if (input == null) {
            instructions = new ArrayList<String>();
            Scanner inputScanner;
            inputScanner = new Scanner(Day_12.class.getResourceAsStream(inputFile));
            instructions = new ArrayList<>();
            while (inputScanner.hasNextLine()) {
                instructions.add(inputScanner.nextLine());
            }
            inputScanner.close();
        } else {
            instructions = new ArrayList<String>(Arrays.asList(input));
        }
    }

    public int day12PartOne() {
        int lon = 0;
        int lat = 0;
        int deg = 90; // 0=north, 90=east, 180=south, 270=west

        for (String inst : instructions) {
            char ch = inst.charAt(0);
            int val = Integer.parseInt(inst.substring(1));
            switch (ch) {
                case 'N':
                    lat += val;

                    break;
                case 'S':
                    lat -= val;

                    break;
                case 'E':
                    lon += val;

                    break;
                case 'W':
                    lon -= val;

                    break;
                case 'L':
                    deg -= val;
                    deg = Math.floorMod(deg, 360);
                    break;
                case 'R':
                    deg += val;
                    deg = Math.floorMod(deg, 360);
                    break;
                case 'F':
                    switch (deg) {
                        case 0:
                            lat += val;
                            break;
                        case 90:
                            lon += val;
                            break;
                        case 180:
                            lat -= val;
                            break;
                        case 270:
                            lon -= val;
                            break;

                        default:

                            break;
                    }

                    break;

                default:
                    break;
            }
            // Action N means to move north by the given value.
            // Action S means to move south by the given value.
            // Action E means to move east by the given value.
            // Action W means to move west by the given value.
            // Action L means to turn left the given number of degrees.
            // Action R means to turn right the given number of degrees.
            // Action F means to move forward by the given value in the direction the ship
            // is currently facing.
            // printInstr(lon, lat, deg, ch, val);
        }
        int dist = Math.abs(lon) + Math.abs(lat);
        return dist;
    }

    private void printInstr(int lon, int lat, int deg, char ch, int val) {
        System.out.print(ch);
        System.out.print("-->");
        System.out.println(val);
        System.out.println("Lon:" + lon);
        System.out.println("Lat:" + lat);
        System.out.println("Degree:" + deg);
    }

    public int day12PartTwo() {
        int lon = 0, lat = 0;
        int wlon = 10, wlat = 1;
        ; // waypoint relative ship

        // int deg = 90; // 0=north, 90=east, 180=south, 270=west

        for (String inst : instructions) {
            char ch = inst.charAt(0);
            int val = Integer.parseInt(inst.substring(1));
            int dlon, dlat;
            double s, c;
            switch (ch) {
                case 'N':
                    wlat += val;

                    break;
                case 'S':
                    wlat -= val;

                    break;
                case 'E':
                    wlon += val;

                    break;
                case 'W':
                    wlon -= val;

                    break;
                case 'R':
                    val = -val;
                case 'L':

                    s = Math.sin(Math.toRadians(val));
                    c = Math.cos(Math.toRadians(val));
                    double nwlon = c * (wlon - lon) - s * (wlat - lat) + lon;
                    double nwlat = s * (wlon - lon) + c * (wlat - lat) + lat;
                    wlon = (int) Math.round(nwlon);
                    wlat = (int) Math.round(nwlat);

                    // rotate point
                    break;
                case 'F':
                    dlon = wlon - lon;
                    dlat = wlat - lat;

                    lon += dlon * val;
                    lat += dlat * val;
                    wlon = lon + dlon;
                    wlat = lat + dlat;
                    break;

                default:
                    break;
            }

        }
        int dist = Math.abs(lon) + Math.abs(lat);
        return dist;
    }

    public static void main(String[] args) {
        Day_12 day_12 = new Day_12();
        int answer1, answer2;
        day_12.getInputData();
        answer1 = day_12.day12PartOne();

        answer2 = day_12.day12PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 12\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}
