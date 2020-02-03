package com.company;

import java.util.*;

public class Main {
    public static String allItems(String[] str, String item, String category) {
        String result = item;
        StringBuilder sb = new StringBuilder();
        if (result.equalsIgnoreCase("all")) {
            for (String s : str) {
                if (!s.equalsIgnoreCase(item)) {
                    sb.append(s + " ");
                }

            }
            result = "all " + category + "{" + sb + "}";
        } else {
            result = item + " " + category;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList("rice", "meat", "beans", "salsa", "veggies", "cheese", "guac", "queso", "sourcream"));
        String[] rice = new String[]{"white", "brown", "all"};/*none",*/
        String[] meat = new String[]{"chicken", "steak", "carnidas", "chorizo", "sofritas", "fajita meat", "all"};
        String[] beans = new String[]{"pinto", "black", "all"};
        String[] salsa = new String[]{"mild", "medium", "hot", "all"};
        String[] veggies = new String[]{"lettuce", "fajita veggies", "all"};
        ArrayList<String> selectedCategories;
        ArrayList<String> burrittoSeries;
        ArrayList<String> unselectedCategories;
        Map<String, Integer> itemsTracker = new HashMap<>();
        Random rand;
        int itemsInBurritto;
        for (int i = 1; i <= 25; i++) {
            // single burritto processor
            StringBuilder sb;
            String formattedPrice;
            selectedCategories = new ArrayList<>();
            rand = new Random();
            sb = new StringBuilder();
            burrittoSeries = new ArrayList<>();

            //itemsTracker= new ArrayList<String>();
            itemsInBurritto = 5 + rand.nextInt(5);
            String current;
            for (int j = 0; j < itemsInBurritto; j++) {
                current = categories.get(new Random().nextInt(categories.size()));
                if (!selectedCategories.contains(current)) {
                    selectedCategories.add(current);

                } else {
                    j--;
                }
            }// 1st inner for loop ends here
            formattedPrice = String.format(" $%.2f", (itemsInBurritto * .50) + 3.00);
            String item = "";
            for (int k = 0; k < selectedCategories.size(); k++) {

                switch (selectedCategories.get(k).toLowerCase()) {
                    case "rice":
                        item = allItems(rice, rice[rand.nextInt(rice.length)], "rice");
                        burrittoSeries.add(item);
                        break;
                    case "meat":
                        item = allItems(meat, meat[rand.nextInt(meat.length)], "meat");
                        burrittoSeries.add(item);
                        break;
                    case "beans":
                        item = allItems(beans, beans[rand.nextInt(beans.length)], "beans");
                        burrittoSeries.add(item);
                        break;
                    case "salsa":
                        item = allItems(salsa, salsa[rand.nextInt(salsa.length)], "salsa");
                        burrittoSeries.add(item);
                        break;
                    case "veggies":
                        item = allItems(veggies, veggies[rand.nextInt(veggies.length)], "veggies");
                        burrittoSeries.add(item);
                        break;
                    case "cheese":
                        burrittoSeries.add("cheese");
                        break;
                    case "guac":
                        burrittoSeries.add("guac");
                        break;
                    case "queso":
                        burrittoSeries.add("queso");
                        break;
                    case "sourcream":
                        burrittoSeries.add("sour cream");
                        break;
                    default:
                }
            } // end of inner loop choose n elements for a burritto
            unselectedCategories = new ArrayList<>();
            for (int n = 0; n < 5; n++) {
                if (!selectedCategories.contains(categories.get(n))) {
                    unselectedCategories.add(categories.get(n));
                    burrittoSeries.add("no " + categories.get(n));
                }
            }
            // Adding the price at the end of the list.
            Collections.shuffle(burrittoSeries);
            burrittoSeries.add(formattedPrice);
            System.out.println("Burritto:" + i + " " + burrittoSeries.toString().replace("[", "").replace("]", ""));
        }
    }
/* Mule suggestions
       Map<Integer, String> chip = new HashMap<Integer, String>();
        chip.put(1, "Rice");
        chip.put(2, "Meat");
        chip.put(3, "Beans");
        chip.put(4, "Salsa");
        chip.put(5, "Veggies");
        chip.put(6, "Cheese");
        chip.put(7, "Guac");
        chip.put(8, "Queso");
        chip.put(9, "Sour Cream");
        String[] rice = new String[]{"white", "brown", "none", "all"};
        String[] meat = new String[]{"chicken", "steak", "carnidas", "chorizo", "sofritas", " veggie meat", "none", "all"};
        String[] beans = new String[]{"pinto", "black", "none", "all"};
        String[] salsa = new String[]{"mild", "medium", "hot", "none", "all"};
        String[] veggies = new String[]{"lettuce", "fajita veggies", "none", "all"};
        // [Rice ,White]
        Map<String, String> aBurritto = new HashMap<>(); // will hold random ingradients
        Map<String,String> noneChose;
        int x = 5 + rand.nextInt(5); // number of ingradients
        System.out.println("random: " + x);
        double price = (x * .5) + 3.00;
       // System.out.println("burrito before while : " +aBurritto.size());
        while (aBurritto.size() < x) { // enter until it generates x number of valid ingredients,  none is not valid.
         //   System.out.println("size before: "+aBurritto.size());
           // String mainCat=null;
            int catKey = 5 + rand.nextInt(5); //  random selecting the category's index  eg. 1 for rice
            System.out.println(" line 33 cat key:" + catKey);
            //String subCat = null; // actual choise from the groups
            int subNumber;
            System.out.println("value at key "+chip.get(catKey));
            if (!aBurritto.containsKey(chip.get(catKey))) { // eg. has rice type choosen
                System.out.println("if is here");
                String mainCat = chip.get(catKey);
                String subCat="x";
                switch (mainCat.toLowerCase()) { // gives Rice/ Meat
                    case "rice":
                        subNumber = new Random().nextInt(rice.length); // choose index for white or brown or none or all
                        subCat = rice[subNumber];
                        break;
                    case "meat":
                        subNumber = new Random().nextInt(meat.length); // 0
                        subCat = meat[subNumber];  // white
                        break;
                    case "beans":
                        subNumber = new Random().nextInt(beans.length); // 0
                        subCat = beans[subNumber];  // white
                        break;
                    case "salsa":
                        subNumber = new Random().nextInt(salsa.length); // 0
                        subCat = salsa[subNumber];  // white
                        break;
                    case "veggies":
                        subNumber = new Random().nextInt(veggies.length);
                        subCat = veggies[subNumber];
                        break;
                    case "cheese":
                     // subNumber = new Random().nextInt(cheese.length);
                    subCat = "cheese";//[subNumber];
                        break;
                    case "guac":
                        //subNumber = new Random().nextInt(guac.length);
                        subCat = "guac";//[subNumber];
                        break;
                    case "queso":
                        //subNumber = new Random().nextInt(queso.length);
                        subCat = "queso";//queso[subNumber];

                        break;
                    case "sour cream":
                        //subNumber = new Random().nextInt(sourcream.length);
                        subCat = "Sour Cream";// sourcream[subNumber];
                        break;
                    default:
                        System.out.println("never touch me !!!");
                }
                aBurritto.put(mainCat, subCat);
            }
           // System.out.println("mainCat: " + mainCat + "subCat :" + subCat);
            //aBurritto.put(mainCat, subCat);
            //System.out.println("size after: " + aBurritto.size());
        }// end of while

        System.out.println("Hello");
        for (String s : aBurritto.keySet()) {
            System.out.println("key :" + s + " value: " + aBurritto.get(s));
        }
*/
}

