package by.it.akhmelev.jd02_02.demo;

class Cashier implements Runnable {
    private int number;

    Cashier(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Buyer buyer;
                synchronized (Queues.buyers) {
                    //Проблема №1.
                    //проверку на размер очереди нужно делать ДО извлечения элемента из очереди
                    //а в аудитории я сделал эту проверку ПОСЛЕ pollFirst. Соответсвенно break
                    //мог сработать на одном последнем человеке. Он не обслуживался в итоге.

                    //Так будет правильнее. Сначала проверка, а уже потом извлечение.
                    //вторую проблему смотрите в классе Queues
                    if (Queues.buyers.size() == 0)
                        break;
                    buyer = Queues.buyers.pollFirst();
                }
                System.out.println(buyer + "обслуживается в "+this);
                Thread.sleep(2500);
                //service
                System.out.println(buyer + "обслужен в "+this);
                synchronized (buyer) {
                    buyer.notify();
                }
            }
            System.out.println(this+" закрылась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runner.countCashiers--;
    }

    @Override
    public String toString() {
        return "Касса №" + number;
    }
}
