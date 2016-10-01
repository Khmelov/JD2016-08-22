package by.it.grechishnikov.jd02_01;

/**
 * Created by Evgeniy on 29.09.16.
 */
public enum Good {
    CHEESE(5.99), MILK(2), MEAT(10.45), VODKA(5.79), BREAD(1.1), SUGAR(2.5), POTATOES(2.33);

    public double price;

    Good(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
