package by.it.akhmelev.jd02_03.demo;

class Buyer extends Thread implements IBuyer {

    int num;                    //номер покупателя
    public boolean iWait=false; //флаг того, что покупатель в ожидании

    //конструктор покупателя с его номером
    public Buyer() {
        num=++Dispatcher.countBuyers;
        this.setName("Покупатель № "+ num +" ");
        start();
    }

    @Override //покупатель приходит в зал и выбирает товары.
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
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
        //вызываем свой генератор случайных чисел
        int pause = Helper.fromTo(500, 2000);
        Helper.sleep(pause);
        //ожидание окончено
        System.out.println(this + "выбрал товар");
    }

    @Override
    public /* можно было и тут synchronized */ void goToQueue() {
        synchronized (this) { //ВНИМАТЕЛЬНО! Специально явно сделана блокировка по покупателю
                              //если бы synchronized был указан в методе, то он работает именно так
                              //при "отпускании" этого потока
                              //кассир - отправитель команды для продолжения этого потока
                              //должен будет тоже заблокировать этого же покупателя
                              //и оправить ему notify.
            System.out.println(this + "встал в очередь на кассу");
            QueueBuyers.add(this);
            //в этой точке поток должен остановиться, поэтому
            //подготовим публичное поле iWait для определения, можно ли идти дальше
            iWait=true;
            while (iWait) try { //ожидаем notify и iWait==false от кассира.
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //ожидание окончено, тут прилетел notify от кассира
            System.out.println(this + "закончил оплату товаров в кассе");
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }
}
