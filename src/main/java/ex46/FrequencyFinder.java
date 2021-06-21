package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class FrequencyFinder {
    public static void main(String[] args) {
        String inputFile = readFile("src/main/java/ex46/exercise46_input.txt");
        ArrayList<WordFrequency> frequencies = getFrequencies(inputFile);

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
        String[] splitString = input.split(" ");
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
        frequencies.sort(Comparator.comparing(wordFrequency -> wordFrequency.frequency));
        Collections.reverse(frequencies);
        return frequencies;
    }

    public static String readFile(String inputFile){
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
