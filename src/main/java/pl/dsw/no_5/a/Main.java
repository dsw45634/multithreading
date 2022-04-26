package pl.dsw.no_5.a;

/**
 *  Wątek kończy pracę kiedy zostanie wykonana medoda run(), ale możliwe, że z jakiegoś powodu chcemy zakończyć
 *  działanie wątku w trakcie działania.
 *  Wywołanie medoy interrupt() na obiekcie wątku powoduje ustawienie statusu na przerwany, jeżeli wątek z tym
 *  statusem jest lub zostanie zablokowany przez metodę zatrzymującą jego działanie np. Thread.sleep(long millis),
 *  status jest zmieniany na nieprzerwany i zostaje zgłoszony wyjątek InterruptedException, w bloku catch możemy
 *  zdecydować co ma się stać - np zakończyć wykonanie metody przez return, lub break. Jeżeli nie wstrzymujemy
 *  działania wątku możemy zakończyć jego działanie po sprawdzeniu statusu - przykład b i c.
 */

class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            StringBuilder builder = new StringBuilder();
            while (true) {
                builder.append("a".repeat(50));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.err.println("Koniec pracy wątku przez obsługę wyjątku InterruptedException.");
                    String result = builder.toString();
                    System.out.println(result + " " + result.length());
                    break;
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
