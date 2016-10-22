package by.it.grechishnikov.jd03_03.dao;

import by.it.grechishnikov.jd03_02.Connection;
import by.it.grechishnikov.jd03_02.crud.Order;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO implements InterfaceDAO<Order> {
    @Override
    public void create(Order obj) {
        try {
            Statement statement = Connection.startConnection();
            statement.executeUpdate(String.format("insert into orderList(FK_User,FK_Goods) values('%d','%d')",
                    obj.getUser(), obj.getGoods()));
            ResultSet set = statement.executeQuery(String.format("select id from orderList where FK_User = '%d' and " +
                    "FK_Goods = '%d'", obj.getUser(), obj.getGoods()));
            if (set.next()) {
                obj.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
    }

    @Override
    public Order read(int id) {
        try {
            Statement statement = Connection.startConnection();
            ResultSet set = statement.executeQuery(String.format("select * from orderList where id = '%d'", id));
            set.next();
            return new Order(
                    set.getInt("id"),
                    set.getInt("FK_User"),
                    set.getInt("FK_Goods"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return null;
    }

    @Override
    public Order update(Order obj) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = Connection.startConnection();
            return statement.executeUpdate(String.format("delete from orderList where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return false;
    }

    @Override
    public List<Order> getAll() {
        try {
            Statement statement = Connection.startConnection();
            ResultSet set = statement.executeQuery(String.format("select * from orderList"));
            List<Order> list = new ArrayList<>();
            while (set.next()) {
                list.add(new Order(
                        set.getInt("id"),
                        set.getInt("FK_User"),
                        set.getInt("FK_Goods")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return null;
    }
}
