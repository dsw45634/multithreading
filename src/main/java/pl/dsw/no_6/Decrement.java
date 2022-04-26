package pl.dsw.no_6;

class Decrement {

    private long value;

    /**
     *  Niestatyczna metoda synchronizowana - obiekt na którym jest wykonywana zostaje "zablokowany",
     *  co oznacza, że jeżeli jakakolwiek inna metoda synchronizowana będzie próbować wykonać
     *  jakąkolwiek akcję na tym obiekcie zostanie zatrzymana do momentu zakończenia jej wykonania.
     */

    synchronized void decrement() {
        value--;
    }

    @Override
    public String toString() {
        return "Decrement: " + value;
    }
}
