package ex43;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebsiteTest {
    String title = "test";
    String author = "author";

    @Test
    @DisplayName("CSS Dir")
    public void cssTest(){
        Website website = new Website(title, author);
        website.makeCSSFolder();
        File testFolder = new File(title + "/css");
        assertTrue(testFolder.exists());
    }

    @Test
    @DisplayName("JS Dir")
    public void jsTest(){
        Website website = new Website(title, author);
        website.makeJSFolder();
        File testFolder = new File(title + "/js");
        assertTrue(testFolder.exists());
    }

    @Test
    @DisplayName("Generate Index")
    public void generateIndexTest(){
        Website website = new Website(title, author);
        String index = website.generateIndex();
        assertTrue(index.contains(author));
        assertTrue(index.contains(title));
    }

    @AfterEach
    void tearDown() {
        File css = new File(title + "/css");
        File js = new File(title + "/js");
        File html = new File(title + "/index.html");
        File websiteDir = new File(title);
        if (js.exists()){
            js.delete();
        }
        if (css.exists()){
            css.delete();
        }
        if (html.exists()){
            html.delete();
        }
        if (websiteDir.exists()){
            websiteDir.delete();
        }
    }
}
