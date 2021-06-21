package ex45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOps {
    private final String inputFile;
    private final String outputFile;

    public FileOps(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public String readFile(){
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
        File file = new File(outputFile);
        try {
            file.createNewFile();
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
