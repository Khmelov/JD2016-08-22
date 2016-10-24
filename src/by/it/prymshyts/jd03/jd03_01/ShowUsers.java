package by.it.prymshyts.jd03.jd03_01;

import by.it.prymshyts.jd03.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowUsers {
    public static void main(String[] args) {
        showUsers();
    }

    public static void showUsers() {
        try (Connection connection = DB.getConnection()) {
            if (!connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT Users.Login, Role.Role FROM Users INNER JOIN Role ON Users.FK_Role=Role.ID;");

                while (resultSet.next()) {
                    System.out.printf("Login: %-10s\tRole: %-10s\n", resultSet.getString("Login"), resultSet.getString("Role"));
                }

                statement.close();
            } else {
                System.out.println("Соединениес БД не было установлено");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
