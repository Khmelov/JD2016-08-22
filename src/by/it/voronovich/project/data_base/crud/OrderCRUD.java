package by.it.voronovich.project.data_base.crud;

import by.it.voronovich.project.data_base.ConnectionCreator;
import by.it.voronovich.project.data_base.bean.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderCRUD {

    public Order create(Order order) throws SQLException {
        order.setIdShoppingCart(0);
        //формирование строки createUserSQL по данным bean user
        String createOrderSQL = String.format(
                "insert into shoppingcart(FK_Users, FK_Catalog) values(%d, %d);",
                order.getFK_Users(), order.getFK_Catalog()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createOrderSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    order.setIdShoppingCart(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return order;
    }

    public Order read(int idShoppingCart) throws SQLException {
        Order orderResult = null;
        String readOrderSQL = "SELECT * FROM shoppingcart where idShoppingCart=" + idShoppingCart;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readOrderSQL);
            if (resultSet.next()) {
                orderResult = new Order(
                        resultSet.getInt("idShoppingCart"),
                        resultSet.getInt("FK_Users"),
                        resultSet.getInt("FK_Catalog"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    public Order update(Order order) throws SQLException {
        Order orderResult = null;
        String updateOrderSQL = String.format(
                "UPDATE shoppingcart SET FK_Users = %d, FK_Catalog = %d WHERE shoppingcart.idShoppingCart = %d",
                order.getFK_Users(), order.getFK_Catalog(), order.getIdShoppingCart()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateOrderSQL) == 1)
                orderResult = order;
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    public boolean delete(Order order) throws SQLException {
        String deleteOrderSQL = String.format("DELETE FROM shoppingcart WHERE shoppingcart.idShoppingCart = %d", order.getIdShoppingCart());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteOrderSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}