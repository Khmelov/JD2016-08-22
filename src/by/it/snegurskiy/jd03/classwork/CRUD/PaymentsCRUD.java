package by.it.snegurskiy.jd03.classwork.CRUD;

import by.it.snegurskiy.jd03.classwork.ConnectionCreator;
import by.it.snegurskiy.jd03.classwork.Bean.Payments;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class PaymentsCRUD {
    public Payments create(Payments payment) throws SQLException {
        payment.setID(0);
        //формирование строки createUserSQL по данным bean user
        String createPaymentSQL = String.format(Locale.ENGLISH,
                "insert into payments (Data, Type, Amount, Source, FK_account) values(%tF,'%s',%d,%d,%d);",
                payment.getData(),payment.getType(),payment.getAmount(), payment.getSource(), payment.getFK_account()
        );
        try (
                //создаем соединение и объект для запросов к базе
                Connection connection= ConnectionCreator.getConnection();
//                Connection connection = ConnectionCreator.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); //создаем объект для обращения к базе
        ) {
            //выполняем добавление в базу, должна быть добавлена одна запись. Проверим это.
            //create(insert) update delete - это executeUpdate, а select это executeQuery
            if (statement.executeUpdate(createPaymentSQL) == 1)
            {
                //если все добавлено то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                //извлекаем из resultSet последний ID
                if (resultSet.next())
                    payment.setID(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw e;
        }
        return payment;
    }

    public Payments read(int id) throws SQLException {
        Payments paymentResult = null;
        String readPaymentsSQL = "SELECT * FROM payments where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readPaymentsSQL);
            if (resultSet.next()) {
                paymentResult = new Payments(
                        resultSet.getInt("ID"),
                        resultSet.getTimestamp("Data"),
                        resultSet.getString("Type"),
                        resultSet.getInt("Amount"),
                        resultSet.getInt("Source"),
                        resultSet.getInt("FK_account"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return paymentResult;
    }

    public Payments update(Payments payments) throws SQLException {
        Payments paymentsResult = null;
        String updatePaymentsSQL = String.format(
                "UPDATE payments SET Data = '%tF', Type = '%s', Amount = %d, Source = %d, FK_account=%d WHERE payments.ID = %d",
                payments.getData(),payments.getType(),payments.getAmount(), payments.getSource(), payments.getFK_account(), payments.getID()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updatePaymentsSQL) == 1)
                paymentsResult = payments;
        } catch (SQLException e) {
            throw e;
        }
        return paymentsResult;
    }

    public boolean delete(Payments payment) throws SQLException {
        String deletePaymentsSQL = String.format("DELETE FROM payments WHERE payments.ID = %d", payment.getID());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deletePaymentsSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
