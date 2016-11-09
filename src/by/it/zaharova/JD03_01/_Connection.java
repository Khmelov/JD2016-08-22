package by.it.zaharova.JD03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class _Connection {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (java.sql.Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);){
                if (!connection.isClosed())
                    System.out.println("Соединение установлено");
                connection.close();
                if (connection.isClosed())
                    System.out.println("Соединение прервано");
            }
            catch (Exception e){
                e.printStackTrace();
            }

    }
}
