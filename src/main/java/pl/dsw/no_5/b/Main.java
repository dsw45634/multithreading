package pl.dsw.no_5.b;

class Main {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            private long counter;
            private byte step;

            @Override
            public void run() {
                while (true) {
                    if (++counter % 10000 == 0) {
                        System.out.println("counter: " + counter);
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Metoda thread.interrupt() nie zatrzymuje działania wątku...");
                        System.out.println("counter: " + counter);
                        if (++step == 5) {
                            System.out.println("Teraz kończymy...");
                            break;
                        }
                    }
                }
            }
        });

        thread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

    }
}
