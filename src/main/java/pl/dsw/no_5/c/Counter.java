package pl.dsw.no_5.c;

class Counter implements Runnable {

    private final int id;
    private long counter;

    public Counter(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            counter++;
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread " + id + " - counter: " + counter);
                break;
            }
        }
    }
}
