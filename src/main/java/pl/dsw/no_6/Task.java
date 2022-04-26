package pl.dsw.no_6;

class Task implements Runnable {

    private final Increment increment;
    private final Decrement decrement;
    private final Balance balance;

    public Task(Increment increment, Decrement decrement, Balance balance) {
        this.increment = increment;
        this.decrement = decrement;
        this.balance = balance;
    }

    @Override
    public void run() {
        for (int i = 0; i < Main.ITERATIONS; i++) {
            increment.increment();
            decrement.decrement();
            balance.decrement();
            balance.increment();
            Balance.decrementStaticValue();
            Balance.incrementStaticValue();
        }
    }
}
