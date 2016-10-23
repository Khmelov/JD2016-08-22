package by.it.filimonchik.jd02_03;

/**
 * Created by Raman.Filimonchyk on 24/10/2016.
 */
public class Cashier  implements Runnable{
    private int num;
    public  Cashier(){
        this.num = ++Dispatcher.countCashiers;
    }

    @Override
    public String toString() {
        return "Cashier №" + num;
    }

    @Override
    public void run() {
        System.out.println(this+ " open the cashbox");
        while (!Dispatcher.finish()){
            Buyer buyer = Queue.poll();
            if(buyer!=null)
                synchronized (buyer){
                    System.out.println(this + " customer services: "+buyer);
                    Helper.sleep( Helper.fromTo(2000, 5000) );
                    System.out.println(this + " finish customer services: "+buyer);
                    Dispatcher.countCompleteBuyers++;
                    Dispatcher.acountCompleteBuyers.incrementAndGet();
                    buyer.iWait=false;
                    buyer.notify();
                }
                else Helper.sleep(1000);
        }
        System.out.println(this + " close the cashbox");

    }
}
