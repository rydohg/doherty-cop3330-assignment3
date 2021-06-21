package ex45;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// FileOps object reads and writes to given input and output files
public class FileOps {
    private final String inputFile;
    private final String outputFile;

    public FileOps(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public String readFile(){
        // Read file and return null if it can't be read
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

    public boolean writeFile(String contents){
        // Write given contents to file
        File file = new File(outputFile);
        try {
            // Create file if it doesn't exist
            file.createNewFile();
            // Write to new file
            FileWriter writer = new FileWriter(outputFile);
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
