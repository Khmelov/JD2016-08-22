package by.it.dubatovka.jd03_03.dao;


import by.it.dubatovka.jd03_02.crud.ConnectionCreator;
import by.it.dubatovka.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<User> {

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else return null;
    }

    @Override
    public boolean create(User user) {
        String createUserSQL = String.format("insert into users(login,password,email,fk_role) values('%s','%s','%s','%d');",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
        user.setID(executeUpdate(createUserSQL));
        return (0 < user.getID());
    }

    @Override
    public boolean update(User user) {
        String updateUserSQL = String.format("UPDATE users SET login = '%s',password ='%s', email='%s', fk_role='%d' WHERE users.ID='%d'",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getID());
        return (0 < executeUpdate(updateUserSQL));
    }

    @Override
    public boolean delete(User user) {
        String deleteUserSQL = String.format("DELETE FROM users Where users.ID = '%d'", user.getID());
        return (0 < executeUpdate(deleteUserSQL));
    }

    @Override
    public List<User> getAll(String Where) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + Where + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFk_role(rs.getInt("fk_role"));
                users.add(user);
            }
        } catch (SQLException e) {
        }
        return users;
    }
}
