package by.it.opiga.JD03_03.dao;

import by.it.opiga.JD03_03.beans.Order;
import by.it.opiga.JD03_04.project.java.dao.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 28.10.2016.
 */
public class OrderDAO extends DAO implements InterfaceDAO<Order> {
    @Override
    public Order read(int id) {
        List<Order> orders = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (orders.size() > 0) {
            return orders.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Order order) {
        String sql = String.format("insert INTO t03_order(fio, passport, phone,category," +
                        "arrive,leavee,payment,FK_user,FK_status)" +
                        " values('%s','%s','%d','%s','%d','%d','%s','%d','%d');",
                order.getFio(), order.getPassport(), order.getPhone(), order.getCategory(),
                order.getArrive(), order.getLeave(), order.getPayment(), order.getFK_user(),
                order.getFK_status());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean update(Order order) {
        String sql = String.format("UPDATE 't03_order'" +
                        "SET fio='%s', passport='%s', phone='%d',category='%s'," +
                        "arrive='%d',leavee='%d',payment='%s',FK_user='%d',FK_status='%d'" +
                        " WHERE id='%d';)",
                order.getFio(), order.getPassport(), order.getPhone(), order.getCategory(),
                order.getArrive(), order.getLeave(), order.getPayment(), order.getFK_user(),
                order.getFK_status(), order.getId());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Order order) {
        String sql=String.format("DELETE FROM 't03_order' WHERE 't03_order'.ID='%d';",
                order.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public List<Order> getAll(String WhereAndOrder) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM t03_order " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("ID"));
                order.setFio(resultSet.getString("fio"));
                order.setPassport(resultSet.getString("passport"));
                order.setPhone(resultSet.getInt("phone"));
                order.setCategory(resultSet.getString("category"));
                order.setArrive(resultSet.getInt("arrive"));
                order.setLeave(resultSet.getInt("leavee"));
                order.setPayment(resultSet.getString("payment"));
                order.setFK_user(resultSet.getInt("FK_user"));
                order.setFK_status(resultSet.getInt("FK_status"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
}
