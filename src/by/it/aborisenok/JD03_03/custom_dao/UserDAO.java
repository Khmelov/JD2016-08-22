package by.it.aborisenok.JD03_03.custom_dao;

import by.it.aborisenok.JD03_03.beans.User;
import by.it.aborisenok.JD03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aborisenok on 26.10.2016.
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<User>{
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
                "INSERT INTO `user`(Login, Password, Name, Surname, BirthDay, City, Street, House, Flat, FK_Role) " +
                        "values('%s','%s', '%s', '%s','" + user.getBirthDay() + "','%s','%s','%d','%d', '%d');",
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getCity(),
                user.getStreet(),
                user.getHouse(),
                user.getFlat(),
                user.getFK_Role());
        user.setID(executeUpdate(sql));
        return (user.getID()>0);
    }

    @Override
    public boolean update(User user) {
        String sql = String.format(
                "UPDATE `user` SET Login = '%s'," +
                        "Password = '%s'," +
                        "Name = '%s', " +
                        "Surname = '%s', " +
                        "BirthDay = '" + user.getBirthDay() + "', " +
                        "City = '%s', " +
                        "Street = '%s', " +
                        "House = '%d', " +
                        "Flat = '%d'," +
                        "FK_Role = '%d'"+
                        " WHERE user.ID = %d",
                user.getLogin(),
                user.getPassword(),
                user.getName(),
                user.getSurname(),
                user.getCity(),
                user.getStreet(),
                user.getHouse(),
                user.getFlat(),
                user.getFK_Role(),
                user.getID());
        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql = String.format(
                "DELETE FROM `user` WHERE `user`.`ID` = %d;", user.getID()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String WHERE) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM user " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setID(rs.getInt("ID"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setBirthDay(rs.getTimestamp("BirthDay"));
                user.setCity(rs.getString("City"));
                user.setStreet(rs.getString("Street"));
                user.setHouse(rs.getInt("House"));
                user.setFlat(rs.getInt("Flat"));
                user.setFK_Role(rs.getInt("FK_Role"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
