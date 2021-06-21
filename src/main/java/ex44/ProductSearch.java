package ex44;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductSearch {
    public static void main(String[] args) {
        String rawJSON = readFile("src/main/java/ex44/exercise44_input.txt");
        Product[] products = parseJSON(rawJSON);
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
        Gson gson = new Gson();
        Products products = gson.fromJson(rawJSON, Products.class);
        return products.getProducts();
    }

    public static String readFile(String fileName){
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
