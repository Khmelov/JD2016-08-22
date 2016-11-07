package by.it.voronovich.project.java.dao;

import by.it.voronovich.project.java.bean.User;
import by.it.voronovich.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends ADAO implements IDAO<User> {

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
                user.setIdUsers(rs.getInt("idUsers"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setEmail(rs.getString("Email"));
                user.setFK_Role(rs.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE idUsers=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(User user) {
        String sql = String.format(
                "insert INTO users(Name,Surname,Login,Password,Email,FK_Role)" +
                        " values('%s','%s','%s','%s','%s',%d);",
                user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role()
        );
        synchronized (UserDAO.class){
            user.setIdUsers(executeUpdate(sql));
        }
        return (user.getIdUsers()>0);
    }
    @Override
    public boolean update(User user) {
        int resultQuery;
        String sql = String.format(
                "UPDATE `users` SET `Name` = '%s',`Surname` = '%s', `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d' WHERE `users`.`idUsers` = %d",
                user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role(), user.getIdUsers()
        );
        synchronized (UserDAO.class){
            resultQuery = executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
    @Override
    public boolean delete(User user) {
        int resultQuery;
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`idUsers` = %d;", user.getIdUsers()
        );
        synchronized (UserDAO.class){
            resultQuery =executeUpdate(sql);
        }
        return (0 < resultQuery);
    }
}
