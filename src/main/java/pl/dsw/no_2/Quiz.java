package pl.dsw.no_2;

import javax.swing.*;

/**
 *  Klasa Quiz dziedziczy po klasie Thread, co oznacza, że jeśli na obiekcie tej klasy wyołamy metodę
 *  start() zostanie współbieżnie wykonana metoda run(), czyli zostanie utworzony nowy wątek.
 *  W metodzie run() uruchamiamy nowy wątek: linie 22, 23.
 *  Wątek questionThread oraz reszta metody działają współbieżnie.
 *  Następnie zaczynamy odliczanie i pokazywanie czasu w konsoli, dopóki questionThread jest "żywy".
 */

class Quiz extends Thread {
    private final Question question;

    Quiz(Question question) {
        this.question = question;
    }

    @Override
    public void run() {
        Thread questionThread = new Thread(question);
        questionThread.start();

        int seconds = 0;
        String mm = "";
        String ss = "";
        while (questionThread.isAlive()) {
            sleep(1000);
            seconds++;
            mm = getMinutes(seconds);
            ss = getSeconds(seconds);
            System.out.printf("\r%s:%s", mm, ss);
        }
        JOptionPane.showMessageDialog(null, String.format("Brawo!!! %s:%s", mm, ss));
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getSeconds(int seconds) {
        int sec = seconds % 60;
        return sec < 10 ? "0" + sec : "" + sec;
    }

    private String getMinutes(int seconds) {
        int min = seconds / 60;
        return min < 10 ? "0" + min : String.valueOf(min);
    }
}
