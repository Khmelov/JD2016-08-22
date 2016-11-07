package by.it.voronovich.project.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import static by.it.voronovich.project.java.connection.ConnectionData.*;

public class ConnectionCreator {

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

