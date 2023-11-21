package AllySalLab5;

public class WordCount {
    public static void main(String[] args) {
        WordCountThread[] threads = new WordCountThread[args.length];

        for (int i = 0; i < args.length; i++) {
            threads[i] = new WordCountThread(args[i]);
            threads[i].start();
            synchronized (WordCountThread.lock) {
                WordCountThread.activeThreads++;
            }
        }

     
        for (WordCountThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
