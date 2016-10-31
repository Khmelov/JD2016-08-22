package by.it.snegurskiy.jd03.classwork.CRUD;

import by.it.snegurskiy.jd03.classwork.project.java.DAO.ConnectionCreator;
import by.it.snegurskiy.jd03.classwork.Bean.Users;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Acer on 19.10.2016.
 */
public class UsersCRUD {

    public Users create(Users user) throws SQLException {
        user.setID(0);
        //формирование строки createUserSQL по данным bean user
        String createUserSQL = String.format(Locale.ENGLISH,
                "insert into users(Surname, Name, Login,Password,FK_Role) values('%s','%s','%s','%s',%d);",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection= ConnectionCreator.getConnection();
//                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
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
                    user.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }

    public Users read(int id) throws SQLException {
        Users userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new Users(
                        resultSet.getInt("ID"),
                        resultSet.getString("Surname"),
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public Users update(Users user) throws SQLException {
        Users userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Surname = '%s',Name = '%s',Login = '%s', Password = '%s', FK_Role=%d WHERE users.ID = %d",
                user.getSurname(),user.getName(),user.getLogin(), user.getPassword(), user.getFK_Role(), user.getID()
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

    public boolean delete(Users user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getID());
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
