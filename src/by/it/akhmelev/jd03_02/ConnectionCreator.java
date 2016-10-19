package by.it.akhmelev.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    //Памятка. Корректно держать эти настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/it_academy"
             +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //==============================================================================
    //регистрация драйвера
    static {
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("error: not register driver");
        }
    }

    //==============================================================================
    //аналог синглтона на случай множественного обращения
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
    //==============================================================================
    //getConnection как синглтон это не саме удачное решение, т.к.
    //два потока могут работать на одном подключении
    //что обязательно потребует их синхронизации
    //для этих целей удобнее применять пул подключений к базе.
    //этот вопрос мы рассмотрим на следующем занятии

}
