package ex46;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {
    @Test
    @DisplayName("Read file test")
    public void readFileTest(){
        assertNotNull(FrequencyFinder.readFile("src/main/java/ex46/exercise46_input.txt"));
    }

    @Test
    @DisplayName("Sorted Frequencies Test")
    public void sortedTest(){
        String input = FrequencyFinder.readFile("src/main/java/ex46/exercise46_input.txt");
        ArrayList<WordFrequency> frequencies = FrequencyFinder.getFrequencies(input);

        assertTrue(frequencies.get(0).frequency > frequencies.get(frequencies.size() - 1).frequency);
        assertTrue(frequencies.get(0).frequency > frequencies.get(1).frequency);
    }

    @Test
    @DisplayName("\"badger\" Test")
    public void badgerTest(){
        String input = FrequencyFinder.readFile("src/main/java/ex46/exercise46_input.txt");
        ArrayList<WordFrequency> frequencies = FrequencyFinder.getFrequencies(input);

        assertEquals(frequencies.get(0).frequency, 7);
    }
}
