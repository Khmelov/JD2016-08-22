package by.it.opiga.JD03_04.Project.java.dao.myDAO;

import by.it.opiga.JD03_04.Project.java.beans.mybeans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 28.10.2016.
 */
public class UserDAO extends DAO implements InterfaceDAO<User> {

    @Override
    public User read(int id) {
        List<User> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean create(User user) {
        String sql=String.format("insert INTO t02_user(login, pass, email,FK_role)" +
                " values('%s','%s','%s','%d');",
                user.getLogin(),user.getPass(),user.getEmail(),user.getFK_role());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean update(User user) {
        String sql=String.format("UPDATE t02_user " +
                        "SET login='%s', pass='%s', email='%s',FK_role='%d'" +
                        " WHERE ID='%d';",
                user.getLogin(),user.getPass(),user.getEmail(),user.getFK_role(),user.getID());
        return (0<executeUpdate(sql));
    }

    @Override
    public boolean delete(User user) {
        String sql=String.format("DELETE FROM t02_user WHERE t02_user.ID='%d';",
          user.getID());
        return (0<executeUpdate(sql));
    }

    @Override
    public List<User> getAll(String WhereAndOrder) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM t02_user " + WhereAndOrder + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setID(resultSet.getInt("ID"));
                user.setLogin(resultSet.getString("login"));
                user.setPass(resultSet.getString("pass"));
                user.setEmail(resultSet.getString("email"));
                user.setFK_role(resultSet.getInt("FK_role"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    protected int executeUpdate(String sql) {
        return super.executeUpdate(sql);
    }
}
