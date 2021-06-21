package ex46;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {
    @Test
    @DisplayName("Read file test")
    public void readFileTest(){
        // Test if we can read the given file
        assertNotNull(FrequencyFinder.readFile("exercise46_input.txt"));
    }

    @Test
    @DisplayName("Sorted Frequencies Test")
    public void sortedTest(){
        // Test if we can find the frequencies and if they are in the proper order
        String input = FrequencyFinder.readFile("exercise46_input.txt");
        ArrayList<WordFrequency> frequencies = FrequencyFinder.getFrequencies(input);

        assertTrue(frequencies.get(0).frequency > frequencies.get(frequencies.size() - 1).frequency);
        assertTrue(frequencies.get(0).frequency > frequencies.get(1).frequency);
    }

    @Test
    @DisplayName("\"badger\" Test")
    public void badgerTest(){
        // Test if it generates the correct frequency for "badger"
        String input = FrequencyFinder.readFile("exercise46_input.txt");
        ArrayList<WordFrequency> frequencies = FrequencyFinder.getFrequencies(input);

        assertEquals(frequencies.get(0).frequency, 7);
    }
}
