package by.it.grechishnikov.project.webapp.crud;

import by.it.grechishnikov.project.webapp.java.ConnectionToServer;
import by.it.grechishnikov.project.webapp.bean.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDGoods {
    public static void create(Goods goods) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into catalog(name,description,price) values('%s','%s', %d)",
                    goods.getName(), goods.getDescription(), goods.getPrice()));
            ResultSet set = statement.executeQuery(String.format("select id from catalog where name = '%s'", goods.getName()));
            if (set.next()) {
                goods.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
    }

    public static Goods read(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from catalog where id = '%d'", id));
            set.next();
            return new Goods(
                    set.getInt("id"),
                    set.getString("name"),
                    set.getString("description"),
                    set.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    public static Goods update(Goods goods) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            String sql = String.format("update catalog set name = '%s', description = '%s'," +
                            "price = '%d' where catalog.id = %d", goods.getName(), goods.getDescription(),
                    goods.getPrice(), goods.getId());
            if(statement.executeUpdate(sql) == 1) {
                return goods;
            }
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
            return statement.executeUpdate(String.format("delete from catalog where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }
}
