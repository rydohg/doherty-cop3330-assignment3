package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOps {
    public static ArrayList<String> readFile(String fileName){
        File file = new File(fileName);
        ArrayList<String> names = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                names.add(scanner.nextLine().trim());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            return null;
        }
        return names;
    }

    public static boolean writeFile(String fileName, String contents){
        File file = new File(fileName);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(fileName);
            writer.write(contents);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
