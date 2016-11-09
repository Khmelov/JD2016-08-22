package by.it.kisel.project.java.dao;


import by.it.kisel.project.java.beans.Orders;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO extends AbstractDAO implements InterfaceDAO<Orders> {
    @Override
    public List<Orders> getAll(String WHERE) {
        List<Orders> orderss = new ArrayList<>();
        String sql = "SELECT * FROM orders " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setID(rs.getInt("ID"));
                orders.setArrivalDate(rs.getInt("ArrivalDate"));
                orders.setDepartureDate(rs.getInt("DepartureDate"));
                orders.setTotalPrice(rs.getInt("TotalPrice"));
                orders.setFK_rooms(rs.getInt("FK_rooms"));
                orders.setFK_persons(rs.getInt("FK_persons"));
                orderss.add(orders);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return orderss;
    }

    @Override
    public Orders read(int id) {
        List<Orders> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Orders orders) {
        String sql = String.format(
                "insert INTO orders(ArrivalDate,DepartureDate,TotalPrice,FK_rooms,FK_persons)" +
                        " values('%d','%d','%d','%d',%d);",
                orders.getArrivalDate(), orders.getDepartureDate(), orders.getTotalPrice(),orders.getFK_rooms(), orders.getFK_persons()
        );
        orders.setID(executeUpdate(sql));
        return (orders.getID()>0);
    }
    @Override
    public boolean update(Orders orders) {
        String sql = String.format(
                "UPDATE `orders` SET `ArrivalDate` = '%d', `DepartureDate` = '%d', `TotalPrice` = '%d', `FK_rooms` = '%d', `FK_persons` = '%d' WHERE `orders`.`ID` = %d",
                orders.getArrivalDate(), orders.getDepartureDate(),orders.getTotalPrice(), orders.getFK_rooms(), orders.getFK_persons(), orders.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Orders orders) {
        String sql = String.format(
                "DELETE FROM `orders` WHERE `orders`.`ID` = %d;", orders.getID()
        );
        return (0 < executeUpdate(sql));
    }

    public int getCount(String WHERE){
        int res=0;
        String sql = "SELECT Count(*) FROM orders " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)
        ) {
            if (rs.next()) {
                res=(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }




}
