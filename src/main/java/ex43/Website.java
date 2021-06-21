package ex43;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;

public class Website {
    // Create a Website object with the author and title and generate folders/files using its methods
    String title;
    String author;

    public Website(String title, String author) {
        this.title = title;
        this.author = author;
        File file = new File(title);
        // Make website's directory
        file.mkdir();
    }

    // Return boilerplate index.html with author and title inserted in appropriate places
    public String generateIndex(){
        return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "    <head>\n" +
        "        <meta name=\"author\" content=\"" + author + "\">\n" +
        "        <title>" + title + "</title>\n" +
        "    </head>\n" +
        "    <body>\n" +
        "\n" +
        "    </body>\n" +
        "</html>\n";
    }

    public boolean makeCSSFolder(){
        // Make directory at <websiteTitle>/css
        File cssFolder = new File(title + "/css");
        return cssFolder.mkdir();
    }

    public boolean makeJSFolder(){
        // Make directory at <websiteTitle>/js
        File jsFolder = new File(title + "/js");
        return jsFolder.mkdir();
    }
}
