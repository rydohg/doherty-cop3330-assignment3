package ex44;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SearchTest {
    @Test
    @DisplayName("Parse Test")
    public void parseTest(){
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
        assertNotNull(ProductSearch.readFile("src/main/java/ex44/exercise44_input.txt"));
    }
}
