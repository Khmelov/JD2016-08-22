package by.it.grechishnikov.project.webapp.java.dao;

import by.it.grechishnikov.project.webapp.java.ConnectionToServer;
import by.it.grechishnikov.project.webapp.java.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO implements InterfaceDAO<User> {
    @Override
    public boolean create(User obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            statement.executeUpdate(String.format("insert into users(login,password,email,FK_Roles) values('%s','%s','%s',%d)",
                    obj.getLogin(), obj.getPassword(), obj.getEmail(), obj.getRole()));
            ResultSet set = statement.executeQuery(String.format("select id from users where login = '%s'", obj.getLogin()));
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
    public User read(int id) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from users where id = '%d'", id));
            set.next();
            return new User(
                    set.getInt("id"),
                    set.getString("login"),
                    set.getString("password"),
                    set.getString("email"),
                    set.getInt("FK_Roles"));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return null;
    }

    @Override
    public boolean update(User obj) {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            String sql = String.format("update users set login = '%s', password = '%s'," +
                            "email = '%s', FK_Roles = '%d' where users.id = %d",
                    obj.getLogin(), obj.getPassword(), obj.getEmail(), obj.getRole(), obj.getId());
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
            return statement.executeUpdate(String.format("delete from users where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToServer.closeConnection();
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = ConnectionToServer.getInstance().createStatement();
            ResultSet set = statement.executeQuery(String.format("select * from users"));
            List<User> list = new ArrayList<>();
            while (set.next()) {
                list.add(new User(
                        set.getInt("id"),
                        set.getString("login"),
                        set.getString("password"),
                        set.getString("email"),
                        set.getInt("FK_Roles")
                ));

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
