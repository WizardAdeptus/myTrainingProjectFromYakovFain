package info.introToJava.multithreading.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableThread {
    public static void main(String[] args) {

        // A placeholder for Future objects
        List<Future<Integer>> futures = new ArrayList<>();

        // A placeholder for results
        List<Integer> results = new ArrayList<>();

        // Pool of 2 threads
        final ExecutorService service = Executors.newFixedThreadPool(2);

        futures.add(service.submit(new PortfolioCallable()));
        futures.add(service.submit(new MarketNewsCallable()));

        try {
            for (Future<Integer> future : futures){
                results.add(future.get());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

        for (Integer res : results) {
            System.out.println("\nGot the result: " + res);
        }

    }
}
