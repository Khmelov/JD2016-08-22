package by.it.grechishnikov.jd03_02.crud;

import by.it.grechishnikov.jd03_02.ConnectionToServer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDOrders {
    public static void create(Order order) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into orderList(FK_User,FK_Goods) values('%d','%d')",
                    order.getUser(), order.getGoods()));
            ResultSet set = statement.executeQuery(String.format("select id from orderList where FK_User = '%d' and " +
                    "FK_Goods = '%d'", order.getUser(), order.getGoods()));
            if (set.next()) {
                order.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
    }

    public static Order read(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from orderList where id = '%d'", id));
            set.next();
            return new Order(
                    set.getInt("id"),
                    set.getInt("FK_User"),
                    set.getInt("FK_Goods"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    public static boolean delete(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            return statement.executeUpdate(String.format("delete from orderList where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }
}
