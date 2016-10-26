package by.it.kisel.JD03_02;

import by.it.kisel.JD03_02.crud.*;

import java.sql.SQLException;

public class ExCRUD {
    public static void main(String[] args) {

        Rooms rooms = new Rooms(1, 3, 8, 180, "Yes", "Good room");
        Orders orders = new Orders(1, 10, 20, 0, 1, 2);
        Status status = new Status(1,"available",1);
        try {
            //проверка CRUD
            OrdersCRUD ordersCRUD = new OrdersCRUD();
            StatusCRUD statusCRUD = new StatusCRUD();

            //создание
            orders=ordersCRUD.create(orders);
            status=statusCRUD.create(status);

            //чтение
//            System.out.print(ordersCRUD.read(orders.getID()));
//            System.out.print(statusCRUD.read(status.getID()));

            //обновление
            orders.setTotalPrice((orders.getDepartureDate()-orders.getArrivalDate())*rooms.getPriceForDay());
            orders=ordersCRUD.update(orders);

//            System.out.print(ordersCRUD.read(orders.getID()));
            //удаление
//            if (ordersCRUD.delete(orders))
//                System.out.print("Удален №"+orders.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
