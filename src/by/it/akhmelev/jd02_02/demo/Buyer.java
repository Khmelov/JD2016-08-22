package by.it.akhmelev.jd02_02.demo;

class Buyer extends Thread implements Runnable, IBuyer {

    //номер покупателя
    protected int num;

    //конструктор покупателя с его номером
    Buyer(int num) {
        this.num = num;
        this.setName("Покупатель № " + num + " ");
        start();
    }

    @Override //покупатель приходит в зал и выбирает товары.
    public void run() {
        enterToMarket();
        chooseGoods();
        waitService();
        goToOut();
    }

    //при получение строкового значения для экземпляра покупателя
    @Override
    public String toString() {
        return this.getName();
    }

    //реализация интерфейсов
    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            //вызываем свой генератор случайных чисел
            int pause = Rnd.fromTo(500, 2000);
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println(this + " //некорректное завершение ожидания");
        }
        //ожидание окончено
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void waitService() {
        System.out.println(this + "встал в очередь");
        synchronized (Queues.buyers) {
            Queues.buyers.addLast(this);
        }
        synchronized (this) {
            try {
                System.out.println(this + "ожидает в очереди");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                System.out.println(this + "закончил обслуживаться");
            }
        }

    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }
}
