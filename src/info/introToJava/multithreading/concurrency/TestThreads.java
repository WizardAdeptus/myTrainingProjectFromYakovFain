package info.introToJava.multithreading.concurrency;

public class TestThreads {
    public static void main(String[] args) {
        MarketNews mn = new MarketNews();
        Thread mnThread = new Thread(mn, "Market News");
        mnThread.start();

        Runnable p = new Portfolio();
        Thread pThread = new Thread(p, "Portfolio data");
        pThread.start();

        try {
            pThread.join();
            mnThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The main method of TestThreads is finished");
    }
}
