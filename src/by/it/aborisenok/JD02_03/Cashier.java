package by.it.aborisenok.JD02_03;

import java.util.Map;

/**
 * Created by Лёша on 28.09.2016.
 */
public class Cashier implements Runnable{
    private int number;
    Buyer buyer;


    public Cashier(int number){
        this.number = number;
    }

    @Override
    public void run() {
        buyerServise();
    }

    public void buyerServise(){
        try {
            while (true) {
                synchronized (Queues.buyerDeque) {
                    if (Queues.buyerDeque.size() == 0) {
                        break;
                    }
                    buyer = Queues.buyerDeque.pollFirst();
                }


                System.out.println("*" + buyer + " go to " + this);
                System.out.println(buyer + " Servising by " + this);

                int pause = Helper.random(2000, 5000);
                Thread.sleep(pause);
                buyerCheck(buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            }

            System.out.println(this + " is close");
        } catch (InterruptedException e){}
        Runner.countCashiers--;
    }

    public void buyerCheck(Buyer buyer){
        StringBuilder check = new StringBuilder();
        check.append("\n|-----------------------------|\n");
        check.append(" Check from " + this + "\n");
        check.append(" Check for " + buyer + "\n");
        check.append("|-----------------------------|\n");
        check.append("|  Goods  |   count   | prise |\n");

        for (Map.Entry<String, Integer> pair : buyer.backet.getGoods().entrySet())
        {
            String goods = pair.getKey();
            Integer count = pair.getValue();
            double prise = Helper.allPriceForGoods.get(goods);
            check.append(String.format("|%-11s %-10s %-6.2f|\n", goods, new String(prise+"*"+count), count*prise ));
        }

        check.append("|-----------------------------|\n");
        check.append("|Thank you for your purchase  |\n");
        check.append("|-----------------------------|\n");
        System.out.println(check);
    }

    @Override
    public String toString() {
        return "Cashier №"+ number;
    }
}
