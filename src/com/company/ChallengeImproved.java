package com.company;

import java.util.*;

public class ChallengeImproved {

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
        }
        else {
            result= item + " " +category;
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> categories = new ArrayList<>(Arrays.asList("rice", "meat", "beans", "salsa", "veggies", "cheese", "guac", "queso", "sourcream"));
        String[] rice = new String[]{"white", "brown", "all"}; /*"none",*/
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
                // Phase 3 tracker part (1)
//                if (!itemsTracker.containsKey(item) && !item.isEmpty()) {
//                    System.out.println(item + " first time");
//                    itemsTracker.put(item, 1);
//                } else {
//                    for (String key : itemsTracker.keySet()) {
//                        int fre = itemsTracker.get(key) + 1;
//                        itemsTracker.put(item, fre);
//                        System.out.println(itemsTracker.get(item) + "tracked");
//                    }
//                }
//            }
                // Phase 3 tracker part (1)

                // Phase 3 tracker part (2)
                int values;
                //System.out.println("i:" + i);
//            sb.append("This order has ");
//            //itemsTracker = new HashMap<>();
//            for (String key : itemsTracker.keySet()) {
//                //sb.append(itemsTracker.get(key) +" " + key);
//                System.out.println("key :" + key + " value:" + itemsTracker.get(key));
//            }
            } // end of inner loop choose n elements for a burritto
            unselectedCategories = new ArrayList<>();
            for (int n = 0; n < 5; n++) {
                if (!selectedCategories.contains(categories.get(n))) {
                    unselectedCategories.add(categories.get(n));
                    burrittoSeries.add("no " + categories.get(n));
                }
            }
            // Adding the price at the end of the list.
            burrittoSeries.add(formattedPrice);
            System.out.println("Burritto:" + i + " " + burrittoSeries.toString().replace("[", "").replace("]", ""));
        }
            itemsTracker.clear();

    }
}

