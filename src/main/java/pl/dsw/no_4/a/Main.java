package pl.dsw.no_4.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *  W tym przykładzie tworzymy wykonawcę który zarządza pulą wątków o dynamicznych rozmiarach,
 *  wybór wykonawcy nie ma związku z następnymi działaniami.
 *  Tak jak w poprzednim przykładzie zlecane zadanie nie robi nic spektakularnego, ale
 *  tym razem chcemy odebrać wynik wykonanej metody, jest to możliwe dzięki generycznym
 *  interfejsom Callable oraz Future.
 *  Opis interfejsu Callable w klasie Caller.
 *  W wyniku wykonania metody submit(Callable<V> task) na obiekcie wykonawcy otrzymujemy obiekt
 *  klasy implementującej interfejs Future<V> który opakowuje wynik metody call() - problemem jest
 *  to, że nie wiadomo kiedy wynik będzie gotowy dlatego umieszczamy obiekty Future w liście,
 *  a w dalszej części programu co 0,2 s wykonujemy sprawdzenie czy wszystkie zostały wykonane.
 *  Następnie wypisujemy wyniki w kolejności dodawania zadań, kolejność wykonania zadań może być
 *  inna - jest przedstawiona poprzez wypisanie pojedynczego znaku.
 */

class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 'a'; i < 'h'; i++) {
            Future<String> submit = executorService.submit(new Caller((char) i));
            futures.add(submit);
        }

        executorService.shutdown();

        waitForFinish(futures);

        print(futures);

    }

    private static void waitForFinish(List<Future<String>> futures) {
        while (!isDone(futures)) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void print(List<Future<String>> futures) {
        for (Future<String> future : futures) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isDone(List<Future<String>> futures) {
        for (Future<String> future : futures) {
            if (!future.isDone()) {
                return false;
            }
        }
        return true;
    }
}
