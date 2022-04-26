package pl.dsw.no_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Klasa Executors dostarcza wiele metod statycznych dzięki którym możemy stworzyć obiekty
 *  różnych wykonawców (implementujących interfejsy Executor lub ExecutorService).
 *  W podanym przykładzie wykonawca zarządza pulą wątków o podanym rozmiarze, czyli:
 *  - tworzy cztery wątki, którym zleca sześć zadań do wykonania.
 *  - kiedy wątek zakończy zadanie może przyjąć następne.
 *  - metoda - void execute(Runnable command) przyjmuje obiekt klasy implementującej interfejs Runnable.
 *  - zadanie które wykonuje wątek to metoda run() klasy Task.
 *  Metoda executorService.shutdown() - zamyka wykonawcę kiedy jest to
 *  możliwe, czyli kiedy wszystkie wątki zakończą pracę.
 *  Istnieje również metoda executorService.shutdownNow() - która zamyka wykonawcę natychmiast.
 */

class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 'A'; i < 'G'; i++) {
            executorService.execute(new Task((char) i));
        }

        executorService.shutdown();
    }
}
