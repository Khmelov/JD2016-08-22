package by.it.dubatovka.jd01_08;

import sun.security.krb5.internal.Ticket;

/**
 * Created by Dubatovka Sergey on 18.09.2016.
 */
public class RunnerBuilding {

    public static void main(String[] args) {
        //посторили театр в один этаж на 2 места
        Theatre theatre = new Theatre("Скрыганова 14.", 2);
        System.out.println("Сценарий >>> Открыть театр. Купить билет. Посмотреть представление >>>");
        theatre.open();
        Theatre.Ticket ticket = theatre.buyTicket();
        theatre.show(ticket);

        theatre.close();
        System.out.println();
        System.out.println("Сценарий >>> . Театр закрыт. Попытаться Купить билет и Посмотреть представление >>>");
        Theatre.Ticket ticket1 = theatre.buyTicket();
        theatre.show(ticket1);

        System.out.println();
        System.out.println("Сценарий >>> Открыть театр. Попытаться Купить 2 билета и посмотреть представление >>>");
        theatre.open();
        Theatre.Ticket ticket2 = theatre.buyTicket();
        theatre.show(ticket2);
        Theatre.Ticket ticket3 = theatre.buyTicket();
        theatre.show(ticket3);

        System.out.println();
        System.out.println("Сценарий >>> Турист хочет узнать информацию о здании");
        System.out.println(theatre.info());
        System.out.println("Количество билетов: " + theatre.getFreePlaces());


    }
}
