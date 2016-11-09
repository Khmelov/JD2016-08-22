package by.it.voronovich.project.data_base.crud;

import by.it.voronovich.project.data_base.ConnectionCreator;
import by.it.voronovich.project.data_base.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User create(User user) throws SQLException {
        user.setIdUsers(0);
        //формирование строки createUserSQL по данным bean user
        String createUserSQL = String.format(
                "insert into users(Name, Surname, Login, Password, Email, FK_Role) values('%s','%s','%s','%s','%s',%d);",
                user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createUserSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    user.setIdUsers(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }

    public User read(int idUsers) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users where idUsers=" + idUsers;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("idUsers"),
                        resultSet.getString("Name"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Name = '%s', Surname = '%s', Login = '%s', Password = '%s', Email = '%s', FK_Role=%d WHERE users.idUsers = %d",
                user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role(), user.getIdUsers()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.idUsers = %d", user.getIdUsers());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
