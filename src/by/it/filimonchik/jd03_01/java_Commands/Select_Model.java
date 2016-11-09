package by.it.filimonchik.jd03_01.java_Commands;

import by.it.filimonchik.jd03_01.Connection.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Select_Model {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             ( CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            ResultSet resultSet = statement.executeQuery("select * from model;");
            while (resultSet.next()) {
                String out = resultSet.getString("Model");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}