package by.it.voronovich.JD03_02.task_B;

import by.it.voronovich.JD03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class CountAndPrintUsers {

    public static void main(String[] args) {

        int countUsers = 0;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {

            //получаем пользователей. Если неизвестно число полей, то нужно получить метаданные
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN role ON users.FK_Role=role.idRole");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
                countUsers++;
            }
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM role;");
            if (resultSet.next()) {
                System.out.println("Количество пользователей: " + countUsers + " Количество ролей: " + resultSet.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
