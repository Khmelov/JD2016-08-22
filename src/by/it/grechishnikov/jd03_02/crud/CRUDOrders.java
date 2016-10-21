package by.it.grechishnikov.jd03_02.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.grechishnikov.jd03_02.Connection.statement;

public class CRUDOrders {
    public static void create(Order order) {
        try {
            statement.executeUpdate(String.format("insert into orderList(FK_User,FK_Goods) values('%d','%d')",
                    order.getUser(), order.getGoods()));
            ResultSet set = statement.executeQuery(String.format("select id from orderList where FK_User = '%d' and " +
                    "FK_Goods = '%d'", order.getUser(), order.getGoods()));
            if (set.next()) {
                order.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Order read(int id) {
        try {
            ResultSet set = statement.executeQuery(String.format("select * from orderList where id = '%d'", id));
            set.next();
            return new Order(
                    set.getInt("id"),
                    set.getInt("FK_User"),
                    set.getInt("FK_Goods"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delete(int id) {
        try {
            return statement.executeUpdate(String.format("delete from orderList where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
