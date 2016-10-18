package by.it.grechishnikov.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TaskB {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Store"+
                "?useUnicode=true&amp;characterEncoding=UTF-8",
                "root", "")) {
            Statement statement = connection.createStatement();
            //добавляем пользователя
            statement.executeUpdate("INSERT INTO users (login, password, email, FK_Roles) " +
                                    "VALUES ('Vovan', '111111', 'vov4ik@mail.ru', 2)");
            //выводим пользователей и их роль на экран
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while(resultSet.next()) {
                String role = resultSet.getString("FK_Roles").equals("1") ? "admin" : "user";
                System.out.println(resultSet.getString("login") + ", " + role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}