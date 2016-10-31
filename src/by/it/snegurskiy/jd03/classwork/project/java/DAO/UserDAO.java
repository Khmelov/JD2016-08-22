package by.it.snegurskiy.jd03.classwork.project.java.DAO;

import by.it.snegurskiy.jd03.classwork.project.java.Bean.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 24.10.2016.
 */
public class UserDAO extends AbstractDAO implements InterfaceDAO<by.it.snegurskiy.jd03.classwork.project.java.Bean.Users> {
    @Override
    public List<by.it.snegurskiy.jd03.classwork.project.java.Bean.Users> getAll(String WHERE) {
        List<by.it.snegurskiy.jd03.classwork.project.java.Bean.Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                by.it.snegurskiy.jd03.classwork.project.java.Bean.Users user = new by.it.snegurskiy.jd03.classwork.project.java.Bean.Users();
                user.setID(rs.getInt("ID"));
                user.setSurname(rs.getString("Surname"));
                user.setName(rs.getString("Name"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("password"));
                user.setFK_Role(rs.getInt("FK_Role"));
                users.add(user);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return users;
    }

    @Override
    public by.it.snegurskiy.jd03.classwork.project.java.Bean.Users read(int id) {
        List<by.it.snegurskiy.jd03.classwork.project.java.Bean.Users> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(by.it.snegurskiy.jd03.classwork.project.java.Bean.Users user) {
        String sql = String.format(
                "insert into users(Surname, Name, Login,Password,FK_Role) values('%s','%s','%s','%s',%d);",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role()
        );
        user.setID(executeUpdate(sql));
        return (user.getID()>0);
    }
    @Override
    public boolean update(by.it.snegurskiy.jd03.classwork.project.java.Bean.Users user) {
        String sql = String.format(
                "UPDATE users SET Surname = '%s',Name = '%s',Login = '%s', Password = '%s', FK_Role=%d WHERE users.ID = %d",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role(), user.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(by.it.snegurskiy.jd03.classwork.project.java.Bean.Users user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
