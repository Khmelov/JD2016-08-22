package by.it.zaharova.JD03_02;

import by.it.zaharova.JD03_02.crud.*;

import java.sql.SQLException;

public class ExCRUD {
    public static void main(String[] args) {


        Diagnostic diagnostic  = new Diagnostic(1, "prostuda", "drugs", "operation", "procedures", 1, 1);
        Status status = new Status(1,"bolen",1);
        try {
            //проверка CRUD
            DiagnosticCRUD ordersCRUD = new DiagnosticCRUD();
            StatusCRUD statusCRUD = new StatusCRUD();

            //создание
            diagnostic=ordersCRUD.create(diagnostic);
            status=statusCRUD.create(status);

            //чтение
//
//            System.out.print(statusCRUD.read(status.getID()));

            //обновление

            status=statusCRUD.update(status);

//            System.out.print(ordersCRUD.read(orders.getID()));
            //удаление
//            if (ordersCRUD.delete(orders))
//                System.out.print("Удален №"+orders.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
