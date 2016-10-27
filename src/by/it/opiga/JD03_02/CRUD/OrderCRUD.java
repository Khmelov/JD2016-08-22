package by.it.opiga.JD03_02.CRUD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Asus on 19.10.2016.
 */
public class OrderCRUD {
    public static order create(order ord) throws SQLException {
       // ord.setId(0);
        //формирование строки createUserSQL по данным bean order
        String createUserSQL = String.format(
                "insert into t03_order(fio,passport,phone,category,arrive,leavee,payment,FK_user,FK_status)" +
                        "values('%s','%s','%d','%s','%d','%d','%s','%d','%d');",
                ord.getFio(), ord.getPassport(),ord.getPhone(), ord.getCategory(), ord.getArrive(), ord.getLeave(), ord.getPayment(),
                ord.getFK_user(),ord.getFK_status());
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
                    ord.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return ord;
    }

    public static order read(int id) throws SQLException {
        order userResult = null;
        String readUserSQL = "SELECT * FROM t03_order where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new order(
                        resultSet.getInt("ID"),
                        resultSet.getString("fio"),
                        resultSet.getString("passport"),
                        resultSet.getInt("phone"),
                        resultSet.getString("category"),
                        resultSet.getLong("arrive"),
                        resultSet.getLong("leavee"),
                        resultSet.getString("payment"),
                        resultSet.getInt("FK_user"),
                        resultSet.getInt("FK_status")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        System.out.println(userResult.toString());
        return userResult;
    }

    public static order update(order ord) throws SQLException {
        order userResult = null;
        String updateUserSQL = String.format(
                "UPDATE t03_order SET fio = '%s', passport = '%s', phone = '%d', category='%s' " +
                        ", arrive='%d', leavee='%d', payment='%s', FK_user='%d', FK_status='%d' WHERE (t03_order.ID = '%d')",
                ord.getFio(), ord.getPassport(), ord.getPhone(), ord.getCategory(),
                ord.getArrive(), ord.getLeave(), ord.getPayment(), ord.getFK_user(),ord.getFK_status(), ord.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = ord;
        } catch (SQLException e) {
            throw e;
        }
        System.out.println(userResult.toString());
        return userResult;
    }

    public static boolean delete(int id) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM t03_order WHERE t03_order.ID = '%d'", id);
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
