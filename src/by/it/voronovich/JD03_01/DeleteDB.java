package by.it.voronovich.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

import static by.it.voronovich.JD03_01.CN.PASSWORD_DB;
import static by.it.voronovich.JD03_01.CN.URL_DB;
import static by.it.voronovich.JD03_01.CN.USER_DB;

public class DeleteDB {

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("Error register driver!" + e);
        }
        try (Connection connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            statement.execute(" DROP TABLE " + "shoppingcart");
            statement.execute(" DROP TABLE " + "users");
            statement.execute(" DROP TABLE " + "role");
            statement.execute(" DROP TABLE " + "catalog");
            System.out.println("База данных очищена!");
        } catch (SQLException e) {
            System.out.println("Error connection" + e);
        }
    }
}
