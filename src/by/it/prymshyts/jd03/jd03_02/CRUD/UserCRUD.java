package by.it.prymshyts.jd03.jd03_02.CRUD;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        user.setID(0);
        String createUserSQL = String.format(
                "INSERT INTO Users(Mail, Login, Password, FK_Role)" +
                        " VALUES('%s', '%s', '%s', %d);",
                user.getMail(),
                user.getLogin(),
                user.getPassword(),
                user.getFK_Role());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(createUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = String.format(
                "SELECT * FROM Users WHERE ID=%d", id);

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Mail"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role")
                );
            }
        } catch (SQLException e) {
            throw e;
        }

        return userResult;
    }

    public boolean update(User user) throws SQLException {
        String updateUserSQL = String.format(
                "UPDATE Users SET Mail='%s'," +
                        " Login='%s', Password='%s', FK_Role=%d" +
                        " WHERE Users.ID=%d;",
                user.getMail(),
                user.getLogin(),
                user.getPassword(),
                user.getFK_Role(),
                user.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(updateUserSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format(
                "DELETE FROM Users WHERE Users.ID=%d", user.getID());

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw  e;
        }
    }

    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> userArrayList = new ArrayList<>();
        String getAllSQL = "SELECT * FROM Users;";

        try (Connection connection = DB.getConnection();
             Statement statement = connection.createStatement()
        ) {


            ResultSet resultSet = statement.executeQuery(getAllSQL);
            while (resultSet.next()) {
                userArrayList.add(new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Mail"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role")
                ));
            }
        } catch (SQLException e) {
            throw e;
        }

        return userArrayList;
    }
}
