package ex42;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {
    public static void main(String[] args) {
        // Read from file
        ArrayList<Record> records = readRecords("src/main/java/ex42/exercise42_input.txt");
        // Print formatted records
        System.out.println(formatRecords(records));
    }

    public static String formatRecords(ArrayList<Record> records) {
        // Find longest names for formatting
        int longestFirst = 0;
        int longestLast = 0;
        for (Record r : records) {
            if (r.firstName.length() > longestFirst){
                longestFirst = r.firstName.length();
            }
            if (r.lastName.length() > longestLast){
                longestLast = r.lastName.length();
            }
        }
        // Create string with all first and last names starting on the same column
        StringBuilder builder = new StringBuilder();
        builder.append("""
                Last      First     Salary
                --------------------------
                """);
        for (Record r : records) {
            builder.append(r.lastName);
            builder.append(" ".repeat(Math.max(0, longestLast - r.lastName.length() + 1)));
            builder.append(r.firstName);
            builder.append(" ".repeat(Math.max(0, longestFirst - r.firstName.length() + 1)));
            builder.append(r.salary).append("\n");
        }
        return builder.toString();
    }

    public static ArrayList<Record> readRecords(String fileName) {
        // Read input file into a list of Records
        File inputFile = new File(fileName);
        ArrayList<Record> records = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(inputFile);
            while (scanner.hasNextLine()){
                String unparsedRecord = scanner.nextLine();
                String[] splitString = unparsedRecord.split(",");
                String lastName = splitString[0];
                String firstName = splitString[1];
                int salary = Integer.parseInt(splitString[2]);
                Record record = new Record(lastName, firstName, salary);
                records.add(record);
            }
        } catch (FileNotFoundException e) {
            // Print error and records is null if it can't read the file
            e.printStackTrace();
        }
        return records;
    }
}
