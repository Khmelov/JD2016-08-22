package by.it.voronovich.JD03_01_Check_here;

import java.sql.*;

public class ExtractionFromDB {

    public static void extractFromDB(Connection connection) throws SQLException {

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `voronovich_project`.`users`;");
        System.out.println("-----------------------------------Данные таблицы users-----------------------------------");
        while (resultSet.next()) {
            System.out.printf("Name: %s; Surname: %s; Login: %s; Password: %s; Email: %s; Role: %s\n",
                    resultSet.getString("Name"), resultSet.getString("Surname"),
                    resultSet.getString("Login"), resultSet.getString("Password"),
                    resultSet.getString("Email"), resultSet.getString("FK_Role"));
        }
        resultSet = statement.executeQuery("SELECT * FROM `voronovich_project`.`role`;");
        System.out.println("-------Данные таблицы role-------");
        while (resultSet.next()) {
            System.out.printf("%s - %s\n",
                    resultSet.getString("idRole"), resultSet.getString("Name"));
        }
    }
}