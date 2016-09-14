package by.it.akhmelev.jd01_11.Collections;

import java.util.ArrayList;
public class UncheckCheckRun {
    public static void main(String[ ] args) {
        ArrayList raw = new ArrayList() { // "сырая" коллекция – raw type
            { // логический блок анонимного класса
                add(new Order(231, 12.f));
                add(new Item(23154, 120.f, "Xerox"));
                add(new Order(217, 1.7f));
            }
        };
        // при извлечении требуется приведение типов, даже если они разные для разных элементов.
        Order or1 = (Order) raw.get(0); //raw.get(0).getClass покажет jd01_11.Collections.Order,
        Item or2 = (Item) raw.get(1);   //а тут jd01_11.Collections.Item
        Order or3 = (Order) raw.get(2); //все ВСЕ РАВНО требуется явное приведение
        for (Object ob : raw) {
            System.out.println("raw " + ob);
        }

        // "несырая" коллекция. Работает как нужно, но чужие данные к себе не пустит.
        ArrayList<Order> orders = new ArrayList<Order>() {
            {
                add(new Order(231, 12.f));
                add(new Order(389, 2.9f));
                add(new Order(217, 1.7f));
            // add(new Item(23154, 120.f, "Xerox"));
            // ошибка компиляции: список параметризован
            }
        };
        for (Order ob : orders) {
            System.out.println("Order: " + ob);
        }

        //Вывод. ArrayList - это generic-класс.
        //Поэтому его нужно обязательно объявлять с каким-то типом (хотя бы Object).
        //"сырая" коллекция - трюк, который работает, если "вручную" котролировать типы
        //но он редко полезен.

    }

}