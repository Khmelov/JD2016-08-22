package by.it.shkantau.jd03.jd03_03.dao;


import by.it.shkantau.jd03.jd03_03.beans.User;
import by.it.shkantau.jd03.jd03_03.connection.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements IDAO<User> {


    @Override
    public User read(int id) {
        List<User> users =  getAll("WHERE user_id=" + id + " LIMIT 0,1");
        return (users.size() > 0) ? users.get(0) : null;
    }

    @Override
    public int create(User entity) {
        String sql = String.format("INSERT INTO users(login, pass, role, email) VALUES('%s','%s','%s','%s');",
                entity.getLogin(), entity.getPass(), entity.getRole(), entity.getEmail());
//        entity.setId(executeUpdate(sql));
        return executeUpdate(sql);
    }

    @Override
    public boolean update(User entity) {
        String sql = String.format("UPDATE `users` SET `login`='%s', `pass`='%s', `role`='%s', `email`='%s' WHERE `users`.`user_id` = %d;",
                entity.getLogin(), entity.getPass(), entity.getRole(), entity.getEmail(), entity.getId());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(User entity) {
        String sql = String.format("DELETE FROM `users` WHERE  `users`.`user_id`=%d;", entity.getId());
        executeUpdate(sql);
        return (0<executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String WhereAndOrder) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                users.add(new User(resultSet.getInt("user_id"),resultSet.getString("login"),
                        resultSet.getString("email"),resultSet.getString("pass"),resultSet.getInt("role")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
