package by.it.akhmelev.jd02_02.demo;

class Runner {
    static int countBuyers=0; //общий счетчик покупателей
    protected volatile static int countCashiers=0; //общий счетчик кассиров
    public static void main(String[ ] args) throws InterruptedException {

        //создаем очередь для покупателей. Пока обычную.
        while (countBuyers<10) {
            Thread.sleep(1000); //ожидание в 1 секунду
            int count=Rnd.fromTo(0,2); //сколько приходит покупателей: 0 1 2
            for (int i = 0; i <= count; i++) {
                countBuyers++;
                if (countBuyers<11)
                {
                    new Buyer(countBuyers);
                }
                //создадим кассу
                int size=0;
                {
                    synchronized (Queues.buyers){
                        size=Queues.buyers.size();
                    }
                }
                if (size>0 && countCashiers<5) {
                    Cashier cashier = new Cashier();
                    new Thread(cashier).start();
                    countCashiers++;
                }
            }
        }
    }
}
