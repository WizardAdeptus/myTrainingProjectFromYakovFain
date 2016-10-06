package info.introToJava.multithreading.raceConditions;

import info.introToJava.multithreading.concurrency.MarketNews;
import info.introToJava.multithreading.concurrency.Portfolio;

public class TestThreads {
    public static void main(String[] args) {
        MarketNews mn = new MarketNews();
        Thread mnThread = new Thread(mn, "Market News");
        mnThread.start();

        Runnable p = new Portfolio();
        Thread pThread = new Thread(p, "Portfolio data");
        pThread.start();

        Object theLockKeeper = new Object();
        synchronized (theLockKeeper) {
            System.out.println("Starting to wait...");
            try {
                theLockKeeper.wait(5000);
                mnThread.interrupt();
            } catch (InterruptedException e) {
                System.err.println("The main method is interrupted!");
            }
        }

        System.out.println("The main method of TestThreads is finished");
        mnThread.interrupt();
    }
}
