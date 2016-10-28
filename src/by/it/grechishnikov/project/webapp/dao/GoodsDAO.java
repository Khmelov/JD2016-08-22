package by.it.grechishnikov.project.webapp.dao;

import by.it.grechishnikov.project.webapp.ConnectionToServer;
import by.it.grechishnikov.project.webapp.bean.Goods;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodsDAO implements InterfaceDAO<Goods> {
    @Override
    public boolean create(Goods obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into catalog(name,description,price) values('%s','%s', %d)",
                    obj.getName(), obj.getDescription(), obj.getPrice()));
            ResultSet set = statement.executeQuery(String.format("select id from catalog where name = '%s'", obj.getName()));
            if (set.next()) {
                obj.setId(set.getInt("id"));
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }

    @Override
    public Goods read(int id) {
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

    @Override
    public boolean update(Goods obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            String sql = String.format("update catalog set name = '%s', description = '%s'," +
                            "price = '%d' where catalog.id = %d",
                    obj.getName(), obj.getDescription(), obj.getPrice(), obj.getId());
            if(statement.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
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

    @Override
    public List<Goods> getAll() {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from catalog"));
            List<Goods> list = new ArrayList<>();
            while (set.next()) {
                list.add(new Goods(
                        set.getInt("id"),
                        set.getString("name"),
                        set.getString("description"),
                        set.getInt("price")));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }
}
