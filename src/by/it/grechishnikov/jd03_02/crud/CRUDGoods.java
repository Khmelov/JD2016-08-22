package by.it.grechishnikov.jd03_02.crud;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.it.grechishnikov.jd03_02.Connection.statement;

public class CRUDGoods {
    public static void create(Goods goods) {
        try {
            statement.executeUpdate(String.format("insert into catalog(name,description,price) values('%s','%s', %d)",
                    goods.getName(), goods.getDescription(), goods.getPrice()));
            ResultSet set = statement.executeQuery(String.format("select id from catalog where name = '%s'", goods.getName()));
            if (set.next()) {
                goods.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Goods read(int id) {
        try {
            ResultSet set = statement.executeQuery(String.format("select * from catalog where id = '%d'", id));
            set.next();
            return new Goods(
                    set.getInt("id"),
                    set.getString("name"),
                    set.getString("description"),
                    set.getInt("price"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Goods update(Goods goods) {
        try {
            String sql = String.format("update catalog set name = '%s', description = '%s'," +
                            "price = '%d' where catalog.id = '%d'", goods.getName(), goods.getDescription(),
                    goods.getPrice(), goods.getId());
            if(statement.executeUpdate(sql) == 1) {
                return goods;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delete(int id) {
        try {
            return statement.executeUpdate(String.format("delete from catalog where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
