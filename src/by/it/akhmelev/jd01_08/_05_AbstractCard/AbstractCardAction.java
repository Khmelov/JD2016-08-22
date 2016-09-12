package by.it.akhmelev.jd01_08._05_AbstractCard;

abstract class AbstractCardAction {
    private int id;
    AbstractCardAction() { // конструктор
    }
    // more methods
    public boolean checkLimit() { // собственный метод
        return true; // stub
    }
    public abstract void doPayment(double amountPayment);
}