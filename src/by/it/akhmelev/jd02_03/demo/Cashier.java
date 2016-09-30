package by.it.akhmelev.jd02_03.demo;

public class Cashier implements Runnable{
    private int num; //номер кассира

    public Cashier() {
        this.num = ++Dispatcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Кассир-"+num;
    }

    @Override
    public void run() {
        //кассир начинает работу сразу
        System.out.println(this+" открыл кассу");
        //и закончит ее когда покупатели по плану будут обслужены
        while (!Dispatcher.finish()) {
            //получим покупателя из очереди. Поскольку очередь потокобезопасна
            //то дополнительная синхронизация не требуется.
            Buyer buyer=QueueBuyers.poll();
            if (buyer!=null) //есть клиент, обслуживание
            synchronized (buyer) {
                System.out.println(this+" обслуживает клиента: "+buyer);
                Helper.sleep(Helper.fromTo(2000, 5000));
                System.out.println(this + " обслужил клиента: " + buyer);
                //увеличим счетчик обслуженных клиентов
                //вот такой счетчик будет работать с ошибкой
                Dispatcher.countCompleteBuyers++;
                //а вот так, уже правильно. Подумайте почему?
                Dispatcher.acountCompleteBuyers.incrementAndGet();
                buyer.iWait=false;
                buyer.notify(); //отдаем блокировку обратно покупателю
            }
            else //если еще никто не дошел, подождем секунду
                Helper.sleep(1000);
        }
        System.out.println(this+" закрыл кассу");
    }

}
