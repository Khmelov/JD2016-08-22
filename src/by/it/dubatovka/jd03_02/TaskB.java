package by.it.dubatovka.jd03_02;

import by.it.dubatovka.jd03_01.CN;

import java.sql.*;

public class TaskB {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS INNER JOIN role ON users.fk_role=role.ID");
            while (resultSet.next()) {

                    System.out.print(resultSet.getString(2)+ ": " + resultSet.getString(7) + "\t");
                              System.out.println();
            }
           resultSet=statement.executeQuery("select count(*) from users");
            resultSet.next();
            System.out.println("Количество пользователей: " + resultSet.getInt(1));

            resultSet=statement.executeQuery("select count(*) from role");
            resultSet.next();
            System.out.println("Количество roles: " + resultSet.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
