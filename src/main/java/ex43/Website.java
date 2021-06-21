package ex43;

import java.io.File;

public class Website {
    String title;
    String author;

    public Website(String title, String author) {
        this.title = title;
        this.author = author;
        File file = new File(title);
        file.mkdir();
    }

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
        File cssFolder = new File(title + "/css");
        return cssFolder.mkdir();
    }

    public boolean makeJSFolder(){
        File jsFolder = new File(title + "/js");
        return jsFolder.mkdir();
    }
}
