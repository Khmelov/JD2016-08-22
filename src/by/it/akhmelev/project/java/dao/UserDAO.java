package by.it.akhmelev.project.java.dao;

import by.it.akhmelev.project.java.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {
    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("ID"));
                user.setLogin(rs.getString("login"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setFk_Role(rs.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s',%d);",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role()
        );
        user.setId(executeUpdate(sql));
        return (user.getId()>0);
    }
    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `users` SET `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d' WHERE `users`.`ID` = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_Role(), user.getId()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getId()
        );
        return (0 < executeUpdate(sql));
    }


}
