package by.it.kisel.JD03_02.crud;


import by.it.kisel.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrdersCRUD {

    public Orders create(Orders orders) throws SQLException {
        orders.setID(0);
        //формирование строки
        // createOrdersSQL по данным bean orders
        String createOrdersSQL = String.format(
                "insert into orders(ArrivalDate,DepartureDate,TotalPrice,FK_rooms,FK_persons) values('%d','%d','%d','%d',%d);",
                orders.getArrivalDate(), orders.getDepartureDate(), orders.getTotalPrice(), orders.getFK_rooms(), orders.getFK_persons()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createOrdersSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    orders.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return orders;
    }

    public Orders read(int id) throws SQLException {
        Orders ordersResult = null;
        String readOrdersSQL = "SELECT * FROM orders where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readOrdersSQL);
            if (resultSet.next()) {
                ordersResult = new Orders(
                        resultSet.getInt("ID"),
                        resultSet.getInt("ArrivalDate"),
                        resultSet.getInt("DepartureDate"),
                        resultSet.getInt("TotalPrice"),
                        resultSet.getInt("FK_rooms"),
                        resultSet.getInt("FK_persons"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ordersResult;
    }

    public Orders update(Orders orders) throws SQLException {
        Orders ordersResult = null;
        String updateOrdersSQL = String.format(
                "UPDATE orders SET ArrivalDate = '%d', DepartureDate = '%d', TotalPrice = '%d', FK_rooms = '%d', FK_persons=%d WHERE orders.ID = %d",
                orders.getArrivalDate(), orders.getDepartureDate(), orders.getTotalPrice(), orders.getFK_rooms(), orders.getFK_persons(), orders.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateOrdersSQL) == 1)
                ordersResult = orders;
        } catch (SQLException e) {
            throw e;
        }
        return ordersResult;
    }

    public boolean delete(Orders orders) throws SQLException {
        String deleteOrdersSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", orders.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteOrdersSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
