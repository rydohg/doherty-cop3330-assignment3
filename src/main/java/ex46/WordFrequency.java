package ex46;

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
