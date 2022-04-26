package pl.dsw.no_2;

import javax.swing.*;

/**
 *  Klasa question implementuje interfejs Runnable. Kod znajdujący się w metodzie run wykona
 *  się współbieżnie jeśli wywołamy metodę start() na obiekcie klasy Thread, tworząc ten obiekt
 *  należy podać obiekt Question jako argument do konstruktora.
 *  W tym przykładzie Klasa Question odpowiada za odbieranie od użytkownika odpowiedzi, pytanie
 *  będzie powtarzane dopóki nie zostanie podana poprawna odpowiedź.
 */

class Question implements Runnable {

    private final static String CORRECT_ANSWER = "java";
    private String answer = "";

    @Override
    public void run() {
        while (!answer.equalsIgnoreCase(CORRECT_ANSWER)) {
            answer = JOptionPane.showInputDialog("Wyspa i język programowania to...");
        }
    }
}
