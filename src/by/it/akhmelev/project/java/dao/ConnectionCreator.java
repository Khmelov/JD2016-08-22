package by.it.akhmelev.project.java.dao;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    //Памятка. Корректно держать настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/it_academy"
             +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (connection == null || connection.isClosed()) {
                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);
                synchronized (URL_DB) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
                }
        }
        return connection;
    }
}
