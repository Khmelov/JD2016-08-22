package by.it.shkantau.jd03.jd03_02.crud;

import by.it.shkantau.jd03.jd03_01.ConnectionCreator;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserCRUD extends AbstractDAO implements ICRUD <UserBean> {


    @Override
    public UserBean read(int id) {
        List<UserBean> users =  getAll("WHERE user_id=" + id + " LIMIT 0,1");
        return (users.size() > 0) ? users.get(0) : null;
    }

    @Override
    public int create(UserBean entity) {
        String sql = String.format("INSERT INTO users(login, pass, role, email) VALUES('%s','%s','%s','%s');",
                entity.getLogin(), entity.getPass(), entity.getRole(), entity.getEmail());
        entity.setId(executeUpdate(sql));
        return entity.getId();
    }

    @Override
    public int update(UserBean entity) {
        String sql = String.format("UPDATE `users` SET `login`='%s', `pass`='%s', `role`='%s', `email`='%s' WHERE `users`.`user_id` = %d;",
                entity.getLogin(), entity.getPass(), entity.getRole(), entity.getEmail(), entity.getId());
        executeUpdate(sql);
        return entity.getId();
    }

    @Override
    public int delete(UserBean entity) {
        String sql = String.format("DELETE FROM `users` WHERE  `users`.`user_id`=%d;", entity.getId());
        executeUpdate(sql);
        return entity.getId();
    }

    @Override
    public List<UserBean> getAll(String WhereAndOrder) {
        List<UserBean> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WhereAndOrder + ";";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                users.add(new UserBean(resultSet.getInt("user_id"),resultSet.getString("login"),
                        resultSet.getString("email"),resultSet.getString("pass"),resultSet.getInt("role")));
            }

        } catch (SQLException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
