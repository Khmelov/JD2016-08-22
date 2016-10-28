package by.it.opiga.JD03_02.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Asus on 19.10.2016.
 */
public class UserCRUD {
    public static user create(user usr) throws SQLException {
        String createUserSQL = String.format(
                "insert into t02_user(login,pass,email,FK_role)" +
                        "values('%s','%s','%s','%d');",
                usr.getLogin(),usr.getPass(),usr.getEmail(),usr.getFK_role());
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createUserSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery(
                        String.format(
                                "SELECT LAST_INSERT_ID();")
                );
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    usr.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return usr;
    }

    public static user read(int id) throws SQLException {
        user userResult = null;
        String readUserSQL = "SELECT * FROM t02_user where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new user(
                        resultSet.getInt("ID"),
                        resultSet.getString("login"),
                        resultSet.getString("pass"),
                        resultSet.getString("email"),
                        resultSet.getInt("FK_role")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        System.out.println(userResult.toString());
        return userResult;
    }

    public static user update(user usr) throws SQLException {
        user userResult = null;
        String updateUserSQL = String.format(
                "UPDATE t02_user SET login = '%s', pass = '%s', email = '%s', FK_role='%d' " +
                        "WHERE t02_user.ID = '%d'",
                usr.getLogin(),usr.getPass(),usr.getEmail(),usr.getFK_role(),usr.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = usr;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public static boolean delete(int id) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM t02_user WHERE t02_user.ID = '%d'", id);
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
