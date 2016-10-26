package by.it.dubatovka.jd03_02.crud;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/dubatovka_helpdesk" +
            "?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    static {
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("error. not register driver");
        }
    }

    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
        }
        return connection;
    }
}
