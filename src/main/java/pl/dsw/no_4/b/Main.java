package pl.dsw.no_4.b;

import pl.dsw.no_4.a.Caller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Pozbywamy się problemu z punktu a.
 */

class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 'a'; i < 'h'; i++) {
            executorService.execute(new Task(new Caller((char) i)));
        }
        executorService.shutdown();
    }
}
