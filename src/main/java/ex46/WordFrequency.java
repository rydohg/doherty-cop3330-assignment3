package ex46;
/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Ryan Doherty
 */
// Object to store a word and it's frequency in a string
public class WordFrequency {
    String word;
    int frequency;

    public WordFrequency(String word) {
        this.word = word;
        this.frequency = 1;
    }

    public void incrementFrequency(){
        frequency++;
    }
}
