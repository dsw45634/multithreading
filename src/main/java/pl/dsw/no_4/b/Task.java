package pl.dsw.no_4.b;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *  Klasa Task<V> rozszerza FutureTask<T>, ta z kolei implementuje interfejs RunnableFuture<V>,
 *  który rozszerza Runnable i Future<V>, dlatego można ją podać jako argument metody:
 *  wykonawca.execute(Runnable rurrable). FutureTask<V> przyjmuje w konstruktorze Callable<V>,
 *  jej metoda run() uruchamia callable.call(), po wykonaniu wynik ustawia w polu "outcome",
 *  i wykonywana jest metoda done() - którą nadpisujemy. Poprzez this.get() odwołujemy sią do
 *  wyniku czyli outcome.
 */

class Task extends FutureTask<String> {

    public Task(Callable<String> callable) {
        super(callable);
    }

    @Override
    protected void done() {
        try {
            System.out.println(this.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
