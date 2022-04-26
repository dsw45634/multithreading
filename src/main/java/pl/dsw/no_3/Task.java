package pl.dsw.no_3;

/**
 *  Treść zadania nie jest przedmiotem rozważań, symulujemy długie działanie metody (zlepiamy ze sobą
 *  20 znaków co sekundę wypisując wynik co pięć iteracji), w konsoli zobaczymy jak zmienia się
 *  kolejność następnych napisów - każdy wątek ma inny znak.
 */

class Task implements Runnable {

    private char sign;

    public Task(char sign) {
        this.sign = sign;
    }

    @Override
    public void run() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            buffer.append(sign);
            if (buffer.length() % 5 == 0) {
                String sequence = buffer.toString();
                System.out.println(sequence);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
