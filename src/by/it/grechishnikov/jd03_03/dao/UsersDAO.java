package by.it.grechishnikov.jd03_03.dao;

import by.it.grechishnikov.jd03_02.Connection;
import by.it.grechishnikov.jd03_02.crud.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Evgeniy on 21.10.16.
 */
public class UsersDAO implements InterfaceDAO<User> {
    @Override
    public void create(User obj) {
        try {
            Statement statement = Connection.startConnection();
            statement.executeUpdate(String.format("insert into users(login,password,email,FK_Roles) values('%s','%s','%s',%d)",
                    obj.getLogin(), obj.getPassword(), obj.getEmail(), obj.getRole()));
            ResultSet set = statement.executeQuery(String.format("select id from users where login = '%s'", obj.getLogin()));
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
    public User read(int id) {
        try {
            Statement statement = Connection.startConnection();
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
            Connection.closeConnection();
        }
        return null;
    }

    @Override
    public User update(User obj) {
        try {
            Statement statement = Connection.startConnection();
            String sql = String.format("update users set login = '%s', password = '%s'," +
                            "email = '%s', FK_Roles = '%d' where users.id = %d",
                    obj.getLogin(), obj.getPassword(), obj.getEmail(), obj.getRole(), obj.getId());
            if(statement.executeUpdate(sql) == 1) {
                return obj;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Statement statement = Connection.startConnection();
            return statement.executeUpdate(String.format("delete from users where id = %d", id)) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        try {
            Statement statement = Connection.startConnection();
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
            Connection.closeConnection();
        }
        return null;
    }
}
