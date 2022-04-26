package pl.dsw.no_4.a;

import java.util.concurrent.Callable;

/**
 *  Interfejs Callable<V> posiada metodę o sygnaturze: V call() throws Exception którą
 *  trzeba nadpisać, zwraca ona obiekt typu V, może zgłosić wyjątek kontrolowany i wykonywana jest
 *  współbieżnie, kiedy wywołamy metodę submit() na wykonawcy podając Callable jako argument, lub
 *  tak jak w przykładzie b...
 */

public class Caller implements Callable<String> {

    private final char sign;

    public Caller(char sign) {
        this.sign = sign;
    }

    @Override
    public String call() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            sleep(50);
            stringBuffer.append(sign);
        }
        System.out.println(sign);
        return stringBuffer.toString();
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
