package ex44;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProductSearch {
    public static void main(String[] args) {
        // Read file containing JSON
        String rawJSON = readFile("src/main/java/ex44/exercise44_input.txt");
        // Parse JSON file
        Product[] products = parseJSON(rawJSON);
        // Prompt user for product names until one is found
        Scanner scanner = new Scanner(System.in);
        boolean notFound = true;
        while (notFound){
            System.out.print("What is the product name? ");
            String searchName = scanner.nextLine().trim();
            for (Product p : products) {
                if (p.name.equals(searchName)){
                    System.out.println("Name: " + p.name);
                    System.out.println("Price: " + p.price);
                    System.out.println("Quantity: " + p.quantity);
                    notFound = false;
                }
            }
            if (notFound){
                System.out.println("Sorry, that product was not found in our inventory");
            }
        }
        scanner.close();
    }

    public static Product[] parseJSON(String rawJSON){
        // Initialize gson
        Gson gson = new Gson();
        // Generate Products object from JSON
        Products products = gson.fromJson(rawJSON, Products.class);
        // Return parsed product array
        return products.getProducts();
    }

    public static String readFile(String fileName){
        // Read contents of given fileName
        File file = new File(fileName);
        try {
            StringBuilder builder = new StringBuilder();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                builder.append(scanner.nextLine());
            }
            scanner.close();
            return builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
