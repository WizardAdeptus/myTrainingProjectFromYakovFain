package info.introToJava.multithreading.concurrency;

import static java.lang.Thread.sleep;

public class Portfolio implements Runnable {
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(700);
                System.out.println("You have" + (500 + i) + "shares of IBM ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
