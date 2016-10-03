package by.it.grechishnikov.jd02_03;


class Runner {
    public static void main(String[] args) throws Exception {
        init();
    }

    private static void init() {
        Printer.println("                                                  " +
                "         ***** Магазин открылся! Добро пожаловать! *****");

        int countBuyers = 100;
        Dispatcher.setFinalCountClient(countBuyers);
        Printer.println("                                           " +
                "                          Количество поситителей: " + countBuyers);
        Printer.println("           Мария                         Наталья                         Анна           " +
                "              Александра                         Зоя               Очер.   Выруч.");
        for (int i = 0; i < countBuyers; i++) {
            Buyer b = new Buyer(i);
            if (i % 4 == 0) {
                b.setPensioner(true); //каждый 4ый - пенсионер
            }
            b.start();
        }

        Dispatcher dispatcher = new Dispatcher();
        dispatcher.start();
    }
}