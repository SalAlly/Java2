package AllySalLab5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountThread extends Thread {
    private String filename;
    static int totalWordCount = 0;
    static int activeThreads = 0;
    static final Object lock = new Object();

    public WordCountThread(String filename) {
        this.filename = filename;
    }

    @Override
    public void run() {
        try {
            int wordCount = countWords(filename);
            synchronized (lock) {
                totalWordCount += wordCount;
                System.out.println(filename + ": " + wordCount);
                activeThreads--;

              
                if (activeThreads == 0) {
                    System.out.println("Combined word count: " + totalWordCount);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int countWords(String filename) throws IOException {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                count += words.length;
            }
        }
        return count;
    }
}
