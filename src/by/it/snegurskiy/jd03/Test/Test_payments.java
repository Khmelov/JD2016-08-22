package by.it.snegurskiy.jd03.Test;

import by.it.snegurskiy.jd03.classwork.Bean.Payments;
import by.it.snegurskiy.jd03.classwork.CRUD.PaymentsCRUD;

import java.sql.SQLException;

public class Test_payments {
    public static void main(String[] args) throws SQLException {
        Payments payments=new Payments(0, null, "Type", 0, 1, 1);
        PaymentsCRUD testPayment = new PaymentsCRUD();
        testPayment.create(payments);
        System.out.println(payments);
        payments=testPayment.read(payments.getID());
        System.out.println(payments);
        payments.setAmount(20);
        testPayment.update(payments);
        System.out.println(payments);
        testPayment.delete(payments);

    }
}
