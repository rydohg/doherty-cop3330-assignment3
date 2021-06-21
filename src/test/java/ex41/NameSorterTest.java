package ex41;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NameSorterTest {
    @Test
    @DisplayName("File Open")
    public void fileOpenTest(){
        // Test if we can open the file
        System.out.println(System.getProperty("user.dir"));
        assertNotNull(FileOps.readFile("src/main/java/ex41/exercise41_input.txt"));
    }

    @Test
    @DisplayName("File Write")
    public void fileWriteTest(){
        // Test if we can write to the output
        assertTrue(FileOps.writeFile("src/main/java/ex41/exercise41_output.txt", "test"));
    }

    @Test
    @DisplayName("Sort Names")
    public void sortTest(){
        // Test if the sort method puts the correct item first
        ArrayList<String> names = new ArrayList<>();
        names.add("abc");
        names.add("bcd");
        names.add("aad");
        String sortedNames = NameSorter.sort(names);
        assertTrue(sortedNames.startsWith("aad"));
    }
}
