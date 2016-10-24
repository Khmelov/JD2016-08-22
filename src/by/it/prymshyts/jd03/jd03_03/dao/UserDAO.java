package by.it.prymshyts.jd03.jd03_03.dao;

import by.it.prymshyts.jd03.DB;
import by.it.prymshyts.jd03.jd03_03.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends DAO implements InterfaceDAO<User> {
    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1;");
        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    @Override
    public boolean create(User user) {
        String createUserSQL = String.format(
                "INSERT INTO Users(Mail, Login, Password, FK_Role)" +
                        " VALUES('%s', '%s', '%s', %d);",
                user.getMail(),
                user.getLogin(),
                user.getPassword(),
                user.getFK_Role());
        return (0 < executeUpdate(createUserSQL));
    }

    @Override
    public boolean update(User user) {
        String updateUserSQL = String.format(
                "UPDATE Users SET Mail='%s'," +
                        " Login='%s', Password='%s', FK_Role=%d" +
                        " WHERE Users.ID=%d;",
                user.getMail(),
                user.getLogin(),
                user.getPassword(),
                user.getFK_Role(),
                user.getID());
        return (0 < executeUpdate(updateUserSQL));
    }

    @Override
    public boolean delete(User user) {
        String deleteUserSQL = String.format(
                "DELETE FROM Users WHERE Users.ID=%d", user.getID());
        return (0 < executeUpdate((deleteUserSQL)));
    }

    @Override
    public List<User> getAll() {
        return getAll("");
    }

    @Override
    public List<User> getAll(String condition) {
        List<User> users = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Users " + condition + ";";

        try (Connection connection = DB.getConnection();
             Statement statement   = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Mail"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
