package pl.dsw.no_2;

/**
 *  Jeżeli chcemy aby program wykonywał dwie czynności "jednocześnie" (jeden procesor może wykonywać
 *  jedną operację, współbierzność oznacza, że wątek dostaje dostęp do procesora na kwant czasu),
 *  np. odliczał czas jednocześnie umożliwiając interakcję z użytkownikiem, należy zadania
 *  wykonać w osobnych wątkach.
 */

class Main {
    public static void main(String[] args) {
        Question question = new Question();
        Quiz game = new Quiz(question);
        game.start();
    }
}
