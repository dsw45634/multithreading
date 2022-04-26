package pl.dsw.no_1;

class Main {
    public static void main(String[] args) {
        /**
         *  Tak też można tworzyć wątek...
         *  W konstruktorze należy podać obiekt implementujący Runnable
         *  Zamiast tego tworzymy klasę anonimową
        */
        Thread aaaPrinterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                print("aaa");
            }
        });
        /**
         *  Uruchomienie wątku
         */
        aaaPrinterThread.start();
        /**
         *  metoda "mójWątek.join()" sprawia, że kod który jest niżej
         *  zostanie wykonany kiedy mójWątek zakończy pracę.
         */
//        aaaPrinterThread.join();
        /**
         *  Skrócona wersja tworzenia klasy anonimowej
         */
        Thread ladiaxna = new Thread(() -> print("ladiaxna"));
        ladiaxna.start();
        Thread bbbPrinterThread = new Thread(new Runnable() {
            @Override
            public void run() {
                print("bbb");
            }
        });
        bbbPrinterThread.start();
//        bbbPrinterThread.join();
        print("main");
    }

    private static void print(String aaa) {
        for (int i = 0; i < 10; i++) {
            System.out.println(aaa);
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
