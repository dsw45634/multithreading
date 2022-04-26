package pl.dsw.no_5.c;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            futures.add(executorService.submit(new Counter(i)));
        }
        sleep();

        for (Future<?> future : futures) {
            future.cancel(true);
            sleep();
        }

        executorService.shutdown();
        System.out.println("Koniec");

    }

    private static void sleep() {
        try {
            Thread.sleep(1230);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
