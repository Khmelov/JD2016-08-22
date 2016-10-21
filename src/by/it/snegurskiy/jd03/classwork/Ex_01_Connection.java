package by.it.snegurskiy.jd03.classwork;

import by.it.akhmelev.jd03_01.CN;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Acer on 17.10.2016.
 */
public class Ex_01_Connection {
    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
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
