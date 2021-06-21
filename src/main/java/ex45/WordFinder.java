package ex45;

import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the output file: ");
        String outputFilename = scanner.nextLine().trim();

        FileOps fileOperations = new FileOps("src/main/java/ex45/exercise45_input.txt", outputFilename);
        String inputFileContents = fileOperations.readFile();
        String newContents = replaceWordInString(inputFileContents, "utilize", "use");
        fileOperations.writeFile(newContents);
    }

    public static String replaceWordInString(String input, String wordToReplace, String replacementWord) {
        return input.replace(wordToReplace, replacementWord);
    }
}
