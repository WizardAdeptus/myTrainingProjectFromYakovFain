package info.introToJava.multithreading.impl;

public class TestThreads {
    public static void main(String[] args) {
        MarketNews mn = new MarketNews();
        Thread mnThread = new Thread(mn, "Market News");
        mnThread.start();

        Runnable p = new Portfolio();
        Thread pThread = new Thread(p, "Portfolio data");
        pThread.start();

        System.out.println("TestThreads is finished");
    }
}
