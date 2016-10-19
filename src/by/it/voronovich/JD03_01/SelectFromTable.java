package by.it.voronovich.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import static by.it.voronovich.JD03_01.CN.PASSWORD_DB;
import static by.it.voronovich.JD03_01.CN.URL_DB;
import static by.it.voronovich.JD03_01.CN.USER_DB;

public class SelectFromTable {

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Error register driver!" + e);
        }
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM `voronovich_project`.`users`;");
            while (resultSet.next()) {
                System.out.printf("Name: %s; Surname: %s; Login: %s; Password: %s; E-mail: %s; Role: %s\n",
                        resultSet.getString("Name"), resultSet.getString("Surname"),
                        resultSet.getString("Login"), resultSet.getString("Password"),
                        resultSet.getString("E-mail"), resultSet.getString("FK_Role"));
            }
            resultSet = statement.executeQuery("SELECT * FROM `voronovich_project`.`role`;");
            while (resultSet.next()) {
                System.out.printf("%s - %s\n",
                        resultSet.getString("idRole"),resultSet.getString("Name"));
            }
        } catch (SQLException e) {
            System.out.println("Error connection" + e);
        }
    }
}