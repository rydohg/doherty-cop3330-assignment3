package ex41;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter {
    public static void main(String[] args) {
        // Read names from file
        ArrayList<String> names = FileOps.readFile("exercise41_input.txt");
        if (names != null) {
            // Sort names
            String sortedNames = sort(names);
            // Write sorted names to output file
            FileOps.writeFile("exercise41_output.txt", sortedNames);
            // Print output according to exercise specification
            System.out.println("Total of " + names.size() + " names\n--------------------------");
            System.out.println(sortedNames);
            // Tell user where it wrote to
            System.out.println("Wrote to " + System.getProperty("user.dir") + "/exercise41_output.txt");
        }
    }
    public static String sort(ArrayList<String> names){
        // Sort names
        Collections.sort(names);
        // Turn list of names into single string
        StringBuilder builder = new StringBuilder();
        for (String name : names) {
            builder.append(name).append("\n");
        }
        return builder.toString();
    }
}
