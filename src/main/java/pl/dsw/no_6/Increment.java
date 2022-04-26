package pl.dsw.no_6;

/**
 *  Brak synchronizacji. Po stworzeniu obiektu value przyjmuje 0, następnie x wątków wykonuje y iteracji
 *  w których wywołuje metodę increment(), w której wartość value zwiększana jest o 1.
 *  Spodziewana wartość po wykonaniu wszystkich wątków to x * y, ale wynik może się różnić przy każdym
 *  wykonaniu programu. Operacja value++ składa się z:
 *  1. pobrania wartości value;
 *  2. zwiększenia pobranej wartości;
 *  3. przypisania obecnej wartości do value;
 *  Jeżeli wiele wątków operuje na tym samym obiekcie możliwe, że wątekA wykona operację 1, po czym
 *  dostęp do procesora otrzyma wątekB w operacji 1 pobierze tą samą wartość co wątekA następnie
 *  zwiększy ją o 1, i przypisze do zmiennej, kiedy dostęp do procesora otrzyma znowu wątekA zwiększy
 *  pobraną przez siebie watrość następnie przypisze do zmiennej, co oznacza, że wykonanie dwukrotnej
 *  inkrementacji przez różne wątki nie musi dawać oczekiwanego wyniku.
 */

class Increment {

    private long value;

    void increment() {
        value++;
    }

    @Override
    public String toString() {
        return "Increment: " + value;
    }
}
