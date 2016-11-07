package by.it.voronovich.project.java.dao;

import by.it.voronovich.project.java.bean.Order;
import by.it.voronovich.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO extends ADAO implements IDAO<Order> {

    @Override
    public List<Order> getAll(String WHERE) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM shoppingcart " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Order order = new Order();
                order.setIdShoppingCart(rs.getInt("idShoppingCart"));
                order.setFK_Users(rs.getInt("FK_Users"));;
                order.setFK_Catalog(rs.getInt("FK_Catalog"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public Order read(int id) {
        List<Order> orders = getAll("WHERE idShoppingCart=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Order order) {
        String sql = String.format(
                "insert INTO shoppingcart(FK_Users,FK_Catalog)" +
                        " values(%d,%d);",
                order.getFK_Users(), order.getFK_Catalog()
        );
        synchronized (OrderDAO.class){
            order.setIdShoppingCart(executeUpdate(sql));
        }
        return (order.getIdShoppingCart()>0);
    }
    @Override
    public boolean update(Order order) {
        int resultQuery;
        String sql = String.format(
                "UPDATE `shoppingcart` SET `FK_Users` = '%d',`FK_Catalog` = '%d' WHERE `shoppingcart`.`idShoppingCart` = %d",
                order.getFK_Users(), order.getFK_Catalog(), order.getIdShoppingCart()
        );
        synchronized (OrderDAO.class){
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
    @Override
    public boolean delete(Order order) {
        int resultQuery;
        String sql = String.format(
                "DELETE FROM `shoppingcart` WHERE `shoppingcart`.`idShoppingCart` = %d;", order.getIdShoppingCart()
        );
        synchronized (OrderDAO.class){
            resultQuery =executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
}
