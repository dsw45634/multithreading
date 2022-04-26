package pl.dsw.no_6;

class Balance {

    static int balanceStaticValue;
    private int incrementedValue;
    private int decrementedValue;

    /**
     *  W przypadku metod statycznych blokowany jest obiekt - klasa.
     */

    static synchronized void decrementStaticValue() {
        balanceStaticValue--;
    }

    /**
     *  Blok synchronizacyjny - w nawiasie podajemy obiekt który ma zostać "zablokowany".
     *  Aby dostęp do pól statycznych był synchronizowany należy podać obiekt - klasę w której
     *  pola się znajdują.
     */

    static void incrementStaticValue() {
        synchronized (Balance.class) {
            balanceStaticValue++;
        }
    }

    void increment() {
        incrementedValue++;
    }

    /**
     *  Dzięki blokom synchronizacyjnym można wydzielić fragmenty kodu które mają być synchronizowane.
     */

    void decrement() {
        synchronized (this) {
            decrementedValue--;
        }
    }

    @Override
    public String toString() {
        return String.format("Balance:\nincrementedValue: %d\ndecrementedValue: %d", + incrementedValue, decrementedValue);
    }

}
