package ex45;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class WordFinderTest {
    private String testOutputFileName = "testOut.txt";
    private String testInputFileName = "src/main/java/ex45/exercise45_input.txt";

    @Test
    @DisplayName("Read File Test")
    public void readFIle(){
        FileOps testOps = new FileOps(testInputFileName, testOutputFileName);
        assertNotNull(testOps.readFile());
    }

    @Test
    @DisplayName("Write File Test")
    public void writeFile(){
        FileOps testOps = new FileOps(testInputFileName, testOutputFileName);
        assertTrue(testOps.writeFile("Test"));
    }

    @Test
    @DisplayName("Replace Word Test")
    public void replaceTest(){
        String testString = "some random text random text";
        assertFalse(WordFinder.replaceWordInString(testString, "random", "predictable").contains("random"));
    }

    @AfterEach
    public void cleanUp(){
        File testOut = new File(testOutputFileName);
        if (testOut.exists()){
            testOut.delete();
        }
    }
}
