package by.it.snegurskiy.Project.java.DAO;

import com.mysql.fabric.jdbc.FabricMySQLDriver;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Acer on 19.10.2016.
 */
public class ConnectionCreator {
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/snegurskiy"
                    +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //==============================================================================
    //регистрация драйвера
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //==============================================================================
    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                {

                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);}
            }
        }
        return connection;
    }
}
