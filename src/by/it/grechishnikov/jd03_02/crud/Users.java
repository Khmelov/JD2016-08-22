package by.it.grechishnikov.jd03_02.crud;

import java.sql.*;

import static by.it.grechishnikov.jd03_02.Connection.statement;

public class Users {
    public static void create(User user) {
        try {
            statement.executeUpdate(String.format("insert into users(login,password,email,FK_Roles) values('%s','%s','%s',%d)", user.getLogin(),
                    user.getPassword(), user.getEmail(), user.getRole()));
            ResultSet set = statement.executeQuery(String.format("select id from users where login = '%s'", user.getLogin()));
            if (set.next()) {
                user.setId(set.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User read(int id) {
        try {
            ResultSet set = statement.executeQuery(String.format("select * from users where id = '%d'", id));
            set.next();
            User user = new User();
            user.setLogin(set.getString("login"));
            user.setPassword(set.getString("password"));
            user.setEmail(set.getString("email"));
            user.setRole(set.getInt("FK_Roles"));
            user.setId(set.getInt("id"));
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User update(User user) {
        try {
            String sql = String.format("update users set login = '%s', password = '%s'," +
                            "email = '%s', FK_Roles = '%d' where users.id = '%d'", user.getLogin(), user.getPassword(), user.getEmail(),
                    user.getRole(), user.getId());
            System.out.println(sql);
            if(statement.executeUpdate(sql) == 1) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean delete(int id) {
        try {
            return (statement.executeUpdate(String.format("delete from users where id = '%d'", id)) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
