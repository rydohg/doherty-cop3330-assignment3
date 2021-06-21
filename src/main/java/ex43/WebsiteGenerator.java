package ex43;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class WebsiteGenerator {
    public static void main(String[] args) {
        // Prompt for site name
        System.out.print("Site Name: ");
        Scanner scanner = new Scanner(System.in);
        String siteName = scanner.nextLine().trim();
        // Prompt for author's name
        System.out.print("Author: ");
        String author = scanner.nextLine().trim();
        // Prompt for JS folder
        System.out.print("Do you want a folder for JavaScript? ");
        boolean js = scanner.nextLine().trim().equals("y");
        // Prompt for CSS folder
        System.out.print("Do you want a folder for CSS? ");
        boolean css = scanner.nextLine().trim().equals("y");

        // Make Website object and generate requested folders
        Website website = new Website(siteName, author);
        if (css){
            website.makeCSSFolder();
        }
        if (js){
            website.makeJSFolder();
        }
        // Write html for the website
        writeHtml(website);
        scanner.close();
    }

    public static boolean writeHtml(Website website){
        try {
            // Write generated HTML to title/index.html
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
