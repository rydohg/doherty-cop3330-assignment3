package ex44;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchTest {
    @Test
    @DisplayName("Parse Test")
    public void parseTest(){
        // Test if the parse is successful and has the correct name in the first position
        String rawJSON = """
                {
                    "products" : [
                        {"name": "Widget", "price": 25.00, "quantity": 5 },
                        {"name": "Thing", "price": 15.00, "quantity": 5 },
                        {"name": "Doodad", "price": 5.00, "quantity": 10 }
                    ]
                }""";
        assertEquals("Widget", ProductSearch.parseJSON(rawJSON)[0].name);
    }

    @Test
    @DisplayName("File Test")
    public void readFileTest(){
        // Test if it can read the file
        assertNotNull(ProductSearch.readFile("exercise44_input.txt"));
    }
}
