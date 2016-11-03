package by.it.aborisenok.project.java.connection;

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

    private static String bdName = "aborisenok";

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
        ResourceBundle resource = ResourceBundle.getBundle("by.it.aborisenok.JD03_03.connection.config");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");
        String useUnicode = resource.getString("db.useUnicode");
        String encoding = resource.getString("db.encoding");


        if (connection == null || connection.isClosed()) {
            synchronized (url) {
                if (connection == null || connection.isClosed())

                    connection = DriverManager.getConnection(url +  getBdName() + useUnicode + encoding, user, password);
            }
        }
        return connection;
    }

    public static String getBdName() {
        return bdName;
    }

    public static void setBdName(String Name) {
        bdName = Name;
    }
}
