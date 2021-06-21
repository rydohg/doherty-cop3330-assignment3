package ex41;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOps {
    // Read each line of a given file into a list
    public static ArrayList<String> readFile(String fileName){
        File file = new File(fileName);
        ArrayList<String> names = new ArrayList<>();
        try {
            // Read from file
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                names.add(scanner.nextLine().trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // Return null if cant read file
            return null;
        }
        return names;
    }

    public static boolean writeFile(String fileName, String contents){
        File file = new File(fileName);
        try {
            // Create file
            file.createNewFile();
            // Write to file
            FileWriter writer = new FileWriter(fileName);
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            // If we can't write print error and return false to show it didn't work
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
