package by.it.grechishnikov.jd02_03;

import java.util.concurrent.CopyOnWriteArraySet;


class Check {
    private String cashirName;
    private double sum;
    private CopyOnWriteArraySet<Good> goods;
    private Buyer buyer;
    private double totalSum;

    Check(String cashirName, Buyer buyer, CopyOnWriteArraySet<Good> goods) {
        this.cashirName = cashirName;
        this.goods = goods;
        this.buyer = buyer;
        setSum();
    }

    String getCashirName() {
        return cashirName;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public CopyOnWriteArraySet<Good> getGoods() {
        return goods;
    }

    public double getSum() {
        return sum;
    }

    private void setSum() {
        double sum = 0;
        for (Good good : goods) {
            sum += good.getPrice();
        }
        this.sum = sum;
    }
}
