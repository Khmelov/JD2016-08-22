package by.it.akhmelev.jd01_08._01_Card;

class CreditCardAction extends CardAction {
    // поля, конструкторы, методы
    boolean checkCreditLimit() { // собственный метод
        return true; // stub
    }
    @Override // аннотация указывает на полиморфную природу метода (для IDE)
    public void doPayment(double amountPayment) { // переопределенный метод
    // реализация
        System.out.println("complete from credit card");
    }
}

