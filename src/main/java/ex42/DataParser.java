package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataParser {
    public static void main(String[] args) {
        ArrayList<Record> records = readRecords("src/main/java/ex42/exercise42_input.txt");
        System.out.println(formatRecords(records));
    }

    public static String formatRecords(ArrayList<Record> records) {
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
            e.printStackTrace();
        }
        return records;
    }
}
