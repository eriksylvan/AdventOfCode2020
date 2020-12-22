package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import javax.print.event.PrintJobListener;

/**
 * Day_21
 */
public class Day_21 {

    public String inputFile = "input\\input_21.txt";
    public ArrayList<Food> foods = new ArrayList<Food>();
    public ArrayList<String> allegents = new ArrayList<String>();
    public Map<String, ArrayList<String>> ingredientAllergent = new HashMap<String, ArrayList<String>>();
    private Object Collectors;

    public void getInputData() {
        Scanner inputScanner;
        inputScanner = new Scanner(Day_21.class.getResourceAsStream(inputFile));
        this.foods = new ArrayList<>();
        while (inputScanner.hasNextLine()) {
            String foodstr = inputScanner.nextLine();
            String[] ingredients = foodstr.split(" \\(contains ")[0].strip().split(" ");
            String[] allergents = foodstr.split(" \\(contains ")[1].strip().replace(")", "").split(", ");
            foods.add(new Food(ingredients, allergents));
        }
        inputScanner.close();
    }

    protected void listAllegents() {
        for (Food f : foods) {
            for (String a : f.allergents) {
                if (!this.allegents.contains(a))
                    this.allegents.add(a);
            }
        }
    }

    protected void mapIngredientAllergent() {
        for (Food f : this.foods) {
            for (String i : f.ingredients) {
                this.ingredientAllergent.put(i, new ArrayList<>(this.allegents));
            }
        }
    }

    public class Food {
        protected ArrayList<String> ingredients = new ArrayList<String>();
        protected ArrayList<String> allergents = new ArrayList<String>();

        Food(String[] ingredients, String[] allergents) {
            for (String i : ingredients) {
                this.ingredients.add(i);
            }

            for (String a : allergents) {
                this.allergents.add(a);
            }
        }

        @Override
        public String toString() {
            return ingredients.toString() + "( contains: " + allergents.toString() + ")";
        }

        public boolean contains(String ingredient) {
            for (String i : this.ingredients)
                if (i.equals(ingredient))
                    return true;
            return false;
        }

    }

    public int day21PartOne() {

        System.out.println("\nFOOD:");

        for (Food food : foods) {
            System.out.println(food);
        }
        listAllegents();

        System.out.println("\nALLERGENTS:");
        for (String a : allegents) {
            System.out.println(a);
        }

        mapIngredientAllergent();
        System.out.println("\nIgredients:");
        for (Map.Entry<String, ArrayList<String>> ia : this.ingredientAllergent.entrySet()) {
            System.out.println(ia.getKey() + " -> " + ia.getValue().toString());
        }

        // för varje ingrediens ing
        // hitta food f som INTE innehåller ingrediensen ing
        // ta bort alla f's allergener från ing

        System.out.println("\nIgredients under reduction:");
        for (Map.Entry<String, ArrayList<String>> ia : this.ingredientAllergent.entrySet()) {
            String ing = ia.getKey();
            for (Food f : this.foods) {
                if (!f.contains(ing)) {
                    for (String a : f.allergents) {
                        ia.getValue().remove(a);
                    }
                }
            }
        }

        // mapIngredientAllergent();
        System.out.println("\nIgredients after reduction:");
        for (Map.Entry<String, ArrayList<String>> ia : this.ingredientAllergent.entrySet()) {
            System.out.println(ia.getKey() + " -> " + ia.getValue().toString());
        }

        // hitta ingredienser utan allergener
        List<String> nonAllergic = new ArrayList<String>();
        for (Map.Entry<String, ArrayList<String>> ia : this.ingredientAllergent.entrySet()) {
            if (ia.getValue().size() == 0)
                nonAllergic.add(ia.getKey());
        }
        System.out.println("\nNon allergic ingredients:");
        System.out.println(nonAllergic);

        // räkna hur många gånger dessa ingedienser förekommer i all food
        int count = 0;
        for (Food f : foods) {
            count += f.ingredients.stream().filter(nonAllergic::contains).count();
        }

        return count;
    }

    public String day21PartTwo() {
        // Assuming Part 1 was run first

        // Removing empty
        System.out.println("\nonly allergents");
        for (Map.Entry<String, ArrayList<String>> ia : this.ingredientAllergent.entrySet()) {
            if (ia.getValue().size() != 0)
            System.out.println(ia.getKey() + " -> " + ia.getValue().toString());
            
        }
  
    

    int sum = 0;return"abc,def";
    }

    public static void main(String[] args) {
        Day_21 day_21 = new Day_21();
        int answer1;
        String answer2;
        day_21.getInputData();
        answer1 = day_21.day21PartOne();

        answer2 = day_21.day21PartTwo();
        System.out.println("\n\nAdvent of code 2020, Day 21\n");
        System.out.println("Solution Part one: " + answer1);
        System.out.println("Solution Part two: " + answer2 + "\n\n");
    }
}

/*
 * Advent of code 2020, Day 21
 * 
 * Solution Part one: 2282 
 * Solution Part two: vrzkz,zjsh,hphcb,mbdksj,vzzxl,ctmzsr,rkzqs,zmhnj
 */



/*

Maulually solution:
--------------------
zmhnj -> [soy, eggs, dairy]
vzzxl -> [eggs, peanuts]
ctmzsr -> [soy, eggs, sesame]
rkzqs -> [shellfish, soy, eggs, sesame, fish, dairy, peanuts]
hphcb -> [fish, peanuts]
vrzkz -> [dairy]
mbdksj -> [nuts]
zjsh -> [nuts, eggs, dairy]

vrzkz,zjsh,hphcb,mbdksj,vzzxl,ctmzsr,rkzqs,zmhnj

*/