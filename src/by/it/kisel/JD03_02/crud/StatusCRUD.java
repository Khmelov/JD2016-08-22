package by.it.kisel.JD03_02.crud;


import by.it.kisel.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatusCRUD {

    public Status create(Status status) throws SQLException {
        status.setID(0);
        //формирование строки
        // createStatusSQL по данным bean status
        String createStatusSQL = String.format(
                "insert into status(OrderStatus,FK_orders) values('%s','%d');",
                status.getOrderStatus(), status.getFK_orders()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createStatusSQL) == 1) {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    status.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return status;
    }

    public Status read(int id) throws SQLException {
        Status statusResult = null;
        String readStatusSQL = "SELECT * FROM status where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readStatusSQL);
            if (resultSet.next()) {
                statusResult = new Status(
                        resultSet.getInt("ID"),
                        resultSet.getString("OrderStatus"),
                        resultSet.getInt("FK_orders"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return statusResult;
    }

    public Status update(Status status) throws SQLException {
        Status statusResult = null;
        String updateStatusSQL = String.format(
                "UPDATE status SET OrderStatus = '%s', FK_orders = '%d' WHERE status.ID = %d",
                status.getOrderStatus(), status.getFK_orders(), status.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateStatusSQL) == 1)
                statusResult = status;
        } catch (SQLException e) {
            throw e;
        }
        return statusResult;
    }

    public boolean delete(Status status) throws SQLException {
        String deleteStatusSQL = String.format("DELETE FROM status WHERE status.ID = %d", status.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteStatusSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }


}
