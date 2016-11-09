package by.it.snegurskiy.Project.java.DAO;


import by.it.snegurskiy.Project.java.Action;
import by.it.snegurskiy.Project.java.Bean.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements InterfaceDAO<Users> {
    public int C;

    @Override
    public List<Users> getAll(String WHERE) {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM users " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Users user = new Users();
                user.setID(rs.getInt("ID"));
                user.setSurname(rs.getString("Surname"));
                user.setName(rs.getString("Name"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setFK_Role(rs.getInt("FK_Role"));
                user.setFK_Status(rs.getInt("FK_Status"));
                users.add(user);
            }
        } catch (SQLException e) {
            //тут нужно логгирование SQLException(e);
        }
        return users;
    }

    @Override
    public Users read(int id) {
        List<Users> users = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (users.size() > 0) {
            return users.get(0);
        } else
            return null;
    }
    @Override
    public boolean create(Users user) {
        String sql = String.format(
                "INSERT INTO users (Surname, Name, Login,Password,FK_Role,FK_Status) VALUES ('%s','%s','%s','%s',%d,%d);",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role(), user.getFK_Status()
        );
        //executeUpdate(sql);
        System.out.println(sql);
        user.setID(executeUpdate(sql));
        return (user.getID()>0);
    }
    @Override
    public boolean update(Users user) {
        String sql = String.format(
                "UPDATE users SET Surname = '%s',Name = '%s',Login = '%s', Password = '%s', FK_Role=%d, FK_Status=%d WHERE users.ID = %d",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role(), user.getFK_Status(), user.getID()
        );
        return (0 < executeUpdate(sql));
    }
    @Override
    public boolean delete(Users user) {
        String sql = String.format(
                "DELETE FROM `users` WHERE `users`.`ID` = %d;", user.getID()
        );
        return (0 < executeUpdate(sql));
    }


}
