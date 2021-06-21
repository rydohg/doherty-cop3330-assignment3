package ex42;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataParserTest {
    @Test
    @DisplayName("Read Test")
    public void readTest(){
        // Test if we can read the given file
        ArrayList<Record> records = DataParser.readRecords("exercise42_input.txt");
        assertNotNull(records);
    }
    @Test
    @DisplayName("Format Test")
    public void formatTest(){
        // Tests known input against known output
        ArrayList<Record> records = DataParser.readRecords("exercise42_input.txt");
        String result = "Last      First     Salary\n" +
                "--------------------------\n" +
                "Mai      Ling     55900\n" +
                "Jim      Johnson  56500\n" +
                "Aaron    Jones    46000\n" +
                "Chris    Jones    34500\n" +
                "Geoffrey Swift    14200\n" +
                "Fong     Xiong    65000\n" +
                "Sabrina  Zarnecki 51500\n";
        assertEquals(result, DataParser.formatRecords(records));
    }
}
