package by.it.grechishnikov.jd03_02.crud;

import java.sql.*;
import by.it.grechishnikov.jd03_02.Connection;

public class CRUDUsers {
    public static void create(User user) {
        try {
            Statement statement = Connection.startConnection();
            statement.executeUpdate(String.format("insert into users(login,password,email,FK_Roles) values('%s','%s','%s',%d)", user.getLogin(),
                    user.getPassword(), user.getEmail(), user.getRole()));
            ResultSet set = statement.executeQuery(String.format("select id from users where login = '%s'", user.getLogin()));
            if (set.next()) {
                user.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
    }

    public static User read(int id) {
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

    public static User update(User user) {
        try {
            Statement statement = Connection.startConnection();
            String sql = String.format("update users set login = '%s', password = '%s'," +
                            "email = '%s', FK_Roles = '%d' where users.id = %d", user.getLogin(), user.getPassword(), user.getEmail(),
                    user.getRole(), user.getId());
            if(statement.executeUpdate(sql) == 1) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Connection.closeConnection();
        }
        return null;
    }

    public static boolean delete(int id) {
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
}
