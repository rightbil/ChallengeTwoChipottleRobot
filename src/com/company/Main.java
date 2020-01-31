package com.company;

import javax.crypto.Cipher;
import java.util.*;

public class Main {


    public static void main(String[] args) {

        ArrayList<String> allIngradients = new ArrayList<>(
                Arrays.asList("Rice", "Meat", "Beans", "Salsa", "Veggies", "Cheese", "Guac", "Queso", "SourCream")
        );
        String[] rice = new String[]{"white", "brown", "none", "all"};
        String[] meat = new String[]{"chicken", "steak", "carnidas", "chorizo", "sofritas", "fajita veggies", "none", "all"};
        String[] beans = new String[]{"pinto", "black", "none", "all"};
        String[] salsa = new String[]{"mild", "medium", "hot", "none", "all"};
        String[] veggies = new String[]{"lettuce", "fajita veggies", "none", "all"};
        ArrayList<String> fixedList;//ew ArrayList<>();

        // the number of ingredients for a Buritto (min 5 and max 9]
        int numberOfUserChoice;
        //random generating object
        Random rand;
        // ingredients the rohbot will choose
        String rices;
        String meats;
        String b;
        String s;
        String v;
        StringBuilder sb; // = new StringBuilder();
        String formattedPrice;
        String NONE = "none";
        double price;
        System.out.println("testing ....");
        // the outer loop runs for each Burittos series
        //number of ingrediet choosen has to be reset
        for (int series = 1; series < 26; series++) {
            // generate 5 t0 9 user chose of ingradients
            fixedList = new ArrayList<>();
            rand = new Random();
            sb = new StringBuilder();
            numberOfUserChoice = 5 + rand.nextInt(5); // gives  fixed
            String current;
            for (int i = 0; i < numberOfUserChoice; i++) { // shall be unique
                current = allIngradients.get(rand.nextInt(allIngradients.size()));
                while (!fixedList.contains(current)) {
                    fixedList.add(current);
                    current = allIngradients.get(rand.nextInt(allIngradients.size()));
                }
            }// 1st inner for loop ends here

            formattedPrice = String.format(" $%.2f", (numberOfUserChoice * .50) + 3.00);
             for (int i = 0; i < fixedList.size(); i++) {
                switch (allIngradients.get(i).toLowerCase()) { // gives Rice/ Meat
                    case "rice":
                        rices = rice[rand.nextInt(rice.length)] + " rice";
                        if (rices.equalsIgnoreCase(NONE)) {
                            i--;
                        }
                        sb.append(rices);

                        break;
                    case "meat":
                        meats = meat[rand.nextInt(meat.length)] + " meat";
                        if (meats.equalsIgnoreCase(NONE)) {

                            i--;
                        }


                            sb.append(", " + meats);

                        break;
                    case "beans":
                        b = beans[rand.nextInt(beans.length)] + " beans";
                        if (b.equalsIgnoreCase(NONE)) {

                            i--;
                        }
//

                            sb.append(", " + b);

                        break;
                    case "salsa":
                        s = salsa[rand.nextInt(salsa.length)] + " salsa";
                        if (s.equalsIgnoreCase(NONE)) {

                            i--;
                        }

                            sb.append(", " + s);
                        //}
                        break;
                    case "veggies":
                          v = veggies[rand.nextInt(veggies.length)] ;// + " veggies";
                        if (v.equalsIgnoreCase("fajita veggies")) {
                            v = v;
                        } else {
                            v = v + " veggies";
                        }

                        // for the null case

                        if (v.equalsIgnoreCase(NONE)) {

                            i--;
                        }


                            sb.append(", " + v);

                        break;
                    case "cheese":
                        sb.append(", cheese");

                        break;
                    case "guac":
                        sb.append(", guac");

                        break;
                    case "queso":
                        sb.append(", queso");

                        break;
                    case "sourcream":
                        sb.append(", sour cream");

                        break;
                    default:
                }
            }// End of while loop
            System.out.println("Burrito:" + series + " " + sb.append(formattedPrice));//.toString().replace("none", " no"));



        } // outer loop ends
    }

}
