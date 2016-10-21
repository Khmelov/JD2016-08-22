package by.it.kisel.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Select {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {
            //получаем пользователей
            ResultSet resultSet = statement.executeQuery("select * from persons;");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") + ", " + resultSet.getString("SecondName");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
