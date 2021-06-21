package ex45;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class WordFinderTest {
    private String testOutputFileName = "testOut.txt";
    private String testInputFileName = "exercise45_input.txt";

    @Test
    @DisplayName("Read File Test")
    public void readFIle(){
        // Test if we can read the file
        FileOps testOps = new FileOps(testInputFileName, testOutputFileName);
        assertNotNull(testOps.readFile());
    }

    @Test
    @DisplayName("Write File Test")
    public void writeFile(){
        // Test if we can write to an output file
        FileOps testOps = new FileOps(testInputFileName, testOutputFileName);
        assertTrue(testOps.writeFile("Test"));
    }

    @Test
    @DisplayName("Replace Word Test")
    public void replaceTest(){
        // Test if the given word gets replaced
        String testString = "some random text random text";
        assertFalse(WordFinder.replaceWordInString(testString, "random", "predictable").contains("random"));
    }

    @AfterEach
    public void cleanUp(){
        // Cleanup test output file
        File testOut = new File(testOutputFileName);
        if (testOut.exists()){
            testOut.delete();
        }
    }
}
