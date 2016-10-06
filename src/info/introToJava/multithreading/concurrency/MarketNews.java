package info.introToJava.multithreading.concurrency;

import static java.lang.Thread.sleep;

public class MarketNews implements Runnable {

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(1000);
                System.out.println("The stock market is improving! " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
