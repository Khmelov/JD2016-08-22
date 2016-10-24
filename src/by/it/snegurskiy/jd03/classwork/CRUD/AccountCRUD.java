package by.it.snegurskiy.jd03.classwork.CRUD;

import by.it.snegurskiy.jd03.classwork.Bean.Account;
import by.it.snegurskiy.jd03.classwork.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Acer on 19.10.2016.
 */
public class AccountCRUD {

    public Account create(Account account) throws SQLException {
        account.setID(0);
        //формирование строки createUserSQL по данным bean user
        String createAccountSQL = String.format(Locale.ENGLISH,
                "insert into account(Balance, Status,FK_users, FK_roleaccount) values(%d,%d,%d,%d);",
                account.getBalance(),account.getStatus(), account.getFK_users(), account.getFK_roleaccount()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection= ConnectionCreator.getConnection();
//                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createAccountSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    account.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return account;
    }

    public Account read(int id) throws SQLException {
        Account accountResult = null;
        String readAccountSQL = "SELECT * FROM account where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readAccountSQL);
            if (resultSet.next()) {
                accountResult = new Account(
                        resultSet.getInt("ID"),
                        resultSet.getInt("Balance"),
                        resultSet.getInt("Status"),
                        resultSet.getInt("FK_users"),
                        resultSet.getInt("FK_roleaccount"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return accountResult;
    }

    public Account update(Account account) throws SQLException {
        Account accountResult = null;
        String updateAccountSQL = String.format(
                "UPDATE account SET Balance = %d,Status = %d, FK_users=%d, FK_roleaccount=%d WHERE account.ID=%d",
                account.getBalance(),account.getStatus(), account.getFK_users(), account.getFK_roleaccount(), account.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateAccountSQL) == 1)
                accountResult = account;
        } catch (SQLException e) {
            throw e;
        }
        return accountResult;
    }

    public boolean delete(Account account) throws SQLException {
        String deleteAccountSQL = String.format("DELETE FROM account WHERE account.ID = %d", account.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteAccountSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
