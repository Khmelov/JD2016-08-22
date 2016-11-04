package by.it.shkantau.project.java.connection;

import com.google.gson.Gson;
import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionCreator {

    private static volatile Connection connection = null;
    private static String catalinaHome = System.getenv("CATALINA_HOME");
    private final static File file = new File(catalinaHome +"/bin/CSettings.json");
    public static String path = "";

    private static ConnectionSettingsPOJO connectionSettings;
    private static final Lock lock = new ReentrantLock();

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
        if (path.equals("")) {
            connectionSettings = (new Gson()).fromJson(new FileReader(file), ConnectionSettingsPOJO.class);
        }else{
            connectionSettings = (new Gson()).fromJson(new FileReader(path), ConnectionSettingsPOJO.class);
        }
        if (connection == null || connection.isClosed()) {
            try{
                lock.lock();
                if (connection == null || connection.isClosed()) {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(connectionSettings.getURL_DB(), connectionSettings.getUSER_DB(), connectionSettings.getPASSWORD_DB());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        return connection;
    }

}
