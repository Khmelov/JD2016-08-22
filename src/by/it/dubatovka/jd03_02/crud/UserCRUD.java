package by.it.dubatovka.jd03_02.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User create(User user) throws SQLException {
        user.setIdUser(0);
        String createUserSQL = String.format("insert into users(login,password,email,fk_role) values('%s','%s','%s','%d');",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(createUserSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID() FROM users;");
                if (resultSet.next())
                    user.setIdUser(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users where idUser=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("idUser"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getInt("fk_role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format("UPDATE users SET login = '%s',password ='%s', email='%s', fk_role='%d' WHERE users.idUser=%d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getIdUser());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users Where users.idUser = '%d'", user.getIdUser());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
