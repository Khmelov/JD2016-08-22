package by.it.shkantau.jd03.jd03_01;

import com.google.gson.Gson;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private static volatile Connection connection = null;
    private final static File file = new File(System.getProperty("user.dir") + "/src/by/it/shkantau/jd03/jd03_01/CSettings.json");
    private static ConnectionSettingsPOJO connectionSettings;


    static {
        Driver driver;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static Connection getConnection() throws SQLException, FileNotFoundException {
         connectionSettings = (new Gson()).fromJson(new FileReader(file), ConnectionSettingsPOJO.class);

        if (connection == null || connection.isClosed()) {
                synchronized (ConnectionSettingsPOJO.lock) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(connectionSettings.getURL_DB(), connectionSettings.getUSER_DB(), connectionSettings.getPASSWORD_DB());
                }
        }
        return connection;
    }

}
