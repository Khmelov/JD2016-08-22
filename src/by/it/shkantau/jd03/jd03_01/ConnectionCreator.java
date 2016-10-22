package by.it.shkantau.jd03.jd03_01;

import com.google.gson.Gson;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import com.sun.jmx.snmp.agent.SnmpUserDataFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    static {
        Driver driver;
        try {
            driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.out.println("error: not register driver");
        }

    }

    private static volatile Connection connection = null;
    private final static File file = new File(System.getProperty("user.dir") + "/src/by/it/shkantau/jd03/jd03_01/CSettings.json");
    private static ConnectionSettingsPOJO cs;

    Gson gson = new Gson();

    public static Connection getConnection() throws SQLException, FileNotFoundException {
         cs = (new Gson()).fromJson(new FileReader(file), ConnectionSettingsPOJO.class);

        if (connection == null || connection.isClosed()) {
                synchronized (ConnectionSettingsPOJO.lock) {
                    if (connection == null || connection.isClosed())
                        connection = DriverManager.getConnection(cs.getURL_DB(), cs.getUSER_DB(), cs.getPASSWORD_DB());
                }
        }
        return connection;
    }

}
