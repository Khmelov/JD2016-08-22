package by.it.shkantau.project.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import by.it.shkantau.project.java.controller.FrontController;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionCreator {

    private static volatile Connection connection = null;

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

        if (connection == null || connection.isClosed()) {
            try{
                lock.lock();
                if (connection == null || connection.isClosed()) {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection(FrontController.connectionSettings.getURL_DB(), FrontController.connectionSettings.getUSER_DB(), FrontController.connectionSettings.getPASSWORD_DB());
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
