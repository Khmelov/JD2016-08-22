package by.it.grechishnikov.jd03_03.dao;

import by.it.grechishnikov.jd03_02.ConnectionToServer;
import by.it.grechishnikov.jd03_02.crud.Role;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RolesDAO implements InterfaceDAO<Role> {
    @Override
    public void create(Role obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into roles(name) values('%s')", obj.getName()));
            ResultSet set = statement.executeQuery(String.format("select id from roles where name = '%s'", obj.getName()));
            if (set.next()) {
                obj.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
    }

    @Override
    public Role read(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from roles where id = %d", id));
            set.next();
            return new Role(set.getInt("id"), set.getString("name"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    @Override
    public Role update(Role obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("update roles set name = '%s' where roles.id = %d",
                    obj.getName(), obj.getId()));
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            return statement.executeUpdate(String.format("delete from roles where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }

    @Override
    public List<Role> getAll() {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from roles"));
            List<Role> list = new ArrayList<>();
            while (set.next()) {
                list.add(new Role(set.getInt("id"), set.getString("name")));
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
