package ex43;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WebsiteGenerator {
    public static void main(String[] args) {
        System.out.print("Site Name: ");
        Scanner scanner = new Scanner(System.in);
        String siteName = scanner.nextLine().trim();
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Do you want a folder for JavaScript? ");
        boolean js = scanner.nextLine().trim().equals("y");
        System.out.print("Do you want a folder for CSS? ");
        boolean css = scanner.nextLine().trim().equals("y");

        Website website = new Website(siteName, author);
        if (css){
            website.makeCSSFolder();
        }
        if (js){
            website.makeJSFolder();
        }
        writeHtml(website);
        scanner.close();
    }

    public static boolean writeHtml(Website website){
        try {
            File index = new File(website.title + "/index.html");
            FileWriter writer = new FileWriter(index);
            writer.write(website.generateIndex());
            writer.close();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
