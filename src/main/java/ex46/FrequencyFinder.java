package ex46;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FrequencyFinder {
    public static void main(String[] args) {
        // Read input file
        String inputFile = readFile("src/main/java/ex46/exercise46_input.txt");
        // Find frequencies
        ArrayList<WordFrequency> frequencies = getFrequencies(inputFile);

        // Print each word followed by a number of *'s equal to its frequency
        for (WordFrequency frequency : frequencies) {
            System.out.print(frequency.word + ": ");
            for (int i = 0; i < frequency.frequency; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static ArrayList<WordFrequency> getFrequencies(String input){
        ArrayList<WordFrequency> frequencies = new ArrayList<>();
        // Get each token in string
        String[] splitString = input.split(" ");
        // For each string add to the list if it isn't in the list or increment a frequency if already in the list
        for (String s : splitString) {
            if (frequencies.size() == 0){
                frequencies.add(new WordFrequency(s));
            } else {
                boolean found = false;
                for (WordFrequency word : frequencies) {
                    if (word.word.equals(s)) {
                        word.incrementFrequency();
                        found = true;
                    }
                }
                if (!found){
                    frequencies.add(new WordFrequency(s));
                }
            }
        }
        // Sort frequencies in ascending order
        frequencies.sort(Comparator.comparing(wordFrequency -> wordFrequency.frequency));
        // Reverse the list to have the most frequent word first
        Collections.reverse(frequencies);
        return frequencies;
    }

    public static String readFile(String inputFile){
        // Read from given input file
        File file = new File(inputFile);
        StringBuilder content = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                content.append(scanner.nextLine().trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return content.toString();
    }
}
