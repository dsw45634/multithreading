package pl.dsw.no_6;

import java.util.ArrayList;
import java.util.List;

/**
 *  Przykład współdzielenia danych, czym skutkuje brak synchronizacji.
 */

class Main {

    static final int ITERATIONS = 100_000_000;
    static final int THREADS = 5;

    public static void main(String[] args) {

        Increment increment = new Increment();
        Decrement decrement = new Decrement();
        Balance balance = new Balance();

        List<Thread> threads = new ArrayList<>();

        while (threads.size() < THREADS) {
            Thread thread = new Thread(new Task(increment, decrement, balance));
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Wyniki:");
        System.out.printf("Liczba wątków: %d", THREADS);
        System.out.printf("\nLiczba iteracji w wątku: %d", ITERATIONS);
        System.out.printf("\n%d * %d = %d", THREADS, ITERATIONS, THREADS * ITERATIONS);
        System.out.println("\n========================================================");
        System.out.println(increment);
        System.out.println(decrement);
        System.out.println(balance);
        System.out.println("balanceStaticValue: " + Balance.balanceStaticValue);
    }
}
