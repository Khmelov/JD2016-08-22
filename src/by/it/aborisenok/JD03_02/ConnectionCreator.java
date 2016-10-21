package by.it.aborisenok.JD03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.ResourceBundle;

/**
 * Created by Лёша on 21.10.2016.
 */
public class ConnectionCreator {

    static {
        Driver driver = null;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("error: not register driver");
        }
    }


    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("by.it.aborisenok.JD03_02.config");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");


        if (connection == null || connection.isClosed()) {
            synchronized (url) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(url, user, password);
            }
        }
        return connection;
    }
}
